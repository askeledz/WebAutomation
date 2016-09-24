package com.askeledz.test;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.askeledz.driver.DriverManager;
import com.askeledz.pages.EGAccountSettingsPage;
import com.askeledz.pages.EGCreateNewPostPage;
import com.askeledz.pages.EGHomePage;
import com.askeledz.pages.EGLoginPage;
import com.askeledz.pages.EGSignInPage;

import java.io.IOException;

public class EnvyGramTestBase {

    static Logger log = Logger.getLogger(EnvyGramTestBase.class);
    private static String PAGE_URL = "http://68.169.52.12/EnvyGram/html";
    private static WebDriver driver = null;
    private static String USER = "askeledz";
    private static String PASS = "qwerty";
    
    //Dropdown header list
    private static String dropDown_header_option1 = "Create New Post";
    //Dropdown settings list
    private static String dropDown_settings_option1 = "Edit profile";
    private static String dropDown_settings_option13 = "Log out";


    public void SignIn() throws InterruptedException, IOException {

        driver = invokeBrowser(PAGE_URL);
        EGLoginPage loginPage = new EGLoginPage(driver);
        Assert.assertTrue(loginPage.isLoginPageLoaded());
        Thread.sleep(3000);
        EGSignInPage signInPage = loginPage.goToSignInPage();
        Thread.sleep(4000);
        Assert.assertTrue(signInPage.isSignInPageLoaded());
        signInPage.signInToHomePage(USER, PASS);
        Thread.sleep(3000);

    }

    public void CreateNewPost() throws InterruptedException, IOException {

        EGHomePage homePage = new EGHomePage(driver);
        String actualTitle = driver.getTitle();
        homePage.isHomePageloaded(driver, actualTitle);
        homePage.clickDropDown_btn(driver);
        homePage.clickDropDown_option(driver, dropDown_header_option1);
        Thread.sleep(6000);

        EGCreateNewPostPage createNewPostPage = new EGCreateNewPostPage(driver);
        createNewPostPage.fillHeadLineForm(driver, "This is new post!");
        createNewPostPage.clickMediaDropDown_btn(driver);
        createNewPostPage.clickMedia_option(driver, "Video Link");
        Thread.sleep(3000);
        createNewPostPage.insertVideoURL(driver, "https://youtu.be/QAI2gXDVn1g");
        Thread.sleep(3000);
        createNewPostPage.chooseAdTypeDropdownOption("handwritting");
        Thread.sleep(3000);
        createNewPostPage.writeDescription(driver, "This is our super post :) ");
        Thread.sleep(3000);
        createNewPostPage.clickCreateNewPost_btn(driver);

    }

    public void CancelNewPost() throws InterruptedException, IOException {

        EGHomePage homePage = new EGHomePage(driver);
        String actualTitle = driver.getTitle();
        homePage.isHomePageloaded(driver, actualTitle);
        homePage.clickDropDown_btn(driver);
        homePage.clickDropDown_option(driver, dropDown_header_option1);
        Thread.sleep(6000);

        EGCreateNewPostPage createNewPostPage = new EGCreateNewPostPage(driver);
        Thread.sleep(3000);
        createNewPostPage.clickCancelNewPost_btn(driver);

    }

    public void SearchPosts() throws InterruptedException, IOException {

        EGHomePage homePage = new EGHomePage(driver);
        String actualTitle = driver.getTitle();
        homePage.isHomePageloaded(driver, actualTitle);

        homePage.searchTerm(driver, "test");

    }

    public void NotificationsCheck() throws InterruptedException, IOException {

        EGHomePage homePage = new EGHomePage(driver);
        String actualTitle = driver.getTitle();
        homePage.isHomePageloaded(driver, actualTitle);

        homePage.clickNotifIcon_btn(driver);
        Assert.assertTrue(homePage.isNotificationBoxShown(driver));
    }

    public void EditProfile() throws InterruptedException, IOException {

        EGHomePage homePage = new EGHomePage(driver);
        String actualTitle = driver.getTitle();
        homePage.isHomePageloaded(driver, actualTitle);

        homePage.clickSettings_btn(driver);
        homePage.clickSettings_option(driver, dropDown_settings_option1);
        Thread.sleep(3000);

        EGAccountSettingsPage accountSettingsPage = new EGAccountSettingsPage(driver);
        Thread.sleep(3000);
        accountSettingsPage.chooseCountryDropdownOption("45");
        accountSettingsPage.chooseMartialDropdownOption("1");
        accountSettingsPage.clickSaveSettings_btn(driver);

    }

    public void CancelEditProfile() throws InterruptedException, IOException {

        EGHomePage homePage = new EGHomePage(driver);
        String actualTitle = driver.getTitle();
        homePage.isHomePageloaded(driver, actualTitle);

        homePage.clickSettings_btn(driver);
        homePage.clickSettings_option(driver, dropDown_settings_option1);
        Thread.sleep(3000);

        EGAccountSettingsPage accountSettingsPage = new EGAccountSettingsPage(driver);
        Thread.sleep(3000);
        accountSettingsPage.chooseCountryDropdownOption("45");
        accountSettingsPage.chooseMartialDropdownOption("1");
        accountSettingsPage.clickCancelSettings_btn(driver);

    }

    public void LogOut() throws InterruptedException, IOException {

        EGHomePage homePage = new EGHomePage(driver);
        String actualTitle = driver.getTitle();
        homePage.isHomePageloaded(driver, actualTitle);

        homePage.clickSettings_btn(driver);
        homePage.clickSettings_option(driver, dropDown_settings_option13);

    }

    /*********** helper methods *************/

    private WebDriver invokeBrowser(String url) {
        
        WebDriver driver = DriverManager.getDriver();

        log.info("Thread id = " + Thread.currentThread().getId());
        log.info("Hash code of webDriver instance = " + driver.hashCode());
        log.info("Test executed using = " + DriverManager.getBrowserInfo());
        driver.get(url);

        return driver;
    }
}