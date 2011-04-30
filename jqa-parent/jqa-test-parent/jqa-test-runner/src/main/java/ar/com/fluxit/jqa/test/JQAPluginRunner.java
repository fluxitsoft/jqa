package ar.com.fluxit.jqa.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

	private static RuleCheckFailed assertContains(CheckingResult result, String ruleName, String targetClassName, List<RuleCheckFailed> fails) {
		RuleCheckFailed founded = null;
		for (RuleCheckFailed fail : result.getRuleChecksFailed()) {
			if (ruleName.equals(fail.getRuleName()) && targetClassName.equals(fail.getTargetClassName())) {
				founded = fail;
				fails.remove(fail);
			}
		}
		Assert.assertTrue("Expected fail: ruleName(" + ruleName + ") targetClassName(" + targetClassName + ")", founded != null);
		return founded;
	}

	private static void doAsserts(CheckingResult result) {
		Assert.assertNotNull(result);
		final List<RuleCheckFailed> fails = new ArrayList<RuleCheckFailed>(result.getRuleChecksFailed());

		assertContains(result, "DAO contract rule", "ar.com.fluxit.jqa.test.dao.DAOForTrucks", fails);
		assertContains(result, "DAO contract rule", "ar.com.fluxit.jqa.test.dao.CarDAO", fails);
		assertContains(result, "DAO contract rule", "ar.com.fluxit.jqa.test.daos.TrainDAO", fails);

		// assertContains(result, "BO contract naming",
		// "ar.com.fluxit.jqa.test.bo.BOForTrucks", fails);
		// assertContains(result, "Cant use XStream",
		// "ar.com.fluxit.jqa.test.utils.Commons", fails);
		// assertContains(result, "BO contract definition",
		// "ar.com.fluxit.jqa.test.bo.MotorcycleBO", fails);
		// assertContains(result, "BO contract definition",
		// "ar.com.fluxit.jqa.test.bo.impl.TruckBO", fails);
		// assertContains(result, "BO implementation naming",
		// "ar.com.fluxit.jqa.test.bo.impl.TruckBO", fails);
		// assertContains(result, "", "");
		Assert.assertEquals(fails.size() + " not expected fails: " + fails.toString(), 0, fails.size());
	}

	public static void main(String[] args) {
		try {
			if (args.length != 2) {
				System.out.print("Required arguments: mavenPath, JQAVersion");
			} else {
				String mavenHomeArg = args[0];
				String jqaVersionArg = args[1];
				System.setProperty("maven.home", mavenHomeArg);
				// installJQAPluginCheck();
				runJQAPluginCheck(jqaVersionArg);
			}
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
