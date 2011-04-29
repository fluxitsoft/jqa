package ar.com.fluxit.jqa.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Collections;

import junit.framework.Assert;

import org.apache.maven.shared.invoker.DefaultInvocationRequest;
import org.apache.maven.shared.invoker.DefaultInvoker;
import org.apache.maven.shared.invoker.InvocationRequest;
import org.apache.maven.shared.invoker.Invoker;
import org.apache.maven.shared.invoker.MavenInvocationException;

import ar.com.fluxit.jqa.result.CheckingResult;
import ar.com.fluxit.jqa.result.RuleCheckFailed;

import com.thoughtworks.xstream.XStream;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class JQAPluginRunner {

	public static class Counter {
		public int count = 0;
	}

	private static void assertContains(CheckingResult result, String ruleName, String targetClassName, Counter assertsCount) {
		boolean founded = false;
		for (RuleCheckFailed fail : result.getRuleChecksFailed()) {
			if (ruleName.equals(fail.getRuleName()) && targetClassName.equals(fail.getTargetClassName())) {
				founded = true;
			}
		}
		Assert.assertTrue("Expected fail: ruleName(" + ruleName + ") targetClassName(" + targetClassName + ")", founded);
		assertsCount.count++;
	}

	private static void doAsserts(CheckingResult result) {
		Assert.assertNotNull(result);
		Counter assertsCount = new Counter();
		assertContains(result, "BO contract naming", "ar.com.fluxit.jqa.test.bo.BOForTrucks", assertsCount);
		assertContains(result, "DAO contract naming", "ar.com.fluxit.jqa.test.dao.DAOForTrucks", assertsCount);
		assertContains(result, "Cant use XStream", "ar.com.fluxit.jqa.test.dummy.ClassThatUsesXStream", assertsCount);
		assertContains(result, "DAO contract typing", "ar.com.fluxit.jqa.test.dao.InvalidDAO", assertsCount);
		assertContains(result, "BO contract typing", "ar.com.fluxit.jqa.test.bo.InvalidBO", assertsCount);
		// assertContains(result, "", "", assertsCount);
		Assert.assertEquals(result.getRuleChecksFailed().size(), assertsCount.count);
	}

	private static void installJQAPluginCheck() throws MavenInvocationException {
		InvocationRequest request = new DefaultInvocationRequest();
		request.setPomFile(new File("../../pom.xml"));
		request.setGoals(Collections.singletonList("clean install"));
		Invoker invoker = new DefaultInvoker();
		invoker.execute(request);
	}

	public static void main(String[] args) {
		try {
			String mavenHomeArg = args[0];
			String jqaVersionArg = args[1];
			System.setProperty("maven.home", mavenHomeArg);
			installJQAPluginCheck();
			runJQAPluginCheck(jqaVersionArg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void runJQAPluginCheck(String jqaVersionArg) throws MavenInvocationException, FileNotFoundException, IOException {
		InvocationRequest request = new DefaultInvocationRequest();
		request.setPomFile(new File("../pom.xml"));
		request.setGoals(Collections.singletonList("ar.com.fluxit.jqa:jqa-maven-plugin:" + jqaVersionArg + ":check"));
		request.setDebug(true);
		Invoker invoker = new DefaultInvoker();
		invoker.execute(request);
		final File resultsFile = new File("../jqa-test-project/target/results-jqa-test-project.xml");
		final Reader r = new FileReader(resultsFile);
		final Reader in = new BufferedReader(r);
		final XStream xs = new XStream();
		xs.setMode(XStream.NO_REFERENCES);
		CheckingResult result = (CheckingResult) xs.fromXML(in);
		in.close();
		doAsserts(result);
		System.out.println("Done, all asserts are OK !");
	}

}
