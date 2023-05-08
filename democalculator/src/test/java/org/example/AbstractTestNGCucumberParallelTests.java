package org.example;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.json.support.Status;
import org.example.utils.Constants;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

public abstract class AbstractTestNGCucumberParallelTests extends AbstractTestNGCucumberTests {
	private final Logger LOG = Logger.getLogger(AbstractTestNGCucumberParallelTests.class.getName());

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}

	@AfterSuite
	public void afterSuite() {
		String reportPath = Constants.CUCUMBER_REPORTS + File.separator
				+ new SimpleDateFormat("dd-MM-yyyy_HH_mm_ss_SSS").format(new Date());
		File reportOutputDirectory = new File(reportPath);
		List<String> jsonFiles = new ArrayList<>();
		String cucumberJson = "target/cucumber-reports/Cucumber.json";
		jsonFiles.add(cucumberJson);

		/*
		 * String buildNumber = "1"; String projectName = "Demo";
		 * 
		 * Configuration configuration = new Configuration(reportOutputDirectory,
		 * projectName);
		 * configuration.setNotFailingStatuses(Collections.singleton(Status.SKIPPED));
		 * configuration.setBuildNumber(buildNumber); ReportBuilder reportBuilder = new
		 * ReportBuilder(jsonFiles, configuration); reportBuilder.generateReports();
		 */

		String buildNumber = "1";
		String projectName = "Demo";

		// Load the Cucumber JSON report file into a JSON object
		JSONParser parser = new JSONParser();
		try {
			Object obj = parser.parse(new FileReader(cucumberJson));
			JSONObject jsonReport = (JSONObject) obj;

			// Loop through each feature in the report
			JSONArray jsonFeatures = (JSONArray) jsonReport.get("features");
			for (Object featureObj : jsonFeatures) {
				JSONObject jsonFeature = (JSONObject) featureObj;

				// Loop through each scenario in the feature
				JSONArray jsonScenarios = (JSONArray) jsonFeature.get("elements");
				for (Object scenarioObj : jsonScenarios) {
					JSONObject jsonScenario = (JSONObject) scenarioObj;

					// Loop through each step in the scenario
					JSONArray jsonSteps = (JSONArray) jsonScenario.get("steps");
					for (Object stepObj : jsonSteps) {
						JSONObject jsonStep = (JSONObject) stepObj;

						// Check the result status of the step and modify the JSON object accordingly
						JSONObject jsonResult = (JSONObject) jsonStep.get("result");
						String status = (String) jsonResult.get("status");
						if (status.equals("passed")) {
							jsonStep.put("status", "pass");
						} else if (status.equals("failed")) {
							jsonStep.put("status", "fail");
						} else {
							jsonStep.put("status", "skip");
						}
					}
				}
			}

			// Write the modified JSON object back to the Cucumber JSON report file
			FileWriter file = new FileWriter(cucumberJson);
			file.write(jsonReport.toJSONString());
			file.flush();
			file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Generate the report using the modified Cucumber JSON report file
		Configuration configuration = new Configuration(reportOutputDirectory, projectName);
		configuration.setNotFailingStatuses(Collections.singleton(Status.SKIPPED));
		configuration.setBuildNumber(buildNumber);
		ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
		reportBuilder.generateReports();
	}

}