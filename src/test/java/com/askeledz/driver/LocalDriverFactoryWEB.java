package com.askeledz.driver;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

/**
 * Author: askeledzija 
 * It's a generic WebDriver manager, it works with local and remote instances of WebDriver
 */
public class LocalDriverFactoryWEB {

    static Logger log = Logger.getLogger(LocalDriverFactoryWEB.class);

    static WebDriver createInstance(String browserName) {
        WebDriver driver = null;
        if (browserName.equalsIgnoreCase("firefox")) {
            // selenium-server-standalone-2.53.1 --> FireFox 46.0
            driver = new FirefoxDriver(); 
            log.info("LocalDriverFactory created aa instance of WebDriver for: " + browserName);
            return driver;
        }
        if (browserName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
            log.info("LocalDriverFactory created aa instance of WebDriver for: " + browserName);
            return driver;
        }
        if (browserName.equalsIgnoreCase("ie")) {
            driver = new InternetExplorerDriver();
            log.info("LocalDriverFactory created aa instance of WebDriver for: " + browserName);
            return driver;
        }
        if (browserName.toLowerCase().contains("safari")) {
           // System.setProperty("webdriver.safari.driver", "/Applications/Safari.app/Contents/MacOS/Safari");
            driver = new SafariDriver();
            log.info("LocalDriverFactory created aa instance of WebDriver for: " + browserName);
            return driver;
        }

        log.info("LocalDriverFactory created aa instance of WebDriver for: " + browserName);
        return driver;
    }
}