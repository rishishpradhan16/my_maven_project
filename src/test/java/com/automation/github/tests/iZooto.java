package com.automation.github.tests;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class iZooto {

    private WebDriver driver;
    private DriverFactory driverFactory;

    @BeforeMethod
    public void setup() throws InterruptedException {
        driverFactory = new DriverFactory();
        driver = driverFactory.initializeDriver();
        driverFactory.openApplication();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @Test(priority = 1)
    public void testcase1() throws InterruptedException {
        clickElement("//input[@name='name']");
        clickElement("//input[@name='email']");
        clickElement("//input[@name='password']");  // Changed from websiteUrl to password
        clickElement("//input[@name='phoneNumber']");
        clickElement("//input[@type='checkbox']");
        clickElement("//button[@type='submit']");

        System.out.println("Checking validation after leaving all fields blank");

        validateField("//p[text()='Please Enter Your Name']", "Please Enter Your Name", "Name");
        validateField("//p[text()='Please Enter Your Email']", "Please Enter Your Email", "Email");
        validateField("//p[text()='Password is required']", "Password is required", "Password");
        validateField("//p[text()='Please Enter Phone Number']", "Please Enter Phone Number", "Phone Number");
    }

    @Test(priority = 2)
    public void testcase2() throws InterruptedException {
        enterText("//input[@name='name']", "     ");
        enterText("//input[@name='email']", "     ");
        enterText("//input[@name='password']", "    ");
        enterText("//input[@name='phoneNumber']", "  ");
        
        WebElement checkboxElement = findElement("//input[@type='checkbox']");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkboxElement);
        
        clickElement("//input[@type='checkbox']");
        clickElement("//button[@type='submit']");
        
        System.out.println("Entering only spaces in all fields");
        
        Thread.sleep(4000);

        WebElement validationMessage = findElement("//p[contains(text(), 'Only spaces not allowed')]");
        Assert.assertTrue(validationMessage.isDisplayed(), "Test Case Failed: Only spaces not allowed validation message not displayed.");
        
        System.out.println("Test Case Passed, should not be able to signup due to spaces in fields.");
    }

    @Test(priority = 5)
    public void testcase5() throws InterruptedException {
        enterText("//input[@name='name']", "test");
        enterText("//input[@name='company']", "Account");
        enterText("//input[@name='email']", "abcd");  // Invalid email
        enterText("//input[@name='password']", "password123");  // Changed from websiteUrl to password
        enterText("//input[@name='phoneNumber']", "12345678");
        
        clickElement("//input[@value='USER_ADVERTISER']");
        clickElement("//input[@type='checkbox']");
        clickElement("//button[@type='submit']");
        
        System.out.println("Entering random text in email field");
        Thread.sleep(4000);

        WebElement validationMessage = findElement("//p[contains(text(), 'Please enter a valid Email')]");
        Assert.assertTrue(validationMessage.isDisplayed(), "Test Case Failed: Invalid Email did not show the validation message.");
        
        System.out.println("Test Case Passed, should not be able to signup due to invalid email.");
    }

    @Test(priority = 6)
    public void testcase6() throws InterruptedException {
        enterText("//input[@name='name']", "test");
        enterText("//input[@name='company']", "Account");
        enterText("//input[@name='email']", "abc@izooto.com");
        enterText("//input[@name='password']", "amazonpassword");  // Changed to password field
        enterText("//input[@name='phoneNumber']", "12345678");
        
        clickElement("//input[@value='USER_ADVERTISER']");
        clickElement("//input[@type='checkbox']");
        clickElement("//button[@type='submit']");
        
        System.out.println("Entering direct url without https:// in password field");
        Thread.sleep(4000);

        WebElement validationMessage = findElement("//p[contains(text(), 'Password should start with a letter')]");  // Adjusted for password validation
        Assert.assertTrue(validationMessage.isDisplayed(), "Test Case Failed: Invalid Password did not show the validation message.");
        
        System.out.println("Test Case Passed, should not be able to signup due to invalid password.");
    }

    @Test(priority = 7)
    public void testcase7() throws InterruptedException {
        enterText("//input[@name='name']", "test");
        enterText("//input[@name='company']", "Account");
        enterText("//input[@name='email']", "abc@izooto.com");
        enterText("//input[@name='password']", "securepass123");  // Changed to password field
        enterText("//input[@name='phoneNumber']", "12345678");
        
        clickElement("//input[@type='checkbox']");
        clickElement("//button[@type='submit']");
        
        System.out.println("Leaving Role field unchecked");
        Thread.sleep(4000);

        WebElement validationMessage = findElement("//div[contains(text(), 'Please choose your role to proceed!')]");
        Assert.assertTrue(validationMessage.isDisplayed(), "Test Case Failed: Role did not show the validation message.");
        
        System.out.println("Test Case Passed, should not be able to signup due to leaving role field");
    }

    @Test(priority = 8)
    public void testcase8() throws InterruptedException {
        enterText("//input[@name='name']", "test");
        enterText("//input[@name='company']", "Account");
        enterText("//input[@name='email']", "abc@izooto.com");
        enterText("//input[@name='password']", "password123");  // Changed to password field
        enterText("//input[@name='phoneNumber']", "1235");
        
        clickElement("//input[@value='USER_ADVERTISER']");
        clickElement("//input[@type='checkbox']");
        clickElement("//button[@type='submit']");
        
        System.out.println("Entering less than the minimum numbers limit in Phone Number Field");
        Thread.sleep(4000);

        WebElement validationMessage = findElement("//p[contains(text(), 'Minimum 7 numbers required')]");
        Assert.assertTrue(validationMessage.isDisplayed(), "Test Case Failed: Minimum 7 numbers required");
        
        System.out.println("Test Case Passed, should not be able to signup due to entering less than the minimum numbers limit in Phone Number Field");
    }

    @Test(priority = 9)
    public void testcase9() throws InterruptedException {
        enterText("//input[@name='name']", "test");
        enterText("//input[@name='company']", "@A");
        enterText("//input[@name='email']", "abc@izooto.com");
        enterText("//input[@name='password']", "secure123");  // Changed to password field
        enterText("//input[@name='phoneNumber']", "1235789");
        
        clickElement("//input[@value='USER_ADVERTISER']");
        clickElement("//input[@type='checkbox']");
        clickElement("//button[@type='submit']");
        
        System.out.println("Using Special characters in company field");
        Thread.sleep(4000);

        WebElement validationMessage = findElement("//p[contains(text(), 'Please use only numbers, letters, and spaces in this field.')]");
        Assert.assertTrue(validationMessage.isDisplayed(), "Test Case Failed: Special Characters not allowed in company field");
        
        System.out.println("Test Case Passed, should not be able to signup upon using special characters in company field");
    }

    @Test(priority = 10)
    public void testcase10() throws InterruptedException {
        enterText("//input[@name='name']", "@V");
        enterText("//input[@name='company']", "account");
        enterText("//input[@name='email']", "abc@izooto.com");
        enterText("//input[@name='password']", "validPass123");  // Changed to password field
        enterText("//input[@name='phoneNumber']", "1235789");
        
        clickElement("//input[@value='USER_ADVERTISER']");
        clickElement("//input[@type='checkbox']");
        clickElement("//button[@type='submit']");
        
        System.out.println("Using Special characters in name field");
        Thread.sleep(4000);

        WebElement validationMessage = findElement("//p[contains(text(), 'Please use letters and spaces only')]");
        Assert.assertTrue(validationMessage.isDisplayed(), "Test Case Failed: Special Characters not allowed in name field");
        
        System.out.println("Test Case Passed, should not be able to signup upon using special characters in name field");
    }

    private void enterText(String xpath, String text) throws InterruptedException {
        WebElement element = findElement(xpath);
        element.sendKeys(text);
        Thread.sleep(1000);
    }

    private void clickElement(String xpath) throws InterruptedException {
        WebElement element = findElement(xpath);
        element.click();
        Thread.sleep(1000);
    }

    private void validateField(String xpath, String expectedMessage, String fieldName) {
        try {
            WebElement element = findElement(xpath);
            String actualMessage = element.getText();

            System.out.println("Field: " + fieldName);
            System.out.println("Expected: " + expectedMessage);
            System.out.println("Actual: " + actualMessage);
            Assert.assertEquals(actualMessage, expectedMessage, fieldName + " validation failed");
        } catch (Exception e) {
            System.out.println(fieldName + " validation failed: " + e.getMessage());
        }
    }

    private WebElement findElement(String xpath) {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
