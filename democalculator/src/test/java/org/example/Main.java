package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        File jsonFile = new File("src\\\\test\\\\resources\\\\Example.json");
        ObjectMapper mapper = new ObjectMapper();
        List<Map<String, Object>> data;
        try {
            data = mapper.readValue(jsonFile, List.class);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        String sheetName = "Add";
        String testCaseName = "TestCase1";
        Map<String, Object> testCaseData = getTestCaseData(data, sheetName, testCaseName);
        System.out.println(testCaseData);
    }

    public static Map<String, Object> getTestCaseData(List<Map<String, Object>> data, String sheetName, String testCaseName) {
        for (Map<String, Object> sheetData : data) {
            if (sheetData.get("SheetName").equals(sheetName)) {
                return (Map<String, Object>) sheetData.get(testCaseName);
            }
        }
        return null;
    }
}