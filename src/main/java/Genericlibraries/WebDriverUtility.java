package Genericlibraries;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * This class contains all reusable method to perform operations
 * on Webdriver
 * @author Batheiah
 *
 */
public class WebDriverUtility
{
	private WebDriver driver;
	/**
	 * this method is used to lunch the specific browser
	 * @param browser
	 * @return
	 */
public WebDriver lunchBrowser(String browser) 
{
switch (browser) {
case "chrome":
	WebDriverManager.chromedriver().setup();
	driver= new ChromeDriver();
	break;
case"firefox":
	WebDriverManager.firefoxdriver().setup();
	driver=new FirefoxDriver();
	break;
case"edge":
	WebDriverManager.edgedriver().setup();
	driver=new EdgeDriver();
default:
	System.out.println("Invalid browser info");
	break;
}	
return driver;

}
/**
 * this method used to Wait until element or list of elements is found
 * @param time
 */
public void maximizeBrowser() 
{
driver.manage().window().maximize();	
}
/**
 * This method is to maximize the window
 * @param url 
 */
public void navigateToApp(String url) 
{
driver.get(url);	
}
/**
 * this method used to Wait until element or list of elements is found
 * @param time
 */
public void WaitUtilElementFound(long time) {
	driver.manage().timeouts().implicitlyWait(time,TimeUnit.SECONDS);
}
/**
 * this method is  used to wait until element is visible
 * @param time
 * @param element
 * @return
 */
public WebElement expliplicitlyWait(long time,WebElement element) 
{
	WebDriverWait wait=new WebDriverWait(driver, time);
	return wait.until(ExpectedConditions.visibilityOf(element));
}
/**
 * this methos is used to wait until element is enabled
 * @param element
 * @param time
 * @return
 */
public WebElement expliplicitlyWait(WebElement element,long time) 
{
	WebDriverWait wait=new WebDriverWait(driver, time);
	return wait.until(ExpectedConditions.elementToBeClickable(element));
}
/**
 * this method is used to mouse hover on an element
 * @param element
 */
public void MouseOver(WebElement element) 
{
Actions actions=new Actions(driver);
actions.moveToElement(element).perform();
}
/**
 * this method is used to double click on element
 * @param element
 */
public void doubleclickonElement(WebElement element) 
{
	Actions actions=new Actions(driver);
	actions.doubleClick(element).perform();
}
/**
 * this method is used to right click on th eelement
 * @param element
 */
public void rightclick(WebElement element) 
{
	Actions actions=new Actions(driver);
	actions.contextClick(element).perform();	
}
/**
 * this method is used to drag and drop of the element
 * @param element
 * @param dest
 */
public void dragAndDropElements(WebElement element, WebElement dest) 
{
	Actions actions=new Actions(driver);
	actions.dragAndDrop(element,dest).perform();	
}
/**
 * this methos is used to switch to Frame based on id or name attribute
 * @param IdOrName
 */
public void SwitchToFrame(String IdOrName) {
	driver.switchTo().frame(IdOrName);
}
/**
 * this method is used to switch to Frame based on frame Element
 * @param frameElement
 */
public void SwitchToFrame(WebElement frameElement) 
{
driver.switchTo().frame(frameElement);
}
/**
 * this method is used to switch back from frame
 */
public void switchToFrame() 
{
driver.switchTo().defaultContent();	
}
/**
 * this method is used to take screenShot of webpage
 */
public void ScreenShot() 
{
TakesScreenshot ts=(TakesScreenshot)driver;
File src=ts.getScreenshotAs(OutputType.FILE);
File dest=new File("./ScreenShot/screenshot.png");
try {
	FileUtils.copyFile(src, dest);
} catch (IOException e) {
	e.printStackTrace();
}
}
/**
 * this method is used to Scroll till the Element
 * @param element
 */
public void ScrollToElement(Object element) 
{
JavascriptExecutor js=(JavascriptExecutor)driver;
js.executeScript("arguments[0].scrollIntoView(true)", element);
}
/**
 * this method select an element from the dropDown Using Value
 * @param element
 * @param index
 * @param value 
 * @param index 
 */
public void dropDown(WebElement element, int index) {
	Select s=new Select(element);
	s.selectByIndex(index);
}
public void dropdown(WebElement element,  String value) {
	Select s=new Select(element);
	s.selectByValue(value);
}
/**
 * This method is Select an Element from the dropDown using Text
 * @param text
 * @param element
 */
public void dropDown(String text,WebElement element) {
	Select  s=new Select(element);
	s.deselectByVisibleText(text);
}
/**
 * 
 * this methos used alert
 * @param Status
 */

public void handleAlert(String Status)
{
Alert a1=driver.switchTo().alert();

 if (Status.equalsIgnoreCase("ok")) 
 
	 a1.accept();
    else
	 a1.dismiss();
}
/**
 * this method used to Switch to parent tab
 */
private void SwitchToparentWindow() 
{
	String parentId=driver.getWindowHandle();
	driver.switchTo().window(parentId);
}
/**
 * this method used switch chlid browser
 */
public void handleChildBrowser() {
	Set<String> set=driver.getWindowHandles();
	for(String id:set) {
		driver.switchTo().window(id);
	}
	}
/**
 * this method close current tab
 */
public void closeCurrentTab() {
	driver.close();
}
/**
 * this method Quite all the windows
 */
public void quitAllWindows()
{
	driver.quit();
}
}

