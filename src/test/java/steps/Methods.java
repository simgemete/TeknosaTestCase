package steps;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Methods {

    public WebDriver driver;

    public Methods(WebDriver driver){
        this.driver=driver;
    }

    public WebElement find(By locator){
        return driver.findElement(locator);
    }

    public void click(By locator){
        find(locator).click();
    }

    public void type(By locator, String text){
        find(locator).sendKeys(text);
    }

    public void waitForElement(By locator, int seconds){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void setImplicitWaitTime(int times){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(times));
    }

    public void scrollToElement(By locator){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)",find(locator));
    }

    public void clickElement(By locator){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('.js_search_button').style.display='none';");
    }


    public static void pressEnterKey(WebDriver driver, WebElement element) {
        element.sendKeys(Keys.ENTER);
    }


}
