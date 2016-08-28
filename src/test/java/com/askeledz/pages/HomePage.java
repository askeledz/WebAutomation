package com.askeledz.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.askeledz.driver.DriverManager;

/**
 * @author askeledzija
 */
public class HomePage {

    WebDriver driver;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/ul[2]/li[3]/a")
    WebElement data_link;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // go to data page from home page
    public DataPage goToDataPage(){
        new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(data_link));
        data_link.click();
        return new DataPage(driver);
    }


    // We will use this boolean for assertion. To check if page is opened
    public boolean isHomePageLoaded() {
        return data_link.isDisplayed();
    }

}
