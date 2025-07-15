package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage  {


    WebDriver driver;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

public WebElement userLogin (){
    return    driver.findElement(By.id("user_login"));
}

    public WebElement userPassword (){
        return    driver.findElement(By.id("user_password"));
    }
public WebElement submitButton(){
        return  driver.findElement(By.cssSelector(".btn.btn-primary"));
}

    }

