package com.askeledz.test;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.askeledz.driver.DriverManager;
import com.askeledz.pages.Country;
import com.askeledz.pages.CountryPage;
import com.askeledz.pages.DataPage;
import com.askeledz.pages.HICPage;
import com.askeledz.pages.Header;
import com.askeledz.pages.HomePage;
import com.askeledz.pages.OldPage;
import com.askeledz.pages.ValuesPage;
import com.askeledz.utils.CSVUtil;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import java.util.concurrent.TimeUnit;

public class VerifyWBDTest {

    static Logger log = Logger.getLogger(VerifyWBDTest.class);
    private static String PAGE_URL = "http://www.worldbank.org/";

    private static WebDriver driver = null;

    @Test
    public void testVerifyHomePage() throws InterruptedException, IOException {

        //driver = DriverManager.getDriver();

        driver = invokeBrowser(PAGE_URL);

        // create home page object....
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isHomePageLoaded());

        // go to data page from home page
        DataPage dataPage = homePage.goToDataPage();

        // Check that data page is loaded
        Assert.assertTrue(dataPage.isDataPageLoaded());

        // go to old page from data page
        OldPage oldPage = dataPage.goToOldPage();

        // go to country page from old page
        CountryPage countryPage = oldPage.goToCountryIncomePage();

        // Check that country page is loaded
        Assert.assertTrue(countryPage.isCountryPageLoaded());

        HICPage hicPage = countryPage.goToHICPage();

        // Check that HIC page is loaded
        Assert.assertTrue(hicPage.isHICPageLoaded());

        // Go to each country page and read data
        int j = 0;
        List<Country> countryList = new ArrayList<Country>();
        for (Iterator<String> i = hicPage.textFromLinksGetter().iterator(); i.hasNext(); j++) {
            String item = i.next();

            // Just for debug go to only 5 countries
            // if (links.indexOf(item) < 5) {

            //Click on link for specific country name
            clickAllHyperLinksByCountryName(item);

            // Load values page and check is loaded
            ValuesPage valuesPage = new ValuesPage(driver);
            Assert.assertTrue(valuesPage.isValuesPageLoaded());
            // Read and set values  to object Country
            countryList.add(valuesPage.getValues(item));
            driver.navigate().back();
        }
        ;

        // Just for debug go to only 5 countries
        // }

        // Go Home from HIC page
        Header header = hicPage.goHome();
        header.isHeaderLoaded();

        // Print Top 3 countries by GDP
        Collections.sort(countryList, new Comparator<Country>() {

            public int compare(Country o1, Country o2) {
                return Float.valueOf(o2.getGdp()).compareTo(o1.getGdp());
            }
        });
        System.out.println();
        System.out.println("---------------------- ");
        System.out.println("Top 3 countries by GDP: ");
        System.out.println("---------------------- ");
        int k = 0;
        while (k <= 2) {
            System.out.println(countryList.get(k).getCountryName() + ": " + countryList.get(k).getGdp());
            k++;
        }

        // Print Top 3 countries by Population
        Collections.sort(countryList, new Comparator<Country>() {

            public int compare(Country o1, Country o2) {
                return String.valueOf(o2.getPopulation()).compareTo(o1.getPopulation());
            }
        });
        System.out.println();
        System.out.println("Top 3 countries by Population: ");
        System.out.println("------------------------------ ");
        int l = 0;
        while (l <= 2) {
            System.out.println(countryList.get(l).getCountryName() + ": " + countryList.get(l).getPopulation());
            l++;
        }

        // Print Top 3 countries by CO2
        Collections.sort(countryList, new Comparator<Country>() {

            public int compare(Country o1, Country o2) {
                return Float.valueOf(o2.getCo2()).compareTo(o1.getCo2());
            }
        });
        System.out.println();
        System.out.println("Top 3 countries by CO2: ");
        System.out.println("----------------------- ");
        int m = 0;
        while (m <= 2) {
            System.out.println(countryList.get(m).getCountryName() + ": " + countryList.get(m).getCo2());
            m++;
        }
        System.out.println("======================= ");
        System.out.println("----------------------- ");
        System.out.println("----------------------- ");

        // Create CSV file to working dir

        String userDir = System.getProperty("user.dir");
        String csvFile = userDir + "/WBD.csv";
        FileWriter writer = new FileWriter(csvFile);

        // Header
        CSVUtil.writeLine(writer, Arrays.asList("Country", "GDP", "Population", "CO2"));

        // Data
        for (Country d : countryList) {

            List<String> list = new ArrayList<String>();
            list.add(d.getCountryName());
            list.add(String.valueOf(d.getGdp()));
            list.add(d.getPopulation());
            list.add(String.valueOf(d.getCo2()));

            CSVUtil.writeLine(writer, list, ',');

        }

        writer.flush();
        writer.close();

    }

    /*********** hellper methods *************/

    public static void clickAllHyperLinksByCountryName(String countryName) throws InterruptedException {
        getElementWithIndex(countryName).click();
    }

    public static WebElement getElementWithIndex(String countryName) {
        return driver.findElement(By.linkText(countryName));
    }

    private WebDriver invokeBrowser(String url) {
    // private void invokeBrowser(String url) {
       WebDriver driver = DriverManager.getDriver();

        log.info("Thread id = " + Thread.currentThread().getId());
        log.info("Hash code of webDriver instance = " + driver.hashCode());
        log.info("Test executed using = " + DriverManager.getBrowserInfo());
        driver.get(url);
        // driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
       return driver;
    }
}