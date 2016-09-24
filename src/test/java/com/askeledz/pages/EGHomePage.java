package com.askeledz.pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * @author askeledzija
 */
public class EGHomePage {

    WebDriver driver;

    String expectedTitle = "Envygram - Home";

    @FindBy(how = How.XPATH, using = ".//div[@id='yii_bootstrap_collapse_0']/ul")
    WebElement header_items;

    @FindBy(how = How.XPATH, using = ".//div[@id='yii_bootstrap_collapse_0']/ul/li[1]/a[@class='dropdown-toggle']")
    WebElement dropDown_btn;

    @FindBy(how = How.XPATH, using = ".//div[@id='yii_bootstrap_collapse_0']/ul/li[1]/ul")
    WebElement dropDown_list;

    @FindBy(how = How.XPATH, using = ".//div[@id='yii_bootstrap_collapse_0']/ul/li[4]/a[@class='settingsButton dropdown-toggle']")
    WebElement settings_btn;

    @FindBy(how = How.XPATH, using = ".//div[@id='yii_bootstrap_collapse_0']/ul/li[4]/ul")
    WebElement settings_list;

    @FindBy(how = How.XPATH, using = "//input[contains(@id,'search')]")
    WebElement search_form;

    @FindBy(how = How.XPATH, using = "//span[contains(@class,'label label-important notificationsUnread')]")
    WebElement notif_icon;

    @FindBy(how = How.XPATH, using = ".//*[@id='notificationsBox']/div/div[2]/div")
    WebElement notif_box;

    public EGHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void isHomePageloaded(WebDriver driver, String actualTitle) {
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    public void clickSettings_btn(WebDriver driver) {
        settings_btn.click();
    }

    public void clickDropDown_btn(WebDriver driver) {
        dropDown_btn.click();
    }

    public void clickNotifIcon_btn(WebDriver driver) {
        notif_icon.click();
    }

    public void searchTerm(WebDriver driver, String term) {
        search_form.click();
        search_form.sendKeys(term);
        search_form.sendKeys(Keys.RETURN);

    }

    public void clickSettings_option(WebDriver driver, String option) {
        // Click Edit Profile
        List<WebElement> allValidOptions = settings_list.findElements(By.tagName("a"));

        for (WebElement opt : allValidOptions) {
            if (opt.getText().equals(option)) {
                opt.click();
                break;
            }
        }
    }

    public void clickDropDown_option(WebDriver driver, String option) {

        List<WebElement> allValidOptions = dropDown_list.findElements(By.tagName("a"));

        for (WebElement opt : allValidOptions) {
            if (opt.getText().equals(option)) {
                opt.click();
                break;
            }
        }

    }

    public boolean isNotificationBoxShown(WebDriver driver) {
        return notif_box.isDisplayed();
    }

}
