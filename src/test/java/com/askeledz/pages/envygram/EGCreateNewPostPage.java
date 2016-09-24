package com.askeledz.pages.envygram;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * @author askeledzija
 */
public class EGCreateNewPostPage {

    WebDriver driver;

    @FindBy(how = How.XPATH, using = "//input[contains(@name,'PostCreate[header]')]")
    WebElement headline_form;

    @FindBy(how = How.XPATH, using = ".//*[@id='PostCreate']/div[1]/div[2]/div/div[2]/div[1]/a[2]")
    WebElement media_dropDown_btn;

    @FindBy(how = How.XPATH, using = ".//*[@id='yw1']")
    WebElement media_dropDown_list;

    @FindBy(how = How.XPATH, using = "//textarea[contains(@id,'PostCreate_source')]")
    WebElement insert_video_url_text;

    @FindBy(how = How.XPATH, using = ".//*[@id='uploadFromEmbedcodeDialog']/div[3]/a[1]")
    WebElement save_btn;

    @FindBy(how = How.XPATH, using = ".//*[@id='createNewPost']")
    WebElement create_new_post_btn;

    @FindBy(how = How.XPATH, using = ".//*[@id='createNewPostDialog']/div[3]/div[1]/a[1]")
    WebElement cancel_new_post_btn;

    @FindBy(how = How.XPATH, using = "//select[contains(@name,'PostCreate[adType]')]")
    WebElement adType_dropDown;

    @FindBy(how = How.XPATH, using = "//textarea[contains(@name,'PostCreate[description]')]")
    WebElement description_form;

    public EGCreateNewPostPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickCreateNewPost_btn(WebDriver driver) {
        create_new_post_btn.click();
    }

    public void clickCancelNewPost_btn(WebDriver driver) {
        cancel_new_post_btn.click();
    }

    public void insertVideoURL(WebDriver driver, String url) {
        insert_video_url_text.click();
        insert_video_url_text.sendKeys(url);
        save_btn.click();

    }

    public void fillHeadLineForm(WebDriver driver, String text) {
        headline_form.click();
        headline_form.sendKeys(text);
    }

    public void chooseAdTypeDropdownOption(String text) {
        Select selAdTypeDropDown = new Select(adType_dropDown);
        selAdTypeDropDown.selectByVisibleText(text);
    }

    public void clickMediaDropDown_btn(WebDriver driver) {
        media_dropDown_btn.click();
    }

    public void writeDescription(WebDriver driver, String text) {
        description_form.click();
        description_form.sendKeys(text);
    }

    public void clickMedia_option(WebDriver driver, String option) {

        List<WebElement> allValidOptions = media_dropDown_list.findElements(By.tagName("a"));

        for (WebElement opt : allValidOptions) {
            if (opt.getText().equals(option)) {
                opt.click();
                break;
            }
        }
    }

}
