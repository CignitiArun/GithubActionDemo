package org.example;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.json.support.Status;
import org.example.utils.Constants;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;

import java.io.File;
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

	/*
	 * @AfterSuite public void afterSuite() { String reportPath =
	 * Constants.CUCUMBER_REPORTS + File.separator + new
	 * SimpleDateFormat("dd-MM-yyyy_HH_mm_ss_SSS").format(new Date()); File
	 * reportOutputDirectory = new File(reportPath); List<String> jsonFiles = new
	 * ArrayList<>(); String cucumberJson = "target/cucumber-reports/Cucumber.json";
	 * jsonFiles.add(cucumberJson);
	 * 
	 * String buildNumber = "1"; String projectName = "Demo";
	 * 
	 * Configuration configuration = new Configuration(reportOutputDirectory,
	 * projectName);
	 * configuration.setNotFailingStatuses(Collections.singleton(Status.SKIPPED));
	 * configuration.setBuildNumber(buildNumber); ReportBuilder reportBuilder = new
	 * ReportBuilder(jsonFiles, configuration); reportBuilder.generateReports(); }
	 */

}