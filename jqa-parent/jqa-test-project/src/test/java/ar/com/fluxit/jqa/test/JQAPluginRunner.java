package ar.com.fluxit.jqa.test;

import java.io.BufferedReader;
import java.io.File;
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

import com.thoughtworks.xstream.XStream;

public class JQAPluginRunner {

	private CheckingResult checkingResult;

	public static void main(String[] args) throws Exception {
		JQAPluginRunner jqaPluginTest = new JQAPluginRunner();
		jqaPluginTest.setUp();
		jqaPluginTest.testRunJQAPlugin();		
	}
	
	protected void setUp() throws Exception {
		InvocationRequest request = new DefaultInvocationRequest();
		request.setPomFile(new File(getClass().getClassLoader().getResource(
				"pom.xml").getFile()));
		request.setDebug(true);
		request.setGoals(Collections
				.singletonList("ar.com.fluxit:jqa-maven-plugin:1.0:check"));
		Invoker invoker = new DefaultInvoker();
		invoker.execute(request);

		final Reader r = new FileReader(getClass().getClassLoader()
				.getResource("results-jqa-test-project.xml").getFile());
		final Reader input = new BufferedReader(r);

		final XStream xs = new XStream();
		xs.setMode(XStream.NO_REFERENCES);
		checkingResult = (CheckingResult) xs.fromXML(input);
		input.close();
	}


	public void testRunJQAPlugin() throws MavenInvocationException, IOException {
		Assert.assertNotNull(checkingResult);
		Assert.assertNotNull(checkingResult.getDate());
		// assertContains(checkingResult, "targetClassName", "predicateName");
	}
}
