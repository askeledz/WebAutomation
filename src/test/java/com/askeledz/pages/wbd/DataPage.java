package com.askeledz.pages.wbd;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * @author askeledzija
 */
public class DataPage {

    WebDriver driver;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div/span/a")
    WebElement old_site_link;

    public DataPage(WebDriver driver) {
        this.driver = driver;
//      DataPage dataPage = PageFactory.initElements(DriverManager.getDriver(), DataPage.class); --> following is the same:
        PageFactory.initElements(driver, this);
    }


    public OldPage goToOldPage() {
       // new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(old_site_link));
        old_site_link.click();
        return new OldPage(driver);
    }
    

    // We will use this boolean for assertion. To check if page is opened
    public boolean isDataPageLoaded() {
        return old_site_link.getText().toString().contains("visit the old site here");
    }
}