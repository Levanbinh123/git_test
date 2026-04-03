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
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.Assert;
import utils.DriverFactory;
import utils.ConfigUtil;

public class LoginTest {

    WebDriver driver;

@BeforeMethod
@Parameters("browser")
public void setup(@Optional("chrome") String browser) {
    driver = DriverFactory.createDriver(browser);
    driver.get(ConfigUtil.getBaseUrl()); // THÊM DÒNG NÀY
}
 
    
      @Test
    public void testLoginSuccess() {

        // Lấy từ GitHub Secrets (CI) hoặc fallback local
        String username = ConfigUtil.getUsername();
        String password = ConfigUtil.getPassword();

        // Nhập username
        driver.findElement(By.id("user-name")).sendKeys(username);

        // Nhập password
        driver.findElement(By.id("password")).sendKeys(password);

        // Click login
        driver.findElement(By.id("login-button")).click();

        // Kiểm tra login thành công
        String currentUrl = driver.getCurrentUrl();

        Assert.assertTrue(currentUrl.contains("inventory"),
                "Login failed!");
    }


      @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}