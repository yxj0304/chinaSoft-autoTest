package Pages;

import Step.Hooks;
import org.openqa.selenium.*;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;


@Component
public class SfxCalculatorPage {

    public WebDriver webDriver = Hooks.driver;

    public String INP_Path = "//*[@id='initialDeposit']";
    public String TXT_InitialMessagePath = "//*[@id='initialDeposit']/following-sibling::div";


    public void sepecialClear(WebElement element) {
        for (int i = 0; i < element.getAttribute("value").length() * 5; i++) {
            element.sendKeys(Keys.BACK_SPACE);
        }
    }


    public void navigateToCalculatorPage() {
        Hooks.driver.get("https://aempub:Pr0tectaempub@sit.hsbc.com.hk/content/hsbc/dpws-demo/en_gb/tools/calculators/SFX-calculator/");
    }


    public void waitForElementUntilTimeOut(String elementPath) {
        try {
            new WebDriverWait(webDriver, 300).until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementPath)));
        } catch (TimeoutException t) {
            System.out.println("Can't find element.");
        }
    }

    public void inputAmount(String amount) {
        waitForElementUntilTimeOut(INP_Path);
        WebElement INP_InitialAmount = webDriver.findElement(By.xpath(INP_Path));
        sepecialClear(INP_InitialAmount);
        INP_InitialAmount.sendKeys(amount);
    }

    public String getInitialTipMessage() {
        WebElement TXT_InitialMessage = webDriver.findElement(By.xpath(TXT_InitialMessagePath));
        if (TXT_InitialMessage.getAttribute("outerHTML").contains("alert")) {
            return TXT_InitialMessage.getText();
        } else {
            return "none";
        }
    }

    public String getInitialTipAmountValue() {
        WebElement INP_InitialAmount = webDriver.findElement(By.xpath(INP_Path));
        return INP_InitialAmount.getAttribute("value");
    }
}
