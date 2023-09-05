package Tests;
import Pages.Homepage;
import Pages.Loginpage;
import Pages.TMpage;
import Utilities.CommonDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TM_Test extends CommonDriver
{
    @BeforeTest
    public void SetUpTM() throws InterruptedException {
        //open the browser

        driver = new ChromeDriver();

        //wait Implicit wait
        //driver.Manage().Timeouts().ImplicitWait = TimeSpan.FromSeconds(10);

        // Login page object initialization and definition
        Loginpage loginPageObj = new Loginpage();
        Thread.sleep(2000);
        loginPageObj.LoginActions(driver);

        // Home page object initialization and definition
        Homepage homePageObj = new Homepage();
        homePageObj.GoToTMPage(driver);

    }

    @Test(priority = 0, description = "This Test create a new Time record with Valid Data")
    public void createTime_Test() {
        TMpage tmPageObj = new TMpage();
        tmPageObj.CreateTimeRecord(driver);
    }

    @Test(priority = 1, description = "This Test Edit an existing Time Record  with Valid Data")
    public void EditTime_Test() {
        TMpage tmPageObj = new TMpage();
        tmPageObj.EditTimeRecord(driver, "keyboard", "machine");
    }

    @Test(priority = 2, description = "This Test Delete an existing Time Record ")
    public void DeleteTime_Test() throws InterruptedException {
        TMpage tmPageObj = new TMpage();
        try {
            tmPageObj.DeleteTimeRecord(driver,"keyboard");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

        @AfterTest
        public void CloseTestRun()
        {
            driver.quit();
        }
    }


