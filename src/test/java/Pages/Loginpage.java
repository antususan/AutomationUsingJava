package Pages;
import Utilities.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Loginpage
{
    public void LoginActions(WebDriver driver)
    {
        driver.manage().window().maximize();

        // Launch turnup portal and navigation to login
        driver.navigate().to("http://horse.industryconnect.io/");

        try
        {


            //Identify username textbox and enter Valid username
            WebElement usernameTextbox = driver.findElement(By.id("UserName"));
            usernameTextbox.sendKeys("hari");
        }
        catch (Exception ex)
        {
            //Assert.Fail("Turnup Portal page didnot launch", ex.message);

        }
        //Identify password textbox and enter valid password

        // Fluent Wait Implimentation
        Wait.Waittobevisible(driver, "Id", "Password", 2);
        WebElement password = driver.findElement(By.id("Password"));
        password.sendKeys("123123");


        //Identify login button and clck on the button
        // Fluent Wait Implimentation
        Wait.Waittobeclickable(driver,"Xpath", "//*[@id=\"loginForm\"]/form/div[3]/input[1]", 2);
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/form/div[3]/input[1]"));
        loginButton.click();

        //Thread.Sleep(1000);

    }
}

