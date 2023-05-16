package org.example.stepdefs;

import io.cucumber.java.en.Given;
import org.example.World;

public class AddStepDef {
    World world;

   public AddStepDef(World world) {
        this.world = world;
    }

    @Given("I add {int} and {int}")
    public void iAddAndTheADDServiceShouldReturnMe(int arg0, int arg1) {
        world.addServiceResponse = world.calculatorSoapIns.add(arg0, arg1);
    }
    
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

}
