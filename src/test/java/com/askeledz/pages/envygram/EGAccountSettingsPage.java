package com.askeledz.pages.envygram;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * @author askeledzija
 */
public class EGAccountSettingsPage {

    WebDriver driver;

    @FindBy(how = How.XPATH, using = "//select[contains(@name,'ProfileEdit[country]')]")
    WebElement country_dropDown;

    @FindBy(how = How.XPATH, using = "//select[contains(@name,'ProfileEdit[maritalStatus]')]")
    WebElement marital_dropDown;

    @FindBy(how = How.XPATH, using = ".//*[@id='createNewPost']")
    WebElement save_settings_btn;

    @FindBy(how = How.XPATH, using = ".//*[@id='ProfileEdit']/div[2]/div/div/div/a")
    WebElement cancel_settings_btn;

    public EGAccountSettingsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickSaveSettings_btn(WebDriver driver) {
        save_settings_btn.click();
    }

    public void clickCancelSettings_btn(WebDriver driver) {
        cancel_settings_btn.click();
    }

    public void chooseCountryDropdownOption(String text) {
        Select selCountryDropDown = new Select(country_dropDown);
        selCountryDropDown.selectByValue(text);
    }

    public void chooseMartialDropdownOption(String text) {
        Select selMaritalDropDown = new Select(marital_dropDown);
        selMaritalDropDown.selectByValue(text);
    }

}
