package org.example.stepdefs;

import java.util.HashMap;

public class Test {

	public static void main(String[] args) {
		HashMap<String, String> testDataMap = new HashMap<>();
		String data = "{Non-stop preferences=Ignore, BACCI code=Ignore, Bound_Preference=Ignore, Calendar dates=Ignore, Card Holder Info=Ignore, Order Change Payer=Ignore, Held_Booking_Payment_Type=Ignore, Voucher Amount in RQ=Ignore, Voucher_Currency=Ignore, PNR=Ignore, Strict_Match_Of_Class=Ignore, Disruption Need Inbound Conne=Ignore, Point of sale=Ignore, Outbound Class to upgrade=Ignore, Cash Amount in RQ=Ignore, Card Type=Ignore, Raw PNR=Ignore, Agent=XA_GB_3012345, FQTV Type=Ignore, Disruption Need Outbound Conne=Ignore, Order_Change_Error_Category=Don't pay, Inbound Class to upgrade=Ignore, Time of arrival=Ignore, Email_Address_Actuall=sindhura.pilla@ba.com, Journey type=ACBA, Voucher_Owner_Travelling=Ignore, Aggregator_OrderCancel=Ignore, Country_Code=Ignore, Agent_Type=IATA, Instant/Held=Held, Travellers=2ADT,1YADT, Ancillary Amount % in RQ=Ignore, Card holder=Ignore}";
		String newData = data.replace("{", "").replace("}", "");
		String[] datasets = newData.split(",");
		for (int i = 0; i < datasets.length; i++) {
			String data1 = datasets[i];
			String[] keyValue = data1.split("=");
			if (keyValue.length == 2) {
				if (keyValue[0].equals("Travellers")) {
					String[] travellers = keyValue[1].split(",");
					int numAdults = 0;
					String result = "";
					for (String traveller : travellers) {
						if (traveller.contains("ADT")) {
							String[] travellerParts = traveller.split("ADT");
							numAdults += Integer.parseInt(travellerParts[0]);
						}
						else if (traveller.contains("YADT")) {
							String[] travellerParts = traveller.split("ADT");
							numAdults += Integer.parseInt(travellerParts[0]);
						}
						result += traveller + ",";
					}
					testDataMap.put(keyValue[0].trim(), result.substring(0, result.length() - 1));
					testDataMap.put("Number of adults", numAdults + " adult(s)");
				} else {
					testDataMap.put(keyValue[0].trim(), keyValue[1].trim());
				}
			}
		}
		System.out.println("TestData Map " + testDataMap);
	}
}
