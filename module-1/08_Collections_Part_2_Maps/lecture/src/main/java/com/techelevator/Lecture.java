package com.techelevator;
import java.util.*;

public class Lecture {

	public static void main(String[] args) {
		Set<String> names = new HashSet<>();
		names.add("Dave");
		names.add("Tyler");
		System.out.println(names.size()); // Should be 2 at this point.
		names.add("Dave");

		//Entries are case-sensitive. A name "DAVE" will be a different entry than "Dave".

		System.out.println(names.size()); // Should be 2 at this point as well. Sets are unique, no repeated elements.
		if (names.contains("Tyler")) {
			System.out.println("Your set contains Tyler.");
		}
		for (String name : names) {
			System.out.println(name);
		}



		System.out.println("####################");
		System.out.println("        MAPS");
		System.out.println("####################");
		System.out.println();

		Map<String, String> stateAbbrevs = new HashMap<>();
		stateAbbrevs.put("AZ", "Arizona");

		String arizona = stateAbbrevs.get("AZ");
		String hawaii = stateAbbrevs.get("HI"); // Hawaii dne in stateAbbrevs, hawaii will be == null. (not .equals());

		stateAbbrevs.put("oh", "Ohio");

		Lecture lecture = new Lecture();
		String stateName = lecture.getStateName(stateAbbrevs, "ZZ");
		System.out.println(stateName);

		Set<String> stateKeys = stateAbbrevs.keySet(); //.keySet() returns a set of keys.
		for (String stateKey : stateKeys) {
			System.out.println(stateKey + ": " + stateAbbrevs.get(stateKey));
		}
		//A map of fictional shipping statuses.

		Map<Integer, String> statuses = new HashMap<>();
		statuses.put(1, "Order Received");
		statuses.put(2, "Label printed");
		statuses.put(3, "In transit");
		statuses.put(4, "Delivered");

		///Auto-boxing and nulls
		Map<String, Boolean> swJedis = new HashMap<String, Boolean>();
		swJedis.put("Luke", true);

		boolean isLandoJedi = swJedis.get("Lando");
		System.out.print(isLandoJedi);

	}
	public String getStateName(Map<String, String> stateAbbrevs, String abbreviation){
		/*String stateName = stateAbbrevs.get(abbreviation);
		if (stateName == null) {
			return "Unknown";
		}*/
		if (stateAbbrevs.containsKey(abbreviation)) {   //.containsKey returns true or false if the key is found within the map.
			return stateAbbrevs.get(abbreviation);
		}
		return "Unknown";
	}
}
