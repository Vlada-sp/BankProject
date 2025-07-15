package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {


    WebDriver driver;


    public HomePage(WebDriver driver) {
        this.driver = driver;
}

public WebElement GetsigninButton(){
      return   driver.findElement(By.id("signin_button"));
}

public void  ClickProfile (){
    List<WebElement> dropdown = driver.findElements(By.className("dropdown-toggle"));
    dropdown.get(1).click();

}

public WebElement GetLogoutButton (){
        return  driver.findElement(By.id("logout_link"));
}

public void GoToOnlineBankingMenu (){
        driver.findElement(By.id("onlineBankingMenu")).click();
}

}
