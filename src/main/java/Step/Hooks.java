package Step;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {

    public static WebDriver driver = null;


    @Before
    public WebDriver start(){
       driver = new ChromeDriver();
       return driver;
    }

    @After
    public void tearDown(){
        driver.close();
    }
}
