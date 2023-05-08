package org.example.stepdefs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.example.World;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import io.cucumber.java.en.Given;

public class SubtractStepDef {
	World world;

	public SubtractStepDef(World world) {
		this.world = world;
	}

	@Given("I Subtract {int} and {int}")
	public void iAdd(int num1, int num2) {
		world.subtractServiceResponse = world.calculatorSoapIns.subtract(num1, num2);
	}

	@Given("I get the data from file {string} from {int} for Subtraction")
	public void theDataInFile(String fileName, int index) throws Exception {
		File file = new File(getClass().getClassLoader().getResource(fileName.replaceAll("\"", "")).getFile());
		String jsonData = new String(Files.readAllBytes(Paths.get(file.getAbsolutePath())));
		ObjectMapper mapper = new ObjectMapper();
		List<Map<String, Integer>> data = mapper.readValue(jsonData, List.class);
		world.exampleData = data;
		Map<String, Integer> dataMap = world.exampleData.get(index);
		int num1 = dataMap.get("num1");
		int num2 = dataMap.get("num2");
		world.subtractServiceResponse = world.calculatorSoapIns.subtract(num1, num2);

	}

}
