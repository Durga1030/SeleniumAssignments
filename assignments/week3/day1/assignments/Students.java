package week3.day1.assignments;

public class Students {
	public void getStudentInfo(int id) {
		System.out.println("Student Id: " + id);
	}

	public void getStudentInfo(int id, String name) {
		System.out.println("Student Id: " + id + " & " + "Name: " + name);
	}

	public void getStudentInfo(String email, long phonenumber) {
		System.out.println("Student Emailid: " + email + " & " + "PhoneNumber: " + phonenumber);
	}

	public static void main(String[] args) {
		Students stdnt = new Students();
		stdnt.getStudentInfo(1001);
		stdnt.getStudentInfo(1001, "Alexa");
		stdnt.getStudentInfo("xyz@gmail.com", 999999999);

	}
}
