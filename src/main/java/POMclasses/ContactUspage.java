package POMclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUspage 
{
//Declaration
	@FindBy(xpath="//img[contains(@src,'contactus')]")
	private WebElement pagelogo;
	
	@FindBy(name="name")
	private WebElement fullnameTF;
	
	@FindBy(name="sender")
	private WebElement emailTf;
	
	@FindBy(name="subject")
	private  WebElement subjectTF;
	
	@FindBy(name="message")
	private WebElement messageTextArea;
	
	@FindBy(xpath="//button[text()='Send us mail']")
	private WebElement sendusmailButton;
	
	//initilization
	/**
	 * this method is used to return contact us page logo
	 * @param driver
	 */
	public ContactUspage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	//Utilization
	/**
	 * this method is used to return contact us page logo
	 * @return
	 */
	public WebElement getpagelogo() 
	{
		return pagelogo;
	}
	/**
	 * this method is used to send contact datails
	 * @param fullname
	 * @param email
	 * @param subject
	 * @param message
	 */
	public void sendDetails(String fullname, String email, String subject, String message) {
	
		fullnameTF.sendKeys(fullname);
		emailTf.sendKeys(email);
		subjectTF.sendKeys(subject);
		messageTextArea.sendKeys(message);
		sendusmailButton.click();
		
	}
	
	
	
}
