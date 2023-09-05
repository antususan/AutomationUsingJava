
package Tests;

import Pages.EmployeesPage;
import Pages.Homepage;
import Pages.Loginpage;
import Utilities.CommonDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EmployeesTests extends CommonDriver
{
    @BeforeTest
    public void EmployeesSetup()
    {
        //open the browser

        driver = new ChromeDriver();
        // Login page object initialization and definition
        Loginpage loginPageObj = new Loginpage();
        loginPageObj.LoginActions(driver);

        //homepage object initialization and definition
        Homepage homePageObj = new Homepage();
        homePageObj.GoToEmployeesPage(driver);

    }
    @Test
    public void CreateEmployee_Test()
    {
        EmployeesPage employeesPageObj = new EmployeesPage();
        employeesPageObj.CreateEmployee(driver);

    }
    @Test
    public void EditEmployee_Test()
    {
        EmployeesPage employeesPageObj = new EmployeesPage();
        employeesPageObj.EditEmployee(driver);

    }
    @Test
    public void DeleteEmployee_Test()
    {
        EmployeesPage employeesPageObj = new EmployeesPage();
        employeesPageObj.DeleteEmployee(driver);
    }

    @AfterTest
    public void TearDown()
    {
        driver.quit();
    }
}

