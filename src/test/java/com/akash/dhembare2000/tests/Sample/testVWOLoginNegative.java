package com.akash.dhembare2000.tests.Sample;

import com.akash.dhembare2000.base.CommonToAllTests;
import com.akash.dhembare2000.driver.DriverManager;
import com.akash.dhembare2000.utils.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testVWOLoginNegative extends CommonToAllTests {

    @BeforeTest
    public void setUp(){
        DriverManager.init();
    }
    @Test
    public void testVWOLoginInvalidCred(){
        WebDriver driver = DriverManager.getDriver();
        driver.get("https://app.vwo.com/#/login");

        WebElement username=driver.findElement(By.xpath("//input[@id='login-username']"));
        username.sendKeys("admin");

        WebElement password=driver.findElement(By.xpath("//input[@id='login-password']"));
        password.sendKeys("admin123");

        WebElement signInBtn= driver.findElement(By.xpath("//button[@id='js-login-btn']"));
        signInBtn.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement error_msg=driver.findElement(By.xpath("//div[@id='js-notification-box-msg' ]"));
        String errorMessage=error_msg.getText();

        Assert.assertEquals(errorMessage, PropertyReader.readKey("error_message"));

    }

    @AfterTest
    public void tearDown(){
        DriverManager.down();
    }
}
