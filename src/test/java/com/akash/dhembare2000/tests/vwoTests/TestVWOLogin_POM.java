package com.akash.dhembare2000.tests.vwoTests;

import com.akash.dhembare2000.base.CommonToAllTests;
import com.akash.dhembare2000.driver.DriverManager;
import com.akash.dhembare2000.pages.pageObjectModel.LoginPage_POM;
import com.akash.dhembare2000.utils.PropertyReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

public class TestVWOLogin_POM extends CommonToAllTests {

    private static final Logger logger = LogManager.getLogger(TestVWOLogin_POM.class);
    @Test
    public void testLoginNegativeVWO(){
        logger.info("Staring the testcase");
        WebDriver driver = DriverManager.getDriver();
        LoginPage_POM loginPagePom= new LoginPage_POM(driver);

        logger.info("Opening the URL");
        String error_msg_text= loginPagePom.loginToVWOInvalidCreds(PropertyReader.readKey("invalid_username"),PropertyReader.readKey("invalid_password"));

        logger.info("Verifying the username in the Dashboard");
        assertThat(error_msg_text).isNotNull().isNotEmpty().isNotBlank();
        Assert.assertEquals(error_msg_text, PropertyReader.readKey("error_message"));
    }

}
