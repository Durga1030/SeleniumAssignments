package week4.day1;

public class SampleDuplicate {

	public static void main(String[] args) {

		String resultantNumber = "INC0010254";
		String incidentNumber = "INC0010254";

		if (resultantNumber == incidentNumber) {
			System.out.println(resultantNumber + " incident has been created" + incidentNumber);
		} else {
			System.err.println(resultantNumber + " Incident creation process failure " + incidentNumber);
		}

	}

}
