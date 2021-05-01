package week3.day1.assignments;

public class AbstractCollege extends AbstractUniversity {

	public static void main(String[] args) {

		AbstractCollege clg = new AbstractCollege();
		clg.ug();
		clg.pg();

	}

	@Override
	public void ug() {
		System.out.println("Execute Under-Graduate");

	}

}
