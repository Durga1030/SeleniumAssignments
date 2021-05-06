package week3.day2.assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ErailUnique {

	public static void main(String[] args) throws InterruptedException {

//		Set the system property and Launch the URL
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://erail.in/");
		driver.manage().window().maximize();

//		Click the 'sort on date' checkbox
		driver.findElement(By.id("chkSelectDateOnly")).click();

//		clear and type in the from station text field
		WebElement fromStation = driver.findElement(By.xpath("//input[@title='Type SOURCE station code or name']"));
		// driver.findElement(By.xpath("//input[@placeholder='From Station']"));
		fromStation.clear();
		fromStation.sendKeys("TPJ");
		fromStation.sendKeys(Keys.TAB);

//		clear and type in the to station text field
		WebElement toStation = driver.findElement(By.xpath("//input[@title='Enter DESTINATION station code or name']"));
		// driver.findElement(By.xpath("//input[@placeholder='To Station']"));
		toStation.clear();
		toStation.sendKeys("MMK");
		toStation.sendKeys(Keys.TAB);

//		Add a java sleep for 2 seconds
		Thread.sleep(1000);

//		Click on Get trains
		driver.findElement(By.id("buttonFromTo")).click();

		System.out.println("--- Train Details ---");

//		Store all the train names in a list
		List<WebElement> eleTrainList = driver.findElements(By.xpath("//div[@id='divTrainsList']/table[1]//td[2]"));
		List<String> trainName = new ArrayList<String>();
		for (int i = 0; i < eleTrainList.size(); i++) {
			// System.out.println(trainName);

			trainName.add(eleTrainList.get(i).getText());
		}
//		Get the size of it
		System.out.println("Train count: " + eleTrainList.size());

//		Add the list into a new Set

		Set<String> set = new TreeSet<String>(trainName);

		set.addAll(trainName);

//		And print the size of it

		System.out.println("Set of Size:" + trainName.size());

	}

}
