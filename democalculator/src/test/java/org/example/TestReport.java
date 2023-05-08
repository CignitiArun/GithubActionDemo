package org.example;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.example.utils.Constants;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.json.support.Status;

public class TestReport {

	public static void main(String[] args) throws IOException, ParseException {
		String reportPath = Constants.CUCUMBER_REPORTS + File.separator
				+ new SimpleDateFormat("dd-MM-yyyy_HH_mm_ss_SSS").format(new Date());
		File reportOutputDirectory = new File(reportPath);
		List<String> jsonFiles = new ArrayList<>();
		String cucumberJson = "target/cucumber-reports/Cucumber.json";
		jsonFiles.add(cucumberJson);
		String buildNumber = "1";
		String projectName = "Demo";
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader(cucumberJson));
		JSONArray arr = (JSONArray) obj;
		for (Object scenario : arr) {
			JSONObject scenarioObj = (JSONObject) scenario;
			JSONArray elements = (JSONArray) scenarioObj.get("elements");
			for (Object element : elements) {
				JSONObject elementObj = (JSONObject) element;
				JSONArray stepsArray = (JSONArray) elementObj.get("steps");
				for (int i = 0; i < stepsArray.size(); i++) {
					stepsArray.remove(i);
					System.out.println("BEFORE STEPS ARRAY IS " + stepsArray);
					stepsArray = (JSONArray) elementObj.get("steps");
					if (stepsArray.size() == i) {
						break;
					}
				}
				JSONObject beforeObject = (JSONObject) stepsArray.get(stepsArray.size() - 1);
				JSONArray beforeArray = (JSONArray) beforeObject.get("before");
				JSONObject resultObj = (JSONObject) beforeArray.get(0);
				JSONArray outputArray = (JSONArray) resultObj.get("output");
				outputArray.get(0);
				System.out.println(outputArray.get(0));
				FileWriter file = new FileWriter(cucumberJson);
				file.write(arr.toJSONString());
				file.flush();
				file.close();
			}
		}
		FileWriter file = new FileWriter(cucumberJson);
		file.write(arr.toJSONString());
		file.flush();
		file.close();
	}
}
