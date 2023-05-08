package org.example.stepdefs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.example.World;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;

public class AddStepDef {
	World world;

	public AddStepDef(World world) {
		this.world = world;
	}

	String path;
	String sheetId;
	String testCaseId;

	/*
	 * @Before("@AddServiceExample") public void readScenarioOutlineData(Scenario
	 * scenario) throws FileNotFoundException { String scenrioLine =
	 * scenario.getName(); Pattern pattern = Pattern.compile("\"([^\"]*)\"");
	 * Matcher matcher = pattern.matcher(scenrioLine); List<String> matches = new
	 * ArrayList<>(); while (matcher.find()) { matches.add(matcher.group(1)); }
	 * 
	 * path = matches.get(0); // Example.json sheetId = matches.get(1); // Add
	 * testCaseId = matches.get(2); // TestCase1 returnTestDataReadingFromJson(path,
	 * sheetId, testCaseId);
	 * 
	 * }
	 */

	public Map<String, String> returnTestDataReadingFromJson(String path, String sheetId, String testCaseId)
			throws FileNotFoundException {
		path = "src\\test\\resources\\" + path;
		BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
		Gson gson = new Gson();
		HashMap<String, String> testData = new HashMap<String, String>();
		JsonArray jsonArray = gson.fromJson(bufferedReader, JsonArray.class);

		for (JsonElement element : jsonArray) {
			if (element.isJsonObject()) {
				JsonObject jsonObject = element.getAsJsonObject();
				if (jsonObject.has("SheetName") && jsonObject.get("SheetName").getAsString().equals("Add")) {
					JsonObject testData1 = jsonObject.getAsJsonObject("TestData1");
					String num1 = testData1.get("num1").getAsString();
					String num2 = testData1.get("num2").getAsString();
					System.out.println("num1: " + num1);
					System.out.println("num2: " + num2);
				}
			}
		}

		System.out.println("Test Data is " + testData);
		return testData;
	}

	@Given("I add {int} and {int}")
	public void iAdd(int num1, int num2) {
		world.addServiceResponse = world.calculatorSoapIns.add(num1, num2);
	}

	/*
	 * @DataTableType(replaceWithEmptyString = "[blank]") public Integer
	 * integer(String value) { return value.equals("[blank]") ? null :
	 * Integer.parseInt(value); }
	 */

	@Given("I get the data from file {string} from {int} for addition")
	public void theDataInFile(String fileName, int index) throws Exception {
		File file = new File(getClass().getClassLoader().getResource(fileName.replaceAll("\"", "")).getFile());
		String jsonData = new String(Files.readAllBytes(Paths.get(file.getAbsolutePath())));
		ObjectMapper mapper = new ObjectMapper();
		List<Map<String, Integer>> data = mapper.readValue(jsonData, List.class);
		world.exampleData = data;
		Map<String, Integer> dataMap = world.exampleData.get(index);
		int num1 = dataMap.get("num1");
		int num2 = dataMap.get("num2");
		world.addServiceResponse = world.calculatorSoapIns.add(num1, num2);

	}
	
	

	/*
	 * @Given("I add the numbers from the data at index {int}") public void
	 * iAddTheNumbersFromTheDataAtIndex(int index) { Map<String, Integer> dataMap =
	 * world.exampleData.get(index); int num1 = dataMap.get("num1"); int num2 =
	 * dataMap.get("num2"); world.addServiceResponse =
	 * world.calculatorSoapIns.add(num1, num2); }
	 */
}
