package TestClass;


import BaseClass.Base;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.OnlineBankPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class Transferfunds extends Base {
    WebDriver driver;
    public  HomePage homePage;
    public OnlineBankPage onlineBankPage;
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
        onlineBankPage =new OnlineBankPage(driver);
        loginPage = new LoginPage(driver);


    }


    @Test
    public void successfulTransferFundsFromSavingsToChecking () throws InterruptedException {
        homePage.GetsigninButton().click();
        Assert.assertEquals(driver.getCurrentUrl(),"http://zero.webappsecurity.com/login.html");

        loginPage.userLogin().click();
        loginPage.userLogin().clear();
        loginPage.userLogin().sendKeys("username");

        loginPage.userPassword().click();
        loginPage.userPassword().clear();
        loginPage.userPassword().sendKeys("password");

        loginPage.submitButton().click();
Thread.sleep(2000);
        driver.get("http://zero.webappsecurity.com/index.html");
       // driver.navigate().back();
        driver.navigate().refresh();

        homePage.ClickProfile();
        Assert.assertTrue(homePage.GetLogoutButton().isDisplayed(),"User is not logged in");


        homePage.GoToOnlineBankingMenu();
        Assert.assertEquals(driver.getCurrentUrl(),"http://zero.webappsecurity.com/online-banking.html");
        onlineBankPage.transferFundsLink();


        Select dropdown = new Select(onlineBankPage.TransferFunds());
        dropdown.selectByValue("2");
        onlineBankPage.InputAmount().sendKeys("500");
        onlineBankPage.description().sendKeys("Savings");
        onlineBankPage.submitButton().click();
String text = onlineBankPage.boardContent().getText();
        Assert.assertTrue(text.contains("Please verify that the following transaction is correct\"),\n" +
                "        \"Tekst potvrde transakcije nije pronađen u board-content."));






    }
}
