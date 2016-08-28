package com.askeledz.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * @author askeledzija
 */
public class ValuesPage extends Country {

    WebDriver driver;

    public ValuesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(how = How.XPATH, using = "//*[@id=\"nav-header-top-left-area\"]/h1")
    WebElement country_title;

    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[4]/div/div/div[2]/div[2]/div[2]/div/div/div[1]/div/div[2]/span/span/a/span")
    WebElement gdp;

    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[4]/div/div/div[2]/div[2]/div[2]/div/div/div[2]/div/div/div/div[2]/span/span/a/span")
    WebElement pop;

    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[5]/div/div[6]/table/tbody/tr/td[2]/div[2]/div/div/div/div[2]/div/div/div/span[1]")
    WebElement co2;

    public Country getValues(String countryName) {

        Country country = new Country();
        country.setCountryName(countryName);
        System.out.println("------------------------------------------------------");
        System.out.println("Country: " + country.getCountryName());
        System.out.println("------------------------------------------------------");

        try {
            Thread.sleep(200);
            String strGDP = gdp.getText();
            String srtGDPNew = strGDP.trim().substring(1, 6);
            float number = Float.parseFloat(srtGDPNew);
            country.setGdp(number);
            System.out.println("GDP: " + strGDP);

        } catch (Exception e) {
            System.out.println("GDP: Failed to fetch info!");
            country.setGdp(0.0f);
        }

        try {
            Thread.sleep(200);
            String strPOP = pop.getText();
            country.setPopulation(strPOP);
            System.out.println("Population: " + strPOP);
        } catch (Exception e) {
            System.out.println("Population: Failed to fetch info!");
            country.setPopulation("0.0");
        }

        try {
            Thread.sleep(200);
            String strCO2 = co2.getText();
            float number = Float.parseFloat(strCO2);
            country.setCo2(number);
            System.out.println("CO2: " + strCO2);
        } catch (Exception e) {
            System.out.println("CO2: Failed to fetch info!");
            country.setCo2(0.0f);
        }
        System.out.println("------------------------------------------------------");
        return country;

    }

    // We will use this boolean for assertion. To check if page is opened
    public boolean isValuesPageLoaded() {
        return country_title.isDisplayed();
    }

}