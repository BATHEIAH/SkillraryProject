package testScript;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Genericlibraries.BaseClass;

public class AddToCart extends BaseClass
{
@Test
public void addtoCart() {
	SoftAssert soft=new SoftAssert();
	
	home.ClickGearsTab();
	home.ClickSkillraryDemoApp();
	web.handleChildBrowser();
	
	soft.assertTrue(demoApp.getlogo().contains("ECommerce"));
	demoApp.mouseoverToCourse(web);
	demoApp.ClickSeleniumTraining();
	
	soft.assertEquals(selenium.getpageheader(), "selenium Training");
	
	int initialQuantity=Integer.parseInt(selenium.getquantity());
	selenium.DoubleClickPlusButton(web);
	int finalQuantity=Integer.parseInt(selenium.getquantity());
	soft.assertEquals(finalQuantity, initialQuantity);
	
	selenium.clickAddToCart();
	web.handleAlert("ok");
	soft.assertEquals(selenium.getmassage(),"Item Added to Cart");
	
	soft.assertAll();
			
}
}
