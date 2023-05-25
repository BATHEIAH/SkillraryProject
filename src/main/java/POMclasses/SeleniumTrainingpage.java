package POMclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Genericlibraries.WebDriverUtility;
/**
 * this class contains elements and respective business libraries of selenium Training page
 * @author Batheiah
 *
 */
public class SeleniumTrainingpage 
{
@FindBy(xpath="//h1[@class='page-header']")
private WebElement pageheader;

@FindBy(id="add")
private WebElement plusbutton;

@FindBy(id="quantity")
private WebElement quantity;

@FindBy(xpath="//button[.=' Add to Cart']")
private WebElement AddTOcartButton;

@FindBy(xpath="//div[@class=\"callout callout-success\"]/span")
private WebElement massage;

//Initialization

public SeleniumTrainingpage(WebDriver driver)
{
PageFactory.initElements(driver, this);	
}

//utilization
/**
 * this method returns page header of selenium Training page
 * @return
 */
public String getpageheader() {
	return pageheader.getText();
}
/**
 * this method is used to double click on plus button
 * @param Web
 */
public void DoubleClickPlusButton(WebDriverUtility Web)
{
Web.doubleclickonElement(plusbutton);	
}
/**
 * this methos is used to get the quantity of Add Items
 * @return
 */
public String getquantity() 
{
	return quantity.getAttribute("value");
}
/**
 * This method is used to click on Add to Cart Button
 */
public void clickAddToCart() 
{
	AddTOcartButton.click();	
}
/**
 * this methos is Use to get the Text on the Item Added massage
 * @return
 */
public String getmassage() 
{
return massage.getText();	
}
}
