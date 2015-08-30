package test;

class SuperClass {
	private String lastName = "Ako";

	public String getLastName() {
		return lastName;
	}
}


public class TestClass extends SuperClass {

	private String firsName = "Samuel";

	public String getFirstName() {
		return firsName;
	}

	public String getFullName() {
		return super.getLastName() + ' ' + getFirstName();
	}

	public static void main(String[] args) {
		SuperClass test1 = new SuperClass();
		TestClass test2 = new TestClass();

		System.out.println (test1 instanceof TestClass);
		System.out.println (test2 instanceof TestClass);
	}
}