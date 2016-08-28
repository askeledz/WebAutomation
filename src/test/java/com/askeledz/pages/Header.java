package com.askeledz.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * @author askeledzija
 */
public class Header {

    WebDriver driver;

    public Header(WebDriver driver) {
       
        this.driver = driver;
//     Header countryPage = PageFactory.initElements(DriverManager.getDriver(), Header.class); --> following is the same:
        PageFactory.initElements(driver, this);
    }
   
    @FindBy(how = How.XPATH, using = "//*[@id=\"wbg-header\"]/div[2]/ul/li[1]/a")
    WebElement home_link;
    

    // We will use this boolean for assertion. To check if page is opened
    public boolean isHeaderLoaded() {
        return home_link.isDisplayed();
    }

}
