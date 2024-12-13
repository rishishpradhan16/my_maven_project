package com.automation.github.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    private WebDriver driver;
    private ConfigReader configReader;

    public DriverFactory() {
        configReader = new ConfigReader();
    }

    public WebDriver initializeDriver() {
        String browser = configReader.getBrowser().toLowerCase();

        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;    
            default:
                System.out.println("Browser not supported!");
                break;
        }
        
        // Maximize the browser window after initialization
        driver.manage().window().maximize();

        return driver;
    }

    public void openApplication() {
        driver.get(configReader.getUrl());
    }
}
