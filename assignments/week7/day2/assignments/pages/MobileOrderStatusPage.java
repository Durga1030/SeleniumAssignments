package week7.day2.assignments.pages;

import org.openqa.selenium.By;

import week7.day2.assignments.hooks.TestNgHooks;

public class MobileOrderStatusPage extends TestNgHooks {

	public String resultantMobileBrand;

	public String resultantOrderStatusMsg;

	public static String resultantOrderRequestNumber;

	public String resultantOrderPlacedRequest;

	/*
	 * String mobileBrand =
	 * driver.findElement(By.cssSelector("div#sc_cart_view>table>tbody>tr>td>div>a")
	 * ).getText();
	 * 
	 * String orderStatusMsg =
	 * driver.findElement(By.cssSelector("div#sc_order_status_intro_text>div>span"))
	 * .getText();
	 * 
	 * String orderRequestNumber =
	 * driver.findElement(By.cssSelector("a#requesturl>b")).getText();
	 * 
	 * String orderPlacedRequest =
	 * driver.findElement(By.cssSelector("div#sc_order_status_intro_text>dl")).
	 * getText();
	 */

	public MobileOrderStatusPage getOrderedMobileBrand() {

		resultantMobileBrand = getElementText(locateElement("css", "div#sc_cart_view>table>tbody>tr>td>div>a"));

		return this;
	}

	public MobileOrderStatusPage getOrderedStatusMsg() {

		resultantOrderStatusMsg = getElementText(locateElement("xpath", "//div[@class='order_summary']//div[1]"));

		return this;
	}

	public MobileOrderStatusPage getOrderReqNum() {

		resultantOrderRequestNumber = getDriver().findElement(By.xpath("//a[@class='linked requestItemUrl']//b[1]"))
				.getText(); // Parent based class xpath

		// String rEQ = driver.findElement(By.cssSelector("a#requesturl>b")).getText();
		// // CSS selector
		// String rEQ =
		// driver.findElement(By.xpath("//a[@id='requesturl']//b[1]")).getText(); //
		// Parent based id xpath

		// getDriver().findElement(By.cssSelector("a#requesturl>b")).getText();

		System.out.println(resultantOrderRequestNumber);
		return this;
	}

	public MobileRequestDataServiceNow clickOrderReqNum() {

		click(locateElement("xpath", "//a[@class='linked requestItemUrl']//b[1]"));

		// String rEQ = driver.findElement(By.xpath("//a[@class='linked
		// requestItemUrl']//b[1]")).getText();

		return new MobileRequestDataServiceNow();
	}

	public MobileOrderStatusPage getOrderPlacedReq() {

		resultantOrderPlacedRequest = getElementText(locateElement("css", "div#sc_order_status_intro_text>dl"));

		return this;
	}

	public MobileOrderStatusPage verifyOrderStatus() {
		System.out.println(resultantOrderStatusMsg + " : " + resultantOrderRequestNumber);
		verifyPartialText(locateElement("xpath", "//div[@class='order_summary']//div[1]"),
				"request has been submitted");

		return this;
	}

	public CatalogServiceNow clickOnBackToCatalog() {
		click(locateElement("id", "back_to_catalog_header"));
		getDriver().switchTo().defaultContent();
		return new CatalogServiceNow();
	}

}
