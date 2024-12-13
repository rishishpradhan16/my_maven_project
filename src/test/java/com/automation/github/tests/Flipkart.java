package com.automation.github.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Flipkart {
private WebDriver driver;
public WebElement findElement(By locator) {
    return driver.findElement(locator);
}
    
	private DriverFactory driverFactory;
	@BeforeMethod
	public void setup() throws InterruptedException {
		 driverFactory = new DriverFactory();
	        
	     driver = driverFactory.initializeDriver(); 
	        
	     driverFactory.openApplication();
	     
	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	@Test(priority=1)
	public void testcase1() throws InterruptedException {
		
		 By searchBoxLocator = By.xpath("//input[@title='Search for Products, Brands and More']");
	        WebElement searchBox = findElement(searchBoxLocator);
	        searchBox.click();
	        
	        searchBox.sendKeys("Apple iPhone 15 (Pink, 128 GB)");
	        searchBox.sendKeys(Keys.ENTER);
	        
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        try {
	            // Check if the desired product is present
	            By productLocator = By.xpath("//div[text()='Apple iPhone 15 (Pink, 128 GB)']");
	            WebElement productElement = wait.until(ExpectedConditions.presenceOfElementLocated(productLocator));

	            // If the product is found, print success and pass the test
	            if (productElement.isDisplayed()) {
	                System.out.println("OnePlus 11R 5G (Galactic Silver, 256 GB) is found. Test Passed.");
	            }
	        } catch (Exception e) {
	            // If the product is not found, print failure and fail the test
	            System.out.println("OnePlus 11R 5G (Galactic Silver, 256 GB) is not found. Test Failed.");
	            Assert.fail("OnePlus 11R 5G (Galactic Silver, 256 GB) is not found in the search results.");
	        }
	        
	}
	
	@Test(priority=2)
	public void testcase2() throws InterruptedException {
		
		 By searchBoxLocator = By.xpath("//input[@title='Search for Products, Brands and More']");
	        WebElement searchBox = findElement(searchBoxLocator);
	        searchBox.click();
	        
	        searchBox.sendKeys("OnePlus 11R 5G (Galactic Silver, 256 GB)");
	        searchBox.sendKeys(Keys.ENTER);
	        
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        try {
	            // Check if the desired product is present
	            By productLocator = By.xpath("//div[text()='OnePlus 11R 5G (Galactic Silver, 256 GB)']");
	            WebElement productElement = wait.until(ExpectedConditions.presenceOfElementLocated(productLocator));

	            // If the product is found, print success and pass the test
	            if (productElement.isDisplayed()) {
	                System.out.println("OnePlus 11R 5G (Galactic Silver, 256 GB) is found. Test Passed.");
	            }
	        } catch (Exception e) {
	            // If the product is not found, print failure and fail the test
	            System.out.println("OnePlus 11R 5G (Galactic Silver, 256 GB) is not found. Test Failed.");
	            Assert.fail("OnePlus 11R 5G (Galactic Silver, 256 GB) is not found in the search results.");
	        }
	        
	}
	
	@Test(priority=3)
	public void testcase3() throws InterruptedException {
		
		 By searchBoxLocator = By.xpath("//input[@title='Search for Products, Brands and More']");
	        WebElement searchBox = findElement(searchBoxLocator);
	        searchBox.click();
		
	        By mobilesLocator = By.xpath("//div[text()='mobiles']");
	        WebElement mobilesElement = findElement(mobilesLocator);
	        mobilesElement.click();
	        
	        By sortLocator = By.xpath("//div[text()='Price -- Low to High']");
	        WebElement sortElement = findElement (sortLocator);
	        sortElement.click();
	        
	        By compareLocator = By.xpath("(//span[text()='Add to Compare'])[1]");
	        WebElement compareElement = findElement(compareLocator);

	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        WebElement clickableCompareElement = wait.until(ExpectedConditions.elementToBeClickable(compareElement));

	        Actions actions = new Actions(driver);
	        actions.moveToElement(clickableCompareElement).click().perform();
	        
	        Thread.sleep(2000);
	        
	        By compareLocator1 = By.xpath("//span[text()='COMPARE']");
	        WebElement compareElement1 = findElement(compareLocator1);
	        compareElement1.click();
	        
	        By brandLocator = By.xpath("(//div[text()='Choose Brand'])[1]");
	        WebElement brandElement = findElement(brandLocator);
	        brandElement.click();
	        
	        By brandLocator1 = By.xpath("(//div[text()='SAMSUNG'])[1]");
	        WebElement brandElement1 = findElement(brandLocator1);
	        brandElement1.click();
	 
	        try {

	            By retryLocator = By.xpath("//div[text()='RETRY']");
	            WebElement retryElement = findElement(retryLocator);

	            System.out.println("Compare functionality is not working properly");
	            Assert.fail("Compare functionality is not working properly");
	        } catch (Exception e) {

	            System.out.println("Compare functionality is working properly");
	        }
	        
	}


	
	@Test(priority=4)
	public void testcase4() throws InterruptedException {
		
		 By searchBoxLocator = By.xpath("//input[@title='Search for Products, Brands and More']");
	        WebElement searchBox = findElement(searchBoxLocator);
	        searchBox.click();
		
	        By mobilesLocator = By.xpath("//div[text()='mobiles']");
	        WebElement mobilesElement = findElement(mobilesLocator);
	        mobilesElement.click();
	        
	        By sortLocator = By.xpath("//div[text()='Price -- High to Low']");
	        WebElement sortElement = findElement (sortLocator);
	        sortElement.click();
	        
	        By compareLocator = By.xpath("(//span[text()='Add to Compare'])[1]");
	        WebElement compareElement = findElement(compareLocator);

	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        WebElement clickableCompareElement = wait.until(ExpectedConditions.elementToBeClickable(compareElement));

	        Actions actions = new Actions(driver);
	        actions.moveToElement(clickableCompareElement).click().perform();
	        
	        Thread.sleep(2000);
	        
	        By compareLocator1 = By.xpath("//span[text()='COMPARE']");
	        WebElement compareElement1 = findElement(compareLocator1);
	        compareElement1.click();
	        
	        By brandLocator = By.xpath("(//div[text()='Choose Brand'])[1]");
	        WebElement brandElement = findElement(brandLocator);
	        brandElement.click();
	        
	        By brandLocator1 = By.xpath("(//div[text()='SAMSUNG'])[1]");
	        WebElement brandElement1 = findElement(brandLocator1);
	        brandElement1.click();
	 
	        try {

	            By retryLocator = By.xpath("//div[text()='RETRY']");
	            WebElement retryElement = findElement(retryLocator);

	            System.out.println("Compare functionality is not working properly");
	            Assert.fail("Compare functionality is not working properly");
	        } catch (Exception e) {

	            System.out.println("Compare functionality is working properly");
	        }
	        
	}
	
	@Test(priority=5)
	public void testcase5() throws InterruptedException {
		
		 By electronicsLocator = By.xpath("//span[text()='Electronics']");
	        WebElement electronics = findElement(electronicsLocator);
	        electronics.click();
	        
	        By camerasLocator = By.xpath("//a[text()='Cameras & Accessories']");
	        WebElement cameras = findElement(camerasLocator);
	        Actions actions = new Actions(driver);
	        actions.moveToElement(cameras).perform(); 
	        
	     By camerasLocator1 = By.xpath("//a[text()='DSLR & Mirrorless']");
	        WebElement cameras1 = findElement(camerasLocator1);
	        cameras1.click();
	        
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        try {
	            // Check if the header is present
	            By headerLocator = By.xpath("//h1[text()='DSLR & Mirrorless']");
	            WebElement header = wait.until(ExpectedConditions.presenceOfElementLocated(headerLocator));

	            // If the header is displayed, pass the test
	            if (header.isDisplayed()) {
	                System.out.println("Header 'DSLR & Mirrorless' is displayed. Test Passed.");
	            }
	        } catch (Exception e) {
	            // If the header is not found, fail the test
	            System.out.println("Header 'DSLR & Mirrorless' is not displayed. Test Failed.");
	            Assert.fail("Header 'DSLR & Mirrorless' is not displayed after navigation.");
	        }
	        	
	}
	
	@Test(priority=6)
	public void testcase6() throws InterruptedException {
		
		 By electronicsLocator = By.xpath("//span[text()='Electronics']");
	        WebElement electronics = findElement(electronicsLocator);
	        electronics.click();
	        
	        By gamingLocator = By.xpath("//a[text()='Gaming']");
	        WebElement gaming = findElement(gamingLocator);
	        Actions actions = new Actions(driver);
	        actions.moveToElement(gaming).perform();
	        
	     By keyboardLocator = By.xpath("//a[text()='Gaming Keyboards']");
	        WebElement keyboard = findElement(keyboardLocator);
	        keyboard.click();
	        
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        try {
	            // Check if the header is present
	            By headerLocator = By.xpath("//h1[text()='Keyboards']");
	            WebElement header = wait.until(ExpectedConditions.presenceOfElementLocated(headerLocator));

	            // If the header is displayed, pass the test
	            if (header.isDisplayed()) {
	                System.out.println("Header 'Gaming Keyboards' is displayed. Test Passed.");
	            }
	        } catch (Exception e) {
	            // If the header is not found, fail the test
	            System.out.println("Header 'Gaming Keyboards' is not displayed. Test Failed.");
	            Assert.fail("Header 'Gaming Keyboards' is not displayed after navigation.");
	        }
	        	
	}
	
	@Test(priority=7)
	public void testcase7() throws InterruptedException {
		
		 By fashionLocator = By.xpath("//span[text()='Fashion']");
	        WebElement fashion = findElement(fashionLocator);
	        fashion.click();
	        
	        By kidsLocator = By.xpath("//a[text()='Kids']");
	        WebElement kids = findElement(kidsLocator);
	        Actions actions = new Actions(driver);
	        actions.moveToElement(kids).perform();
	        
	     By InfantWearLocator = By.xpath("//a[text()='Infant Wear']");
	        WebElement InfantWear = findElement(InfantWearLocator);
	        InfantWear.click();
	        
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        try {
	            // Check if the header is present
	            By headerLocator = By.xpath("//h1[text()='Clothing And Accessories']");
	            WebElement header = wait.until(ExpectedConditions.presenceOfElementLocated(headerLocator));

	            // If the header is displayed, pass the test
	            if (header.isDisplayed()) {
	                System.out.println("Header 'Clothing And Accessories' is displayed. Test Passed.");
	            }
	        } catch (Exception e) {
	            // If the header is not found, fail the test
	            System.out.println("Header 'Clothing And Accessories' is not displayed. Test Failed.");
	            Assert.fail("Header 'Clothing And Accessories' is not displayed after navigation.");
	        }
	        	
	}
	
	
	@Test(priority=8)
	public void testcase8() throws InterruptedException {
		
		 By fashionLocator = By.xpath("//span[text()='Fashion']");
	        WebElement fashion = findElement(fashionLocator);
	        fashion.click();
	        
	        By WomenEthnicLocator = By.xpath("//a[text()='Women Ethnic']");
	        WebElement WomenEthnic = findElement(WomenEthnicLocator);
	        Actions actions = new Actions(driver);
	        actions.moveToElement(WomenEthnic).perform();
	        
	     By WomenSareesLocator = By.xpath("//a[text()='Women Sarees']");
	        WebElement WomenSarees = findElement(WomenSareesLocator);
	        WomenSarees.click();
	        
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        try {
	            // Check if the header is present
	            By headerLocator = By.xpath("//h2[text()='Brands you Love']");
	            WebElement header = wait.until(ExpectedConditions.presenceOfElementLocated(headerLocator));

	            // If the header is displayed, pass the test
	            if (header.isDisplayed()) {
	                System.out.println("Header 'Brands you Love' is displayed. Test Passed.");
	            }
	        } catch (Exception e) {
	            // If the header is not found, fail the test
	            System.out.println("Header 'Brands you Love' is not displayed. Test Failed.");
	            Assert.fail("Header 'Brands you Love' is not displayed after navigation.");
	        }
	        	
	}
	
	@Test(priority=9)
	public void testcase9() throws InterruptedException {
		
		 By GroceryLocator = By.xpath("//span[text()='Grocery']");
	        WebElement Grocery = findElement(GroceryLocator);
	        Grocery.click();
	        
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        try {
	            By pincodeLocator = By.xpath("//div[text()='Please enter pincode']");
	            WebElement pincodeElement = wait.until(ExpectedConditions.presenceOfElementLocated(pincodeLocator));

	            // Verify if the element is displayed
	            if (pincodeElement.isDisplayed()) {
	                System.out.println("'Please enter pincode' message is displayed. Test Passed.");
	            }
	        } catch (Exception e) {
	            // If the element is not found, fail the test
	            System.out.println("'Please enter pincode' message is not displayed. Test Failed.");
	            Assert.fail("'Please enter pincode' message is not displayed after clicking on 'Ghee & Oils'.");
	        }
	    }
	
	@Test(priority=10)
	public void testcase10() throws InterruptedException {
		
		 By AppliancesLocator = By.xpath("//span[text()='Appliances']");
	        WebElement Appliances = findElement(AppliancesLocator);
	        Appliances.click();
	        
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        try {
	            By AppliancesLocator1 = By.xpath("//h1[text()='TVs and Appliances']");
	            WebElement AppliancesElement1 = wait.until(ExpectedConditions.presenceOfElementLocated(AppliancesLocator1));

	            // Verify if the element is displayed
	            if (AppliancesElement1.isDisplayed()) {
	                System.out.println("'TVs and Appliancese' message is displayed. Test Passed.");
	            }
	        } catch (Exception e) {
	            // If the element is not found, fail the test
	            System.out.println("'TVs and Appliances' message is not displayed. Test Failed.");
	            Assert.fail("'TVs and Appliances' message is not displayed after clicking on 'Ghee & Oils'.");
	        }
	    }
	
	
	@AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

}