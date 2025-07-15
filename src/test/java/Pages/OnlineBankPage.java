package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
        return driver.findElement(By.className("board-content"));
    }

}
