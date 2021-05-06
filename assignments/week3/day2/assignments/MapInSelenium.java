package week3.day2.assignments;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MapInSelenium {

	public static void main(String[] args) throws InterruptedException {

//1) Set the property
		WebDriverManager.chromedriver().setup();

//2) Initiate ChromeDriver class
		ChromeDriver driver = new ChromeDriver();

//3) Launch the URL - https://erail.in/
		driver.get("https://erail.in/");

//4) Maximize the browser
		driver.manage().window().maximize();

//5) Add implicityWait
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

//6) Clear and type in the from station
		WebElement fromStation = driver.findElement(By.xpath("//input[@placeholder='From Station']"));
		fromStation.clear();
		fromStation.sendKeys("Tambaram");
		fromStation.sendKeys(Keys.TAB);

//7) Clear and type in the to station
		WebElement toStation = driver.findElement(By.xpath("//input[@placeholder='To Station']"));
		toStation.clear();
		toStation.sendKeys("Tirunelveli");
		toStation.sendKeys(Keys.TAB);

//8) Uncheck the 'Sort on Date' checkbox	
		driver.findElement(By.id("chkSelectDateOnly")).click();
		System.out.println("Unchecked the Sort On Date");

//Click on Get trains
		driver.findElement(By.id("buttonFromTo")).click();

		System.out.println("--- Train Details ---");

		driver.findElement(By.id("chkSelectDateOnly")).click();

//9) Declare a Map
		// Map<String, String> map = new TreeMap<String, String>();

//10) Store the table in a web element
		List<WebElement> table = driver.findElementsByXPath("//table[contains(@class,'DataTable TrainList')]");
		// (By.xpath("//div[@id=\"divTrainsListHeader\"]/table/tbody/tr/th"));
		System.out.println("Table Size: " + table.size());

//11) Get all the rows and store it in a List
		List<WebElement> rows = driver.findElements(By.xpath("//table[contains(@class,'DataTable TrainList')]//tr"));
		System.out.println("Row size: " + rows.size());

//12) Iterate the rows and store all the columns in a List
		List<WebElement> column = driver.findElements(By.xpath("//div[@id='divTrainsListHeader']//td"));
		for (int i = 0; i < column.size(); i++) {
//			System.out.print(" | " + column.get(i).getText());
		}
//		System.out.print(" | ");
//		System.out.println(" ");
		for (int j = 0; j < rows.size(); j++) {

			// System.out.println(" | " + rows.get(j).getText() + " | ");
		}

		System.out.println("Process completed");

//13) Check and get the values that start with 'S' and If the condition satisfies add it into the map as key & value
		// Here i have used M instead of S in the condition.

		List<WebElement> trainValue = driver
				.findElements(By.xpath("(//table[contains(@class,'DataTable TrainList')]//td[2])"));

		String nameMatchedTrains, otherTrainNames;
		Map<String, String> map = new HashMap<String, String>();
		for (int i = 0; i < rows.size(); i++) {
			String trainName = trainValue.get(i).getText();
			// System.out.println(trainName);

			if (trainName.startsWith("M"))

			{
				nameMatchedTrains = trainName;
				map.put(nameMatchedTrains, nameMatchedTrains);

			} else {
				otherTrainNames = trainName;
				// System.out.println(otherTrainNames);

			}
		}

// 14) Print those values by iterating the map
		System.out.println(map.values());
	}

}