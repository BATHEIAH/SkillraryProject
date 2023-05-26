package Genericlibraries;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import POMclasses.ContactUs;
import POMclasses.SeleniumTrainingpage;
import POMclasses.SkillraryDemoapp;
import POMclasses.SkillraryHomePage;
import POMclasses.TestngPage;

public class BaseClass 
{
	protected PropertiesUtility property ;
	protected ExcelUtility excel;
	protected WebDriverutility web;
	protected WebDriver driver;
	
	protected SkillraryHomePage home;
	protected SkillraryDemoapp demoApp;
	protected SeleniumTrainingpage selenium;
	protected TestngPage testing;
	protected ContactUs contact;
	
//@Beforesuite
//@BeforeTest
	
	
@BeforeClass

public void Config() 
{
 property=new PropertiesUtility();
 excel=new ExcelUtility();
 web=new WebDriverutility();
 
 property.propertesInit(IconstantPath.PROPERTIES_PATH);
 excel.excelInit(IconstantPath.EXCEL_PATH);

}
 
 @BeforeMethod
public void methodConfig() 
 {
	 driver=web.lunchbrowser(property.readData("browser"));
	 web.maximizeBrowser();
	 web.NavigateToApp(property.readData("url"));
	 web.WaitutilElemnt(Long.parseLong(property.readData("time")));
	 
	home=new SkillraryHomePage(driver);
	demoApp=new SkillraryDemoapp(driver);
	selenium=new SeleniumTrainingpage(driver);
	testing=new TestngPage(driver);
	contact=new ContactUs(driver);
	
	
}
 
@AfterMethod
public void methodTearDown() 
{
	web.QuiteAllWindows();
}
@AfterClass
public void classTearDown() 
{
	excel.closeExcel();
}
//@AfterTest
//@AfterSuite
}
