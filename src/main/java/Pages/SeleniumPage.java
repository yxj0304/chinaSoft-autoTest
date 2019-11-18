package Pages;

import Step.Hooks;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

@Component
public class SeleniumPage {
    WebDriver driver = Hooks.driver;
    public String SEC_Titile = "//section[@class='hero homepage']";
    public String TXT_Titile = "//section[@class='hero homepage']/h1[1]";


    public void waitForElementNotShowUntilTimeOut(String elementPath) {
        try {
            new WebDriverWait(driver, 120).until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementPath)));
        } catch (TimeoutException t) {
            System.out.println("Can't find element.");
        }
    }

    public String getPageLink() {
        waitForElementNotShowUntilTimeOut(SEC_Titile);
        return driver.findElement(By.xpath(TXT_Titile)).getText();
    }
}
