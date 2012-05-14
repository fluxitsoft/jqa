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
public class JQAMavenPluginRunner {

	private static RuleCheckFailed assertContains(CheckingResult result, String ruleName, String targetClassName, List<RuleCheckFailed> fails) {
		RuleCheckFailed found = null;
		for (RuleCheckFailed fail : result.getRuleChecksFailed()) {
			if (ruleName.equals(fail.getRuleName()) && targetClassName.equals(fail.getTargetClassName())) {
				found = fail;
				fails.remove(fail);
			}
		}
		Assert.assertTrue("Expected fail did not occur: ruleName(" + ruleName + ") targetClassName(" + targetClassName + ")", found != null);
		return found;
	}

	private static void doAsserts(CheckingResult result) {
		Assert.assertNotNull(result);
		final List<RuleCheckFailed> fails = new ArrayList<RuleCheckFailed>(result.getRuleChecksFailed());
		// Naming asserts
		assertContains(result, "BO contract naming", "ar.com.fluxit.jqa.test.bo.BOForTrucks", fails);
		assertContains(result, "BO contract naming", "ar.com.fluxit.jqa.test.bos.TrainBO", fails);
		assertContains(result, "BO contract naming", "ar.com.fluxit.jqa.test.bo.impl.BusBO", fails);
		assertContains(result, "BO implementation naming", "ar.com.fluxit.jqa.test.bo.impl.BOForTrucksImpl", fails);
		assertContains(result, "BO implementation naming", "ar.com.fluxit.jqa.test.bo.MotorcycleBO", fails);
		assertContains(result, "BO implementation naming", "ar.com.fluxit.jqa.test.bos.impl.TrainBOImpl", fails);
		assertContains(result, "DAO contract naming", "ar.com.fluxit.jqa.test.dao.DAOForTrucks", fails);
		assertContains(result, "DAO contract naming", "ar.com.fluxit.jqa.test.daos.TrainDAO", fails);
		assertContains(result, "DAO contract naming", "ar.com.fluxit.jqa.test.dao.impl.BusDAO", fails);
		assertContains(result, "DAO implementation naming", "ar.com.fluxit.jqa.test.dao.impl.DAOForTrucksImpl", fails);
		assertContains(result, "DAO implementation naming", "ar.com.fluxit.jqa.test.dao.MotorcycleDAO", fails);
		assertContains(result, "DAO implementation naming", "ar.com.fluxit.jqa.test.daos.impl.TrainDAOImpl", fails);
		assertContains(result, "Service contract naming", "ar.com.fluxit.jqa.test.service.ServiceForTrucks", fails);
		assertContains(result, "Service contract naming", "ar.com.fluxit.jqa.test.services.TrainService", fails);
		assertContains(result, "Service contract naming", "ar.com.fluxit.jqa.test.service.impl.BusService", fails);
		assertContains(result, "Service implementation naming", "ar.com.fluxit.jqa.test.service.impl.ServiceForTrucksImpl", fails);
		assertContains(result, "Service implementation naming", "ar.com.fluxit.jqa.test.service.MotorcycleService", fails);
		assertContains(result, "Service implementation naming", "ar.com.fluxit.jqa.test.services.impl.TrainServiceImpl", fails);
		assertContains(result, "Entity naming", "ar.com.fluxit.jqa.test.entities.vehicles.Car", fails);
		assertContains(result, "Entity naming", "ar.com.fluxit.jqa.test.domain.vehicles.Boat", fails);
		// Typing asserts
		assertContains(result, "BO contract typing", "ar.com.fluxit.jqa.test.bo.CarBO", fails);
		assertContains(result, "BO implementation typing", "ar.com.fluxit.jqa.test.bo.impl.CarBOImpl", fails);
		assertContains(result, "BO implementation typing", "ar.com.fluxit.jqa.test.bo.impl.MotorcycleBOImpl", fails);
		assertContains(result, "BO implementation typing", "ar.com.fluxit.jqa.test.bo.MotorcycleBO", fails);
		assertContains(result, "DAO contract typing", "ar.com.fluxit.jqa.test.dao.CarDAO", fails);
		assertContains(result, "DAO implementation typing", "ar.com.fluxit.jqa.test.dao.impl.CarDAOImpl", fails);
		assertContains(result, "DAO implementation typing", "ar.com.fluxit.jqa.test.dao.impl.MotorcycleDAOImpl", fails);
		assertContains(result, "DAO implementation typing", "ar.com.fluxit.jqa.test.dao.MotorcycleDAO", fails);
		assertContains(result, "Service contract typing", "ar.com.fluxit.jqa.test.service.CarService", fails);
		assertContains(result, "Service implementation typing", "ar.com.fluxit.jqa.test.service.impl.CarServiceImpl", fails);
		assertContains(result, "Service implementation typing", "ar.com.fluxit.jqa.test.service.impl.MotorcycleServiceImpl", fails);
		assertContains(result, "Service implementation typing", "ar.com.fluxit.jqa.test.service.MotorcycleService", fails);
		assertContains(result, "Entity typing", "ar.com.fluxit.jqa.test.entity.vehicles.Motorcycle", fails);
		// Usages asserts
		assertContains(result, "Service contract usages", "ar.com.fluxit.jqa.test.service.CarService", fails);
		assertContains(result, "Service contract usages", "ar.com.fluxit.jqa.test.service.BoatService", fails);
		assertContains(result, "Service implementation usages", "ar.com.fluxit.jqa.test.service.MotorcycleService", fails);
		assertContains(result, "Service implementation usages", "ar.com.fluxit.jqa.test.service.MotorcycleService", fails);
		assertContains(result, "Service implementation usages", "ar.com.fluxit.jqa.test.service.impl.MotorcycleServiceImpl", fails);
		assertContains(result, "Service implementation usages", "ar.com.fluxit.jqa.test.service.impl.ServiceForTrucksImpl", fails);
		assertContains(result, "Service implementation usages", "ar.com.fluxit.jqa.test.services.impl.TrainServiceImpl", fails);
		assertContains(result, "BO contract usages", "ar.com.fluxit.jqa.test.bo.CarBO", fails);
		assertContains(result, "BO contract usages", "ar.com.fluxit.jqa.test.bo.BoatBO", fails);
		assertContains(result, "BO implementation usages", "ar.com.fluxit.jqa.test.bo.MotorcycleBO", fails);
		assertContains(result, "BO implementation usages", "ar.com.fluxit.jqa.test.bo.impl.MotorcycleBOImpl", fails);
		assertContains(result, "BO implementation usages", "ar.com.fluxit.jqa.test.bos.impl.TrainBOImpl", fails);
		assertContains(result, "DAO contract usages", "ar.com.fluxit.jqa.test.dao.CarDAO", fails);
		assertContains(result, "DAO implementation usages", "ar.com.fluxit.jqa.test.dao.MotorcycleDAO", fails);
		assertContains(result, "DAO implementation usages", "ar.com.fluxit.jqa.test.dao.impl.MotorcycleDAOImpl", fails);
		assertContains(result, "View usages", "ar.com.fluxit.jqa.test.view.actions.CarAction", fails);
		assertContains(result, "View usages", "ar.com.fluxit.jqa.test.view.actions.TrainAction", fails);
		// Throwing asserts
		assertContains(result, "Service throwing", "ar.com.fluxit.jqa.test.service.BoatService", fails);
		assertContains(result, "Service throwing", "ar.com.fluxit.jqa.test.service.impl.BoatServiceImpl", fails);
		assertContains(result, "Service throwing", "ar.com.fluxit.jqa.test.service.impl.ServiceForTrucksImpl", fails);
		assertContains(result, "BO throwing", "ar.com.fluxit.jqa.test.bo.MotorcycleBO", fails);
		assertContains(result, "BO throwing", "ar.com.fluxit.jqa.test.bo.BoatBO", fails);
		assertContains(result, "BO throwing", "ar.com.fluxit.jqa.test.bo.impl.BoatBOImpl", fails);
		assertContains(result, "BO throwing", "ar.com.fluxit.jqa.test.bo.impl.BOForTrucksImpl", fails);
		assertContains(result, "DAO throwing", "ar.com.fluxit.jqa.test.dao.MotorcycleDAO", fails);
		assertContains(result, "DAO throwing", "ar.com.fluxit.jqa.test.dao.impl.BoatDAOImpl", fails);
		assertContains(result, "DAO throwing", "ar.com.fluxit.jqa.test.dao.BoatDAO", fails);
		assertContains(result, "DAO throwing", "ar.com.fluxit.jqa.test.dao.impl.DAOForTrucksImpl", fails);
		// Allocation asserts
		assertContains(result, "Service allocation", "ar.com.fluxit.jqa.test.services.impl.TrainServiceImpl", fails);
		assertContains(result, "BO allocation", "ar.com.fluxit.jqa.test.bos.impl.TrainBOImpl", fails);
		assertContains(result, "DAO allocation", "ar.com.fluxit.jqa.test.dao.impl.CarDAOImpl", fails);
		assertContains(result, "View allocation", "ar.com.fluxit.jqa.test.view.actions.TrainAction", fails);
		assertContains(result, "View allocation", "ar.com.fluxit.jqa.test.view.actions.CarAction", fails);
		// Abstraction asserts
		assertContains(result, "Contract abstraction", "ar.com.fluxit.jqa.test.service.MotorcycleService", fails);
		assertContains(result, "Contract abstraction", "ar.com.fluxit.jqa.test.bo.MotorcycleBO", fails);
		assertContains(result, "Contract abstraction", "ar.com.fluxit.jqa.test.dao.MotorcycleDAO", fails);
		assertContains(result, "Implementation abstraction", "ar.com.fluxit.jqa.test.service.impl.BusService", fails);
		assertContains(result, "Implementation abstraction", "ar.com.fluxit.jqa.test.bo.impl.BusBO", fails);
		assertContains(result, "Implementation abstraction", "ar.com.fluxit.jqa.test.dao.impl.BusDAO", fails);

		Assert.assertEquals(fails.size() + " unexpected fails occurred: " + fails.toString(), 0, fails.size());
	}

	public static void main(String[] args) {
		try {
			if (args.length != 2) {
				System.out.print("Required arguments: mavenPath, JQAVersion");
			} else {
				String mavenHomeArg = args[0];
				String jqaVersionArg = args[1];
				System.setProperty("maven.home", mavenHomeArg);
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
