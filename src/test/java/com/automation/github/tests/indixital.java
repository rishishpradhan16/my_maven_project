package com.automation.github.tests;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class indixital {

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
        clickElement("//input[@name='company']");
        clickElement("//input[@name='email']");
        clickElement("//input[@name='websiteUrl']");
        clickElement("//input[@name='phoneNumber']");
        clickElement("//input[@value='USER_PUBLISHER']");
        clickElement("//input[@type='checkbox']");
        clickElement("//button[@type='submit']");

        System.out.println("Checking validation after leaving all fields blank");

        validateField("//p[text()='Please Enter Your Name']", "Please Enter Your Name", "Name");
        validateField("//p[text()='Please Enter Your Company Name']", "Please Enter Your Company Name", "Company Name");
        validateField("//p[text()='Please Enter Your Email']", "Please Enter Your Email", "Email");
        validateField("//p[text()='Please Enter Website URL']", "Please Enter Website URL", "Website URL");
        validateField("//p[text()='Please Enter Phone Number']", "Please Enter Phone Number", "Phone Number");
    }

    @Test(priority = 2)
    public void testcase2() throws InterruptedException {
        
        enterText("//input[@name='name']", "Automation Account");
        enterText("//input[@name='company']", "Aajtak");
        enterText("//input[@name='email']", "rishish+stag@izooto.com");
        enterText("//input[@name='websiteUrl']", "https://rishishpradhan.serv00.net/");
        enterText("//input[@name='phoneNumber']", "8512074327");
        clickElement("//input[@value='USER_ADVERTISER']");
        clickElement("//input[@type='checkbox']");
        clickElement("//button[@type='submit']");

        System.out.println("Checking Already existed Email");
        Thread.sleep(2000);

        WebElement validationMessage = findElement("//p[contains(text(), 'Already registered')]");
        Assert.assertTrue(validationMessage.isDisplayed(), "Test Case Failed: 'Already registered' validation message not displayed.");
        
        System.out.println("Test Case Passed, should not able to signup due to already registered email.");
    }

    @Test(priority = 3)
    public void testcase3() throws InterruptedException {
       
        enterText("//input[@name='name']", "     ");
        enterText("//input[@name='company']", "     ");
        enterText("//input[@name='email']", "     ");
        enterText("//input[@name='websiteUrl']", "     ");
        enterText("//input[@name='phoneNumber']", "     ");
        
        clickElement("//input[@value='USER_ADVERTISER']");
        clickElement("//input[@type='checkbox']");
        clickElement("//button[@type='submit']");
        
        System.out.println("Entering only spaces in all fields");
        
        Thread.sleep(4000);

        WebElement validationMessage = findElement("//p[contains(text(), 'Spaces not allowed')]");
        Assert.assertTrue(validationMessage.isDisplayed(), "Test Case Failed: Spaces not allowed validation message not displayed.");
        
        System.out.println("Test Case Passed, should not able to signup due to spaces in fields.");
    }
    
    @Test(priority = 4)
    public void testcase4() {
       
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement iconImage = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@alt='icon logo']")));
        iconImage.click();
        
        try {
            Thread.sleep(4000);  
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String currentUrl = driver.getCurrentUrl();

        Assert.assertNotEquals(currentUrl, "https://stage1.indixital.com/register/dashboard", 
                               "Test Case failed: Image Icon is redirecting to Dashboard and showing error 404 page");

        System.out.println("Test Case Passed");
    }
    
    @Test(priority = 5)
    public void testcase5() throws InterruptedException {
        
        enterText("//input[@name='name']", "test");
        enterText("//input[@name='company']", "Account");
        enterText("//input[@name='email']", "abcd");  // Invalid email
        enterText("//input[@name='websiteUrl']", "https://amazon.com");
        enterText("//input[@name='phoneNumber']", "12345678");
        
        clickElement("//input[@value='USER_ADVERTISER']");
        clickElement("//input[@type='checkbox']");
        clickElement("//button[@type='submit']");
        
        System.out.println("Entering random text in email field");
        Thread.sleep(4000);

        WebElement validationMessage = findElement("//p[contains(text(), 'Please enter a valid Email')]");
        Assert.assertTrue(validationMessage.isDisplayed(), "Test Case Failed: Invalid Email did not show the validation message.");
        
        System.out.println("Test Case Passed, should not able to signup due to invalid email.");
    }

    @Test(priority = 6)
    public void testcase6() throws InterruptedException {
       
        enterText("//input[@name='name']", "test");
        enterText("//input[@name='company']", "Account");
        enterText("//input[@name='email']", "abc@izooto.com");
        enterText("//input[@name='websiteUrl']", "amazon.com");  
        enterText("//input[@name='phoneNumber']", "12345678");
        
        clickElement("//input[@value='USER_ADVERTISER']");
        clickElement("//input[@type='checkbox']");
        clickElement("//button[@type='submit']");
        
        System.out.println("Entering direct url without https:// in website field");
        Thread.sleep(4000);

        WebElement validationMessage = findElement("//p[contains(text(), 'Website URL should start with http:// or https://')]");
        Assert.assertTrue(validationMessage.isDisplayed(), "Test Case Failed: Invalid Website URL did not show the validation message.");
        
        System.out.println("Test Case Passed, should not able to signup due to invalid website URL.");
    }
    
    @Test(priority = 7)
    public void testcase7() throws InterruptedException {
       
        enterText("//input[@name='name']", "test");
        enterText("//input[@name='company']", "Account");
        enterText("//input[@name='email']", "abc@izooto.com");
        enterText("//input[@name='websiteUrl']", "https://amazon.com");  
        enterText("//input[@name='phoneNumber']", "12345678");
        
        clickElement("//input[@type='checkbox']");
        clickElement("//button[@type='submit']");
        
        System.out.println("Leaving Role field unchecked");
        Thread.sleep(4000);

        WebElement validationMessage = findElement("//div[contains(text(), 'Please choose your role to proceed!')]");
        Assert.assertTrue(validationMessage.isDisplayed(), "Test Case Failed:Role did not show the validation message.");
        
        System.out.println("Test Case Passed, should not able to signup due to leaving role field");
    }
    
    @Test(priority = 8)
    public void testcase8() throws InterruptedException {
       
        enterText("//input[@name='name']", "test");
        enterText("//input[@name='company']", "Account");
        enterText("//input[@name='email']", "abc@izooto.com");
        enterText("//input[@name='websiteUrl']", "https://amazon.com");  
        enterText("//input[@name='phoneNumber']", "1235");
        
        clickElement("//input[@value='USER_ADVERTISER']");
        clickElement("//input[@type='checkbox']");
        clickElement("//button[@type='submit']");
        
        System.out.println("Entering less than the minimum numbers limit in Phone Number Field");
        Thread.sleep(4000);

        WebElement validationMessage = findElement("//p[contains(text(), 'Minimum 7 numbers required')]");
        Assert.assertTrue(validationMessage.isDisplayed(), "Test Case Failed:Minimum 7 numbers required");
        
        System.out.println("Test Case Passed, should not able to signup due to Entering less than the minimum numbers limit in Phone Number Field");
    }
    
    @Test(priority = 9)
    public void testcase9() throws InterruptedException {
       
        enterText("//input[@name='name']", "test");
        enterText("//input[@name='company']", "@A");
        enterText("//input[@name='email']", "abc@izooto.com");
        enterText("//input[@name='websiteUrl']", "https://amazon.com");  
        enterText("//input[@name='phoneNumber']", "1235789");
        
        clickElement("//input[@value='USER_ADVERTISER']");
        clickElement("//input[@type='checkbox']");
        clickElement("//button[@type='submit']");
        
        System.out.println("Using Special characters in company field");
        Thread.sleep(4000);

        WebElement validationMessage = findElement("//p[contains(text(), 'Please use only numbers, letters, and spaces in this field.')]");
        Assert.assertTrue(validationMessage.isDisplayed(), "Test Case Failed:Special Characters not allowed in company field");
        
        System.out.println("Test Case Passed, should not able to signup upon using special characters in company field");
    }
    
    @Test(priority = 10)
    public void testcase10() throws InterruptedException {
       
        enterText("//input[@name='name']", "@V");
        enterText("//input[@name='company']", "account");
        enterText("//input[@name='email']", "abc@izooto.com");
        enterText("//input[@name='websiteUrl']", "https://amazon.com");  
        enterText("//input[@name='phoneNumber']", "1235789");
        
        clickElement("//input[@value='USER_ADVERTISER']");
        clickElement("//input[@type='checkbox']");
        clickElement("//button[@type='submit']");
        
        System.out.println("Using Special characters in name field");
        Thread.sleep(4000);

        WebElement validationMessage = findElement("//p[contains(text(), 'Please use letters and spaces only')]");
        Assert.assertTrue(validationMessage.isDisplayed(), "Test Case Failed:Special Characters not allowed in name field");
        
        System.out.println("Test Case Passed, should not able to signup upon using special characters in name field");
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

            if (expectedMessage.equals(actualMessage)) {
                System.out.println("Test Passed: Validation message for " + fieldName + " is correct.");
            } else {
                System.out.println("Test Failed: Validation message for " + fieldName + " is incorrect.");
            }
        } catch (Exception e) {
            System.out.println("Test Failed: Element for validation message not found for " + fieldName);
        }
    }

    private void checkValidationMessage(String xpath, String successMessage, String failureMessage) {
        try {
            WebElement confirmationMessage = findElement(xpath);
            if (confirmationMessage.isDisplayed()) {
                System.out.println(successMessage);
            }
        } catch (Exception e) {
            System.out.println(failureMessage);
        }
    }

    private WebElement findElement(String xpath) {
        return driver.findElement(By.xpath(xpath));
    }
    
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
