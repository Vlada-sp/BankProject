package TestClass;

import BaseClass.Base;
import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class SignIn extends Base {
WebDriver driver;
public  HomePage homePage;
public LoginPage loginPage;

    @BeforeMethod
    public void pageSetUp() throws IOException {
     //   ChromeOptions options = new ChromeOptions();
      //  options.addArguments("--incognito");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://zero.webappsecurity.com/index.html");
        new WebDriverWait(driver, Duration.ofSeconds(15));
        homePage= new HomePage(driver);
        loginPage = new LoginPage(driver);

        //inventoryPage2 = new InventoryPage2(driver);
    }

    @Test
    public  void successfulSignIn() throws InterruptedException {
        homePage.GetsigninButton().click();
        Assert.assertEquals(driver.getCurrentUrl(),"http://zero.webappsecurity.com/login.html");

        loginPage.userLogin().click();
        loginPage.userLogin().clear();
        loginPage.userLogin().sendKeys("username");

        loginPage.userPassword().click();
        loginPage.userPassword().clear();
        loginPage.userPassword().sendKeys("password");

        loginPage.submitButton().click();

        driver.get("http://zero.webappsecurity.com/index.html");
        driver.navigate().back();
        driver.navigate().refresh();

        homePage.ClickProfile();
        Assert.assertTrue(homePage.GetLogoutButton().isDisplayed(),"User is not logged in");
    }





//
//    @AfterMethod
//    public void tearDown() {
//        driver.quit();
//    }
}
