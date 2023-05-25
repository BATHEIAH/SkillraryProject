package POMclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * this method contains elements and respective business libraries of testing page
 * @author Batheiah
 *
 */
public class TestngPage
{
	//Declaration
	
@FindBy(xpath="//h1[@class='page-header']")
private WebElement pageheader;

@FindBy(id="Python")
private WebElement pythonImage;

@FindBy(id="cartArea")
private WebElement myCart;

@FindBy(xpath="//ul/descendant::i[@class='fa fa-facebook']")
private WebElement facebookIcon;

//initilization

public TestngPage(WebDriver driver)
{
PageFactory.initElements(driver, this);	
}
//Utilization
/**
 * this method returs the page header of selenium Training page
 * @return
 */
public String getpageheader() 
{
	return pageheader.getText();
}
/**
 * this method is used to get python image
 * @return
 */
public WebElement getPythonIcon() 
{
	return pythonImage;
}
/**
 * this method is used to get mycart area
 * @return
 */
public WebElement getmyCart() 
{
	return myCart;
}
/**
 * this methos is used to get on facebook icon button
 * @return
 */
public WebElement getfacebookIcon() 
{
	return facebookIcon;
}
/**
 * this method is used to click on facebook Icon 
 */
public void Clickfacebook() 
{
	facebookIcon.click();
}
}
