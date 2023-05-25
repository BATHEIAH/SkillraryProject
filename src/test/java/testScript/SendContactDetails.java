package testScript;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Genericlibraries.BaseClass;

public class SendContactDetails extends BaseClass
{
 @Test
 public void SendContactDetails()
 {
	 SoftAssert soft=new SoftAssert();
	 
	 home.ClickGearsTab();
	 home.ClickSkillraryDemoApp();
	 web.handleChildBrowser();

	 soft.assertTrue(demoApp.getlogo().contains("ECommerce"));
	 
	 web.ScrollToElement(demoApp.getContactUs());
	 demoApp.ClickContactUs();
	 
	 soft.assertTrue(contact.getpagelogo().isDisplayed());
	 
	 home.ChooseEnglish();
	 Map<String,String>map=excel.readDataFromExcel("Sheet");
	 contact.sendDetails(map.get("FullName"),map.get("Email"), map.get("Subject"), map.get("massage"));
	 
	 soft.assertAll();
 }
}
