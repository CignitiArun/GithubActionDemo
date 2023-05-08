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

public class MultiplyStepDef {
	World world;

	public MultiplyStepDef(World world) {
		this.world = world;
	}

	String path;
	String sheetId;
	String testCaseId;

	@Given("I Multiply {int} and {int}")
	public void iMultiply(int num1, int num2) {
		world.multiplyServiceResponse = world.calculatorSoapIns.multiply(num1, num2);
	}

	@Given("I get the data from file {string} from {int} for Multiplication")
	public void theDataInFile(String fileName, int index) throws Exception {
		File file = new File(getClass().getClassLoader().getResource(fileName.replaceAll("\"", "")).getFile());
		String jsonData = new String(Files.readAllBytes(Paths.get(file.getAbsolutePath())));
		ObjectMapper mapper = new ObjectMapper();
		List<Map<String, Integer>> data = mapper.readValue(jsonData, List.class);
		world.exampleData = data;
		Map<String, Integer> dataMap = world.exampleData.get(index);
		int num1 = dataMap.get("num1");
		int num2 = dataMap.get("num2");
		world.multiplyServiceResponse = world.calculatorSoapIns.multiply(num1, num2);

	}

}
