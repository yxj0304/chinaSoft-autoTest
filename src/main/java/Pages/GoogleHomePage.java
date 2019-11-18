package Pages;

import Step.Hooks;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

@Component
public class GoogleHomePage {
    public WebDriver driver = Hooks.driver;
    public String INP_Path = "//input[@role='combobox']";
    public String TXT_FirstResult = "//div[@id='rso']//div[@class='srg']/div[1]";
    public String LNK_FirstResult = "//div[@id='rso']//div[@class='srg']/div[1]//a";


    public void waitForElementUntilTimeOut(String elementPath) {
        try {
            new WebDriverWait(driver, 300).until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementPath)));
        } catch (TimeoutException t) {
            System.out.println("Can't find element.");
        }
    }

    public void inputSearchContent(String text) {
        waitForElementUntilTimeOut(INP_Path);
        getSearchBox().sendKeys(text);
    }

    public WebElement getSearchBox() {
        return driver.findElement(By.xpath(INP_Path));
    }

    public WebElement getFirstResult() {
        return driver.findElement(By.xpath(TXT_FirstResult));
    }

    public WebElement getFirstResultLink() {
        return driver.findElement(By.xpath(LNK_FirstResult));
    }

    public void navigate() {
        this.driver.get("http://www.google.com");
    }

    public void pressEnterToSearch() {
        getSearchBox().sendKeys(Keys.ENTER);
    }

    public String getFirstResultText() {
        waitForElementUntilTimeOut(TXT_FirstResult);
        return getFirstResult().getText();
    }

    public void clickFirstResult() {
        getFirstResultLink().click();

    }
}
