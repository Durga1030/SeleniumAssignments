package week3.day1.assignments;

public class AbstractDesktop implements AbstractHardware, AbstractSoftware {

	public static void main(String[] args) {

		AbstractDesktop desktop = new AbstractDesktop();
		desktop.softwareResources();
		desktop.hardwareResources();
	}

	public static void desktopModel() {
		System.out.println("Desktop Model");

	}

	public boolean softwareResources() {
		return true;
	}

	private void hardwareResources() {
		System.out.println("Hardware resources");

	}

}
