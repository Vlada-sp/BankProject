package BaseClass;



import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class Base {

    public WebDriver driver;


    @BeforeClass
    public  void setUp(){
        WebDriverManager.chromedriver().setup();

    }
}
