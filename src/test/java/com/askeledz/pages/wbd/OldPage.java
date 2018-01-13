package com.askeledz.pages.wbd;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * @author askeledzija
 */
public class OldPage {

    WebDriver driver;
    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[3]/div/ul[1]/li[1]/a")
    WebElement byCountry_link;

    @FindBy(how = How.XPATH, using = "//a[contains(.,'High income')]")
    WebElement highIncome_link;
    
    
    public OldPage(WebDriver driver) {
        this.driver = driver;
//      OldPage oldPage = PageFactory.initElements(DriverManager.getDriver(),  OldPage.class); --> following is the same:
        PageFactory.initElements(driver, this);
    }


    public CountryPage goToCountryIncomePage() {
    //    new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(byCountry_link));
        byCountry_link.click();
        return new CountryPage(driver);

    }    
    

    // We will use this boolean for assertion. To check if page is opened
    public boolean isOldPageLoaded() {
        return byCountry_link.isDisplayed();
    }

}
