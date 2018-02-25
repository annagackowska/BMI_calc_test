package com.agackowska.tests;

import com.agackowska.pages.HomePage;
import com.agackowska.utils.drivers.WebDriverCreators;
import com.agackowska.utils.drivers.WebDriverProvider;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class BmiCalculatorTest {

    @RunWith(DataProviderRunner.class)
    public static class RegistrationDDTWithTngTech {

        private static final String URL = "http://bmi-online.pl/";

        private WebDriver driver;

        private HomePage homePage;


        @DataProvider
        public static Object[][] testDataForBmi() {
            return new String[][]{
                    new String[]{"K", "40", "160", "15.63"}, //wygłodzenie
                    new String[]{"K", "45", "160", "17.58"}, //niedowaga
                    new String[]{"K", "42", "160", "16.41"},//wychudzenie
                    new String[]{"K", "50", "160", "19.53"}, //prawidłowa
                    new String[]{"K", "70", "160", "27.34"}, //nadwaga
                    new String[]{"K", "80", "160", "31.25"},//I stopień
                    new String[]{"K", "90", "160", "35.16"}, //II stopień
                    new String[]{"K", "120", "160", "46.88"}, //skrajna

                    new String[]{"M", "40", "160", "15.63"}, //wygłodzenie
                    new String[]{"M", "45", "160", "17.58"}, //niedowaga
                    new String[]{"M", "42", "160", "16.41"},//wychudzenie
                    new String[]{"M", "50", "160", "19.53"}, //prawidłowa
                    new String[]{"M", "70", "160", "27.34"}, //nadwaga
                    new String[]{"M", "80", "160", "31.25"},//I stopień
                    new String[]{"M", "90", "160", "35.16"}, //II stopień
                    new String[]{"M", "120", "160", "46.88"}, //skrajna


            };
        }

        @Before
        public void setUp() {
            driver = new WebDriverProvider(WebDriverCreators.CHROME).getDriver();
            driver.manage().window().maximize();

            homePage = PageFactory.initElements(driver, HomePage.class);

            driver.get(URL);
        }

        @Test
        @UseDataProvider("testDataForBmi")
        public void calculateBmiTest(String gender, String weight, String height, String result) {

            homePage.inputInformationForm(gender, weight, height);

            homePage.clickOnSubmitButton();

            Assertions.assertThat(homePage.getResultMessage()).contains(result);
        }

        @After
        public void tearDown() {
            driver.close();
        }


    }
}
