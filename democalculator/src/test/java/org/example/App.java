package org.example;

import java.io.FileReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws Exception {
		
		/* ArrayList<String> arrayList = new ArrayList<String>();
	        arrayList.add("1");
	        arrayList.add("2");
	        arrayList.add("3");
	        arrayList.add("4");
	        arrayList.add("5");
	        arrayList.subList(1, 2).clear();
	        System.out.println(arrayList);*/
	        
		try (Reader reader = new FileReader("C:\\Users\\E009623\\git\\4dot8dot1Repo\\DemoCalculator\\src\\test\\resources\\Cucumber.json")) {
			Gson gson = new Gson();
			Type founderListType = new TypeToken<ArrayList<Report>>() {
			}.getType();
			List<Report> reportJSON = gson.fromJson(reader, founderListType);

			for (Report report : reportJSON) {
				for (Elements element : report.getElements()) {
					List<Steps> steps = element.getSteps();
					long instanceCount = steps.stream().filter(step -> step.getName().equals(steps.get(0).getName()))
							.count();

					System.out.println("Total Instances: " + instanceCount);
					int stepsCountInScenario = (int) (steps.size() / instanceCount);
					List<Integer> stepsToRemove = new ArrayList<>();
					for (int i = 0; i < steps.size(); i += stepsCountInScenario) {

						long failedCount = steps.subList(i, i + stepsCountInScenario).stream()
								.filter(step -> step.getResult().getStatus().equals("failed")).count();

						if (failedCount == 0) {
							System.out.println("success found at: " + i);

						} else if (failedCount > 0 && i != (steps.size() - stepsCountInScenario)) {
							System.out.println("no success found at: " + i);
							for (int j = i; j < stepsCountInScenario + i; j++) {

								stepsToRemove.add(j);
								// steps.remove(j);
							}

						} else if (failedCount > 0 && i == steps.size() - stepsCountInScenario) {
							System.out.println("no success found & hence return last:" + i);
						}

						// System.out.println("instance " + i + " completed && Failed Count: " +
						// failedCount);
					}
					System.out.println("steps to remove:" + stepsToRemove);
					if(stepsToRemove.size() > 0)
					steps.subList(stepsToRemove.get(0), stepsToRemove.get(stepsToRemove.size()-1)+1).clear();
					System.out.println("********** End of Element *********");
				}
			}
			String restaurantJson = gson.toJson(reportJSON);  
			System.out.println(restaurantJson);

			
		}
	}

}
