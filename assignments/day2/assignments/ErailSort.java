package week3.day2.assignments;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ErailSort {

	public static void main(String[] args) throws InterruptedException {

//		Launch the browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

//		Launch the URL - https://erail.in/
		driver.get("https://erail.in/");
		driver.manage().window().maximize();

//		Uncheck the check box - sort on date

		// driver.findElement(By.id("chkSelectDateOnly")).click();
		// System.out.println("Unchecked the Sort On Date");

//		Clear and type in the from station
		WebElement fromStation = driver.findElement(By.xpath("//input[@placeholder='From Station']"));
		fromStation.clear();
		fromStation.sendKeys("Tambaram");
		fromStation.sendKeys(Keys.TAB);

//		Clear and type in the to station
		WebElement toStation = driver.findElement(By.xpath("//input[@placeholder='To Station']"));
		toStation.clear();
		toStation.sendKeys("Tirunelveli");
		toStation.sendKeys(Keys.TAB);

// 		Click on Get trains
		driver.findElement(By.id("buttonFromTo")).click();

		System.out.println("--- Train Details ---");

		driver.findElement(By.id("chkSelectDateOnly")).click();

		Thread.sleep(2000);

//		Find all the train names using xpath and store it in a list
		List<WebElement> eleTrainList = driver.findElements(By.xpath("//div[@id='divTrainsList']/table[1]//td[2]"));
		System.out.println("Train count: " + eleTrainList.size());
		// Thread.sleep(2000);

		ArrayList<String> trainName = new ArrayList<String>();
		for (int i = 0; i < eleTrainList.size(); i++) {
			// System.out.println(trainName);

			trainName.add(eleTrainList.get(i).getText());

//		Use Java Collections sort to sort it and then print it

		}
		Collections.sort(trainName);
		System.out.println("Ascending order using Collection.sort: ");

		// for Each(System.out::println) -> each value needs to print in next line
		trainName.forEach(System.out::println);

	}

}
