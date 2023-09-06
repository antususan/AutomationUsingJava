package Pages;
import Utilities.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class TMpage
{
    public void CreateTimeRecord(WebDriver driver)
    {
        // Create a new time record

        // Navigate to Time and Material Module

        //click on create button

        WebElement createNewButton = driver.findElement(By.xpath("//*[@id=\"container\"]/p/a"));
        createNewButton.click();

        //Select time from dropdown
        WebElement typecodeDropdown = driver.findElement(By.xpath("//*[@id=\"TimeMaterialEditForm\"]/div/div[1]/div/span[1]/span/span[1]"));
        typecodeDropdown.click();

        Wait.Waittobeclickable(driver, "xpath", "//*[@id=\"TypeCode_listbox\"]/li[2]", 2);
        WebElement timeTypecode = driver.findElement(By.xpath("//*[@id=\"TypeCode_listbox\"]/li[2]"));
        timeTypecode.click();


        //Enter code
        Wait.Waittobevisible(driver, "id", "Code", 2);
        WebElement codeTexbox = driver.findElement(By.id("Code"));
        codeTexbox.sendKeys("August16th");


        //Enter Description
        Wait.Waittobevisible(driver, "id", "Description", 2);
        WebElement descriptionTextbox = driver.findElement(By.id("Description"));
        descriptionTextbox.sendKeys("August16th");


        // Enter Price
        Wait.Waittobevisible(driver, "xpath", "//*[@id=\"TimeMaterialEditForm\"]/div/div[4]/div/span[1]/span/input[1]", 2);
        WebElement priceTextbox = driver.findElement(By.xpath("//*[@id=\"TimeMaterialEditForm\"]/div/div[4]/div/span[1]/span/input[1]"));
        priceTextbox.sendKeys("12");


        //Click on save button
        Wait.Waittobeclickable(driver, "id", "SaveButton", 2);
        WebElement saveButton = driver.findElement(By.id("SaveButton"));
        saveButton.click();


        Wait.Waittobeclickable(driver, "xpath", "//*[@id=\"tmsGrid\"]/div[4]/a[4]/span", 2);

        //check if new time record has been created suceesfully
        Wait.Waittobeclickable(driver, "xpath", "//*[@id=\"tmsGrid\"]/div[4]/a[4]/span", 10);
        WebElement goToLastPageButton = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[4]/a[4]/span"));
        goToLastPageButton.click();

        Wait.Waittobevisible(driver, "xpath", "//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[1]", 10);

        WebElement newRecord = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[1]"));
        Assert.assertEquals(newRecord.getText(),"August16th","New Record has not been created ");
    }
    //creating method for assertion Assertion
    //public String GetCode(WebDriver driver)
    //{
       // WebElement newRecord = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[1]"));
       // return newRecord.getText();
   //}
    public void EditTimeRecord(WebDriver driver, String code,String description)
    {
        WebElement goToLastPageButtonForEdit = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[4]/a[4]/span"));

        goToLastPageButtonForEdit.click();

        //click on Edit button

        WebElement editButton = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[5]/a[1]"));
        editButton.click();

        //select material from dropdown
        WebElement typecodeDropdownForEdit = driver.findElement(By.xpath("//*[@id=\"TimeMaterialEditForm\"]/div/div[1]/div/span[1]/span/span[1]"));
        typecodeDropdownForEdit.click();


        Wait.Waittobeclickable(driver, "xpath", "//*[@id=\"TypeCode_listbox\"]/li[1]", 2);
        WebElement materialtypecode = driver.findElement(By.xpath("//*[@id=\"TypeCode_listbox\"]/li[1]"));
        materialtypecode.click();


        //Edit  code
        Wait.Waittobevisible(driver, "id", "Code", 2);
        WebElement editCodeTextbox = driver.findElement(By.id("Code"));
        editCodeTextbox.clear();
        editCodeTextbox.sendKeys(code);


        //Edit Description
        Wait.Waittobevisible(driver, "id", "Description", 2);
        WebElement editDescriptionTextbox = driver.findElement(By.id("Description"));
        editDescriptionTextbox.clear();
        editDescriptionTextbox.sendKeys(description);


        //Edit price
        Wait.Waittobevisible(driver, "xpath", "//*[@id=\"TimeMaterialEditForm\"]/div/div[4]/div/span[1]/span/input[1]", 2);
        WebElement overlapEditPriceTextbox = driver.findElement(By.xpath("//*[@id=\"TimeMaterialEditForm\"]/div/div[4]/div/span[1]/span/input[1]"));
        overlapEditPriceTextbox.click();

        WebElement editPriceTextbox = driver.findElement(By.id("Price"));
        editPriceTextbox.clear();
        overlapEditPriceTextbox.click();
        editPriceTextbox.sendKeys("3");


        //Click on the save button
        Wait.Waittobeclickable(driver, "xpath", "//*[@id=\"SaveButton\"]", 2);
        WebElement editClickSaveButton = driver.findElement(By.xpath("//*[@id=\"SaveButton\"]"));
        editClickSaveButton.click();

        Wait.Waittobeclickable(driver, "xpath", "//*[@id=\"tmsGrid\"]/div[4]/a[4]/span", 2);
        WebElement goToLastpage = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[4]/a[4]/span"));

        goToLastpage.click();

        Wait.Waittobeclickable(driver, "xpath", "//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[1]", 2);
        WebElement editedCode = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[1]"));
        WebElement editedDescription = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[3]"));
        Assert.assertEquals(editedCode.getText(),code,"The record code has not been updated successfully");
        Assert.assertEquals(editedDescription.getText(),description,"The record description has not been updated successfully\"");

    }
    // Impliment assertion method


    //public String GetEditedCode(WebDriver driver)
    //{
       // WebElement editedCode = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[1]"));
       // return editedCode.getText();
    //}

    //public String GetEditedDescription(WebDriver driver)
   // {
       // WebElement editedDescription = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[3]"));
       // return editedDescription.getText();
    //}

    public void DeleteTimeRecord(WebDriver driver,String code ) throws InterruptedException {
        //delete button

        WebElement goToLastpageButtonForDelete = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[4]/a[4]/span"));

        goToLastpageButtonForDelete.click();

        //click delete button

        WebElement deleteButton = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[5]/a[2]"));
        deleteButton.click();

        //Thread.sleep(2000);

        //navigate to popup page & Click ok Button
        driver.switchTo().alert().accept();

        Thread.sleep(2000);

        //check the deleted record is disappered



        //Assert.That(deletedRecord.Text != "August19th", "Record has not been Deleted");
        //if (deletedRecord.Text != "August19th")
        //{
        //    Console.WriteLine("Record has been deleted Successfully");
        //}

        //else
        //{
        //    Console.WriteLine("Record has not been Deleted ");
        //}
        WebElement deletedCodeRecord = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[1]"));

        Assert.assertNotEquals(deletedCodeRecord.getText(),code,"The Record code has been deleted successfully");




    }
    //public String GetDeletedCode (WebDriver driver)
    //{
        //WebElement deletedRecord = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[1]"));
        //return deletedRecord.getText();
    //}

}

