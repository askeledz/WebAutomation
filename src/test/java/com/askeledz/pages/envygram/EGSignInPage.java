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
public class EGSignInPage {

    WebDriver driver;

    @FindBy(how = How.XPATH, using = ".//*[@id='UserLogin_email']")
    WebElement user_mail;
    
    @FindBy(how = How.XPATH, using = ".//*[@id='UserLogin_password']")
    WebElement user_pass;
    
    @FindBy(how = How.XPATH, using = ".//*[@id='signIn']")
    WebElement signin_btt;

    public EGSignInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // go to home page from sign in page
    public EGHomePage signInToHomePage(String username, String pass){
        new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(signin_btt));
        user_mail.sendKeys(username);
        user_pass.sendKeys(pass);
        signin_btt.click();
        return new EGHomePage(driver);
    }


    //check if page is loaded
    public boolean isSignInPageLoaded() {
        return user_mail.isDisplayed();   
    }

}
