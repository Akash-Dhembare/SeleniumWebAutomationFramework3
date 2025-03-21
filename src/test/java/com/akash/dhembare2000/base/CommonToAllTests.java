package com.akash.dhembare2000.base;

import com.akash.dhembare2000.driver.DriverManager;
import com.akash.dhembare2000.pages.pageObjectModel.LoginPage_POM;
import com.akash.dhembare2000.utils.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class CommonToAllTests {
    @BeforeMethod
    public void setUp(){
        DriverManager.init();
    }


    @AfterMethod
    public void tearDown(){
        DriverManager.down();
    }
}
