/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.*;
import utils.DriverFactory;
import org.testng.Assert;

public class LoginTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = DriverFactory.createDriver();
        driver.get("https://www.google.com");
    }

    @Test
    public void testTitle() {
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Googlesss"));
       
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}