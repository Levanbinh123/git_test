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
@Parameters("browser")
public void setup(@Optional("chrome") String browser) {
    driver = DriverFactory.createDriver(browser);
    driver.get("https://www.google.com"); // THÊM DÒNG NÀY
}
    @Test
    public void testTitle() {
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Google"));
       
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}