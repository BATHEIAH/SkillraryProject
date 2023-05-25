package testScript;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Genericlibraries.BaseClass;

public class AddTestingCourseToAddtoCart extends BaseClass
{
@Test
public void AddPythonToAddTOCart() 
{
SoftAssert soft=new SoftAssert();

home.ClickGearsTab();
home.ClickSkillraryDemoApp();
web.handleChildBrowser();

soft.assertTrue(demoApp.getlogo().contains("ECommerce"));
demoApp.SelectCatagory(web, 1);

web.ScrollToElement(testing.getPythonIcon());
web.dragAndDropElements(testing.getPythonIcon(),testing.getmyCart());

web.ScrollToElement(testing.getfacebookIcon());
testing.Clickfacebook();

soft.assertAll();

}
}
