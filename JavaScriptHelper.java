package com.test.automation.UIAutomation.helper;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptHelper {

	private static WebDriver driver;
	private static Logger Log = Logger.getLogger(JavaScriptHelper.class);

	public JavaScriptHelper(WebDriver driver) {
		this.driver = driver;
		Log.debug("JavaScriptHelper : " + this.driver.hashCode());
	}

	public static Object executeScript(String script) {
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		Log.info(script);
		return exe.executeScript(script);
	}

	public static Object executeScript(String script, Object... args) {
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		Log.info(script);
		return exe.executeScript(script, args);
	}

	public static void scrollToElemet(WebElement element) {
		executeScript("window.scrollTo(arguments[0],arguments[1])", element.getLocation().x, element.getLocation().y);
		Log.info(element);
	}

	public static void scrollToElemetAndClick(WebElement element) {
		scrollToElemet(element);
		element.click();
		Log.info(element);
	}

	public static void scrollIntoView(WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public static void scrollIntoViewAndClick(WebElement element) {
		scrollIntoView(element);
		element.click();
		Log.info(element);
	}

	public static void scrollDownVertically() {
		executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	public static void scrollUpVertically() {
		executeScript("window.scrollTo(0, -document.body.scrollHeight)");
	}

	public static void scrollDownByPixel() {
		executeScript("window.scrollBy(0,1500)");
	}

	public static void scrollUpByPixel() {
		executeScript("window.scrollBy(0,-1500)");
	}

	public static void ZoomInBypercentage() {
		executeScript("document.body.style.zoom='40%'");
	}

	public static void ZoomBy100percentage() {
		executeScript("document.body.style.zoom='100%'");
	}

	public static void flash(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String bgcolor = element.getCssValue("backgroundColor");
		for (int i = 0; i < 10; i++) {
			changeColor("rgb(0,200,0)", element, driver);// 1
			changeColor(bgcolor, element, driver);// 2
		}
	}

	public static void changeColor(String color, WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
		}
	}

	public static void drawBorder(WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.border='3px solid red'", element);
	}

	public static void generateAlert(String message) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("alert('" + message + "')");

	}

	public static void clickElementByJS(WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();", element);

	}

	public static void refreshBrowserByJS() {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("history.go(0)");
	}

	public static String getTitleByJS() {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String title = js.executeScript("return document.title;").toString();
		return title;
	}

	public static String getPageInnerText() {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String pageText = js.executeScript("return document.documentElement.innerText;").toString();
		return pageText;
	}
	
	public static void javaScriptSendText(WebElement element,String text)
	{
		JavascriptExecutor myExecutor = ((JavascriptExecutor) driver);
		myExecutor.executeScript("arguments[0].value='"+text+"';", element);	
	}
	//enable remove Attribute disable
/*Ex1:	JavascriptExecutor Executor = (JavascriptExecutor) driver;
 	WebElement element=driver.findElement(By.xpath(“path”);
String js1="arguments[0].removeAttribute('disabled');";
      	 Executor.executeScript(js1, element);
Ex2:  	String js2 = "arguments[0].style.height='auto'; arguments[0].style.visibility='visible';";
       	Executor.executeScript(js2, element);
	
	
	1) String script = "window.location = \'"+url+"\'";
JavascriptExecutor js =(JavascriptExecutor)driver;
js.executeScript(script)

2)js.executeScript("history.go(0)");
3) String sText =js.executeScript("return document.title;").toString();
4) WebElement search =(WebElement) js.executeScript("return document.getElementById('searchBtn');");
5) String frames = js.executeScript("document.frames.length;").toString();
6) js.executeScript("arguments[0].scrollIntoView(true);", element);
7) js.executeScript("window.scrollBy(300,2000)");
8) js.executeScript("arguments[0].setAttribute('style', arguments[1]);", ele, "background:"
    + "yellow; color: Red; border: 4px dotted solid yellow;");
9) js.executeScript("arguments[0].click();",element);
10) js.executeScript("arguments[0].setAttribute('target','_self');",element); // to open in same tab
11) js.executeScript("alert('Enter your Facebook crednetials');");
12) js.executeScript("confirm('Enter your Facebook crednetials');");
13) js.executeScript("prompt('Enter your crednetials',’Enter domain’);")
	
	
	*/


}
