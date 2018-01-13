package com.askeledz.pages.wbd;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * @author askeledzija
 */
public class CountryPage {

    WebDriver driver;

    public CountryPage(WebDriver driver) {
        this.driver = driver;
        // CountryPage countryPage = PageFactory.initElements(DriverManager.getDriver(), CountryPage.class); -->
        // following is the same:
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//a[contains(.,'High income')]")
    WebElement highIncome_link;

    public HICPage goToHICPage() throws InterruptedException {
      //  new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(highIncome_link));
        highIncome_link.click();
        return new HICPage(driver);
    }

    // We will use this boolean for assertion. To check if page is opened
    public boolean isCountryPageLoaded() {
        return highIncome_link.isDisplayed();
    }

}
