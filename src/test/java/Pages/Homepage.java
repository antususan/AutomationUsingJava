package Pages;

import Utilities.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Homepage
{
    public void GoToTMPage(WebDriver driver)
    {
        WebElement administrarionDropdown = driver.findElement(By.xpath("/html/body/div[3]/div/div/ul/li[5]/a"));
        administrarionDropdown.click();

        //Explicit wait implimentation

        //WebDriverWait wait = new WebDriverWait(driver, TimeSpan.FromSeconds(5));
        //wait.Until(SeleniumExtras.WaitHelpers.ExpectedConditions.ElementIsVisible(By.XPath("/html/body/div[3]/div/div/ul/li[5]/ul/li[3]/a")));

        //Fluent wait Implementation

        Wait.Waittobeclickable(driver,"Xpath ","/html/body/div[3]/div/div/ul/li[5]/ul/li[3]/a", 7);
        WebElement tmOption = driver.findElement(By.xpath("/html/body/div[3]/div/div/ul/li[5]/ul/li[3]/a"));
        tmOption.click();
    }
    public void GoToEmployeesPage(WebDriver driver)
    {
        WebElement administrarionDropdown = driver.findElement(By.xpath("/html/body/div[3]/div/div/ul/li[5]/a"));
        administrarionDropdown.click();

        Wait.Waittobeclickable(driver, "Xpath", "/html/body/div[3]/div/div/ul/li[5]/ul/li[2]/a", 7);
        WebElement employeeOpt = driver.findElement(By.xpath("/html/body/div[3]/div/div/ul/li[5]/ul/li[2]/a"));
        employeeOpt.click();

    }
}

