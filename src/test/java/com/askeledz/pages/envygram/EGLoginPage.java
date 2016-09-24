package com.askeledz.pages.envygram;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author askeledzija
 */
public class EGLoginPage {

    WebDriver driver;

    @FindBy(how = How.XPATH, using = ".//*[@id='loginDialogButton']")
    WebElement login_link;

    public EGLoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // go to sihn in page from login page
    public EGSignInPage goToSignInPage() {
        new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(login_link));
        login_link.click();
        return new EGSignInPage(driver);
    }

  //check if page is loaded
    public boolean isLoginPageLoaded() {
        return login_link.isDisplayed();
    }

}
