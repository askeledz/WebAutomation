package com.askeledz.pages.wbd;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.askeledz.driver.DriverManager;

/**
 * @author askeledzija
 */
public class HICPage {

    WebDriver driver;

    @FindBy(how = How.XPATH, using = "//*[@id=\"wbg-header\"]/div[2]/ul/li[1]/a")
    WebElement home_link;

    // Create webElement - block with some links
    @FindBy(how = How.XPATH, using = "//div[@id='block-views-income_levels_countries-block_1']")
    WebElement links_blok;
    
    public HICPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public Header goHome() throws InterruptedException {
        new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(home_link));
        home_link.click();
        return new Header(driver);
    }

    // We will use this boolean for assertion. To check if page is opened
    public boolean isHICPageLoaded() {
        return links_blok.isDisplayed();
    }
    
    // Get all (links) from specific block by tagName
    public <T> List<WebElement> linksGetter() {
        List<WebElement> links = links_blok.findElements(By.tagName("a"));
        // return new ArrayList<T>();
        return links;
    }
   
    // Get all text from all links in specific block (countries names)
    public <T> List<String> textFromLinksGetter() {
        List<String> countries = new ArrayList<String>();
        for (WebElement countryName : this.linksGetter()) {
        countries.add(countryName.getText());
        }
        return countries;
    }
    
  
}

