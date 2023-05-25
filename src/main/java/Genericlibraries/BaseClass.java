package Genericlibraries;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import POMclasses.ContactUspage;
import POMclasses.SeleniumTrainingpage;
import POMclasses.SkillraryDemoapp;
import POMclasses.SkillraryHomePage;
import POMclasses.TestngPage;

public class BaseClass 
{
	protected PropertiesUtility property ;
	protected ExcelUtility excel;
	protected WebDriverUtility web;
	protected WebDriver driver;
	
	protected SkillraryHomePage home;
	protected SkillraryDemoapp demoApp;
	protected SeleniumTrainingpage selenium;
	protected TestngPage testing;
	protected ContactUspage contact;
	
//@Beforesuite
//@BeforeTest
	
	
@BeforeClass

public void Config() 
{
 property=new PropertiesUtility();
 excel=new ExcelUtility();
 web=new WebDriverUtility();
 
 property.propertesInit(IconstantPath.PROPERTIES_PATH);
 excel.excelInit(IconstantPath.EXCEL_PATH);

}
 
 @BeforeMethod
public void methodConfig() 
 {
	 driver=web.lunchBrowser(property.readData("browser"));
	 web.maximizeBrowser();
	 web.navigateToApp(property.readData("url"));
	 web.WaitUtilElementFound(Long.parseLong(property.readData("time")));
	 
	home=new SkillraryHomePage(driver);
	demoApp=new SkillraryDemoapp(driver);
	selenium=new SeleniumTrainingpage(driver);
	testing=new TestngPage(driver);
	contact=new ContactUspage(driver);
	
	home.ChooseEnglish();
}
 
@AfterMethod
public void methodTearDown() 
{
	web.quitAllWindows();
}
@AfterClass
public void classTearDown() 
{
	excel.closeExcel();
}
//@AfterTest
//@AfterSuite
}
