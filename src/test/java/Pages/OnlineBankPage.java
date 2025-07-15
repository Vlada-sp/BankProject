package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OnlineBankPage {

    WebDriver driver;


    public OnlineBankPage(WebDriver driver) {

        this.driver = driver;
    }

    public void transferFundsLink(){
        driver.findElement(By.id("transfer_funds_link")).click();
    }

    public WebElement TransferFunds (){

        return     driver.findElement(By.id("tf_toAccountId"));
    }

    public WebElement InputAmount(){

        return driver.findElement(By.id("tf_amount"));
    }
    public WebElement description(){
        return driver.findElement(By.id("tf_description"));
    }

    public WebElement submitButton (){
        return  driver.findElement(By.id("btn_submit"));

    }

    public WebElement boardContent (){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      return   wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("board-content")));
    }
public WebElement alertSuccess (){
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    return   wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert.alert-success")));
}
}
