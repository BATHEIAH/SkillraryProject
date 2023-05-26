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
home.SkillraryDemoApp();
web.handleChildBrowser();

soft.assertTrue(demoApp.getlogo().contains("ECommerce"));
demoApp.SelectCatagory(web, 1);

web.ScrollElement(testing.getpythonimage());
web.DragAndDropElement(testing.getpythonimage(),testing.getmycart());

web.ScrollElement(testing.getfacebookIcon());
testing.clickfacebook();

soft.assertAll();

}
}
