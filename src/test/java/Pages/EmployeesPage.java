package Pages;

import Utilities.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class EmployeesPage
{
    public void CreateEmployee(WebDriver driver)
    {
        //create new Employee
        //Click on create button
        Wait.Waittobeclickable(driver, "Xpath","//*[@id=\"container\"]/p/a",5);
        WebElement createEmployee = driver.findElement(By.xpath("//*[@id=\"container\"]/p/a"));
        createEmployee.click();



        //Enter Name
        Wait.Waittobevisible(driver,"Id","Name",5);
        WebElement nameTextBox = driver.findElement(By.id("Name"));
        nameTextBox.sendKeys("Ekkujames");


        //Enter Username
        Wait.Waittobevisible(driver,"Id","Username",5);
        WebElement usernameTextBox = driver.findElement(By.id("Username"));
        usernameTextBox.sendKeys("james");


        //Enter Contact
        //Enter contacts details in Edit contact
        Wait.Waittobeclickable(driver, "Xpath", "//*[@id=\"EditContactButton\"]", 5);
        WebElement editContactButton = driver.findElement(By.xpath("//*[@id=\"EditContactButton\"]"));
        editContactButton.click();


        driver.switchTo().frame(0);

        //Enter FirstName
        Wait.Waittobevisible(driver, "Id", "FirstName", 5);
        WebElement firstNameTextBox = driver.findElement(By.id("FirstName"));
        firstNameTextBox.sendKeys("Ekku");


        //Enter Last Name
        Wait.Waittobevisible(driver, "Id", "LastName", 5);
        WebElement lastNameTextBox = driver.findElement(By.id("LastName"));
        lastNameTextBox.sendKeys("James");


        //Enter PreferedName
        Wait.Waittobevisible(driver, "Id", "PreferedName", 5);
        WebElement preferedNameTextBox = driver.findElement(By.id("PreferedName"));
        preferedNameTextBox.sendKeys("Ekku");



        //Enter Phone
        Wait.Waittobevisible(driver, "Id", "Phone", 5);
        WebElement phoneTextBox = driver.findElement(By.id("Phone"));
        phoneTextBox.sendKeys("01234567");


        //Enter Mobile
        Wait.Waittobevisible(driver, "Id", "Mobile", 5);
        WebElement mobileTextBox = driver.findElement(By.id("Mobile"));
        mobileTextBox.sendKeys("0123456789");


        //Enter Email
        Wait.Waittobevisible(driver, "Id", "email", 5);
        WebElement emailTextBox = driver.findElement(By.id("email"));
        emailTextBox.sendKeys("jamesekkuname@gmail.com");


        //Enter Fax
        Wait.Waittobevisible(driver, "Id", "Fax", 5);
        WebElement faxTextBox = driver.findElement(By.id("Fax"));
        faxTextBox.sendKeys("222");


        //Enter Address

        //try
        //{


        //    //Identify Address textbox and enter address
        //    IWebElement addressTextBox = driver.FindElement(By.Id("autocomplete"));
        //    addressTextBox.SendKeys("abcd address");
        //    Thread.Sleep(2000);
        //}
        //catch (Exception ex)
        //{
        //    Assert.Fail("Address: should NOT be used ", ex.Message);

        //}

        //Enter Street
        Wait.Waittobevisible(driver, "Id", "Street", 5);
        WebElement streetTextBox = driver.findElement(By.id("Street"));
        streetTextBox.sendKeys("12");


        //Enter City
        Wait.Waittobevisible(driver, "Id", "City", 5);
        WebElement cityTextBox = driver.findElement(By.id("City"));
        cityTextBox.sendKeys("Cambridge");


        //Enter Postcode
        Wait.Waittobevisible(driver, "Id", "Postcode", 5);
        WebElement postcodeTextBox = driver.findElement(By.id("Postcode"));
        postcodeTextBox.sendKeys("3432");


        //Enter Country
        Wait.Waittobevisible(driver, "Id", "Country", 5);
        WebElement countryTextBox = driver.findElement(By.id("Country"));
        countryTextBox.sendKeys("New Zealand");



        //Click Save Contact Button
        Wait.Waittobeclickable(driver, "Id", "submitButton", 5);
        WebElement saveContactButton = driver.findElement(By.id("submitButton"));
        saveContactButton.click();

        driver.switchTo().defaultContent();

        //Enter Password
        Wait.Waittobevisible(driver, "Id", "Password", 5);
        WebElement passwordTextBox = driver.findElement(By.id("Password"));
        passwordTextBox.sendKeys("J@me5ekku");


        //Enter Retype Password
        Wait.Waittobevisible(driver, "Id", "RetypePassword", 5);
        WebElement reTypePasswordTextBox = driver.findElement(By.id("RetypePassword"));
        reTypePasswordTextBox.sendKeys("J@me5ekku");


        //Check IsAdmin
        //IWebElement isAdminCheckBox = driver.FindElement(By.Id("IsAdmin"));
        //isAdminCheckBox.Click();
        //Thread.Sleep(2000);

        //Enter Vehicle
        //IWebElement vehicleTextBox = driver.FindElement(By.XPath("//*[@id=\"UserEditForm\"]/div/div[7]/div/span[1]/span/input"));
        //vehicleTextBox.SendKeys("1001");
        //Thread.Sleep(2000);

        //Enter Groups
        //IWebElement groupsDropdown = driver.FindElement(By.XPath("//*[@id=\"UserEditForm\"]/div/div[8]/div/div/div[1]"));
        //groupsDropdown.Click();
        //Thread.Sleep(2000);

        //IWebElement selectGroup = driver.FindElement(By.XPath("//*[@id=\"groupList_listbox\"]/li[80]"));
        //selectGroup.Click();
        //Thread.Sleep(2000);

        //Click Save button
        Wait.Waittobeclickable(driver, "Id", "SaveButton", 5);
        WebElement saveButton = driver.findElement(By.id("SaveButton"));
        saveButton.click();

        //Thread.sleep(7000);

        // Back to list page to check the new employee details has been added
        //Wait.Waittobeclickable(driver, "Xpath", "//*[@id=\"container\"]/div/a", 10);
        WebElement backToLastPageButton = driver.findElement(By.xpath("//*[@id=\"container\"]/div/a"));
        backToLastPageButton.click();


        // Goto last page to check the new employee details has been added
        Wait.Waittobeclickable(driver, "Xpath", "//*[@id=\"usersGrid\"]/div[4]/a[4]", 10);
        WebElement goToLastPageButton = driver.findElement(By.xpath("//*[@id=\"usersGrid\"]/div[4]/a[4]"));
        goToLastPageButton.click();

        //Thread.sleep(7000);

        //Wait.Waittobevisible(driver, "Xpath", "//*[@id=\"usersGrid\"]/div[3]/table/tbody/tr[last()]/td[1]", 5);
        WebElement newEmployeeRecord = driver.findElement(By.xpath("//*[@id=\"usersGrid\"]/div[3]/table/tbody/tr[last()]/td[1]"));
        Assert.assertEquals(newEmployeeRecord.getText() , "Ekkujames","New Employee has not been created");

        //Assert.That(newEmployeeRecord.Text == "Ekkujames", "New Employee has not been created");

        //Thread.sleep(7000);
    }

    public void EditEmployee(WebDriver driver)
    {

    }

    public void DeleteEmployee(WebDriver driver)
    {

    }
}




