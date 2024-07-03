package pages;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import steps.Methods;

public class MainPage extends Methods {
    private static Logger logger = Logger.getLogger(MainPage.class.getName());

    private final By login = By.xpath("(//span[text()='Giriş Yap'])[1]");
    private final By btnLogin = By.cssSelector(".homeCallLogin");

    private final By account = By.xpath("(//span[text()='Hesabım'])[1]");
    private WebElement accountElement;
    private final By popup = By.id("button-1580496494");

    WebElement searchInput = driver.findElement(By.id("search-input"));

    SearchContext searchContext = driver.findElement(By.xpath("//efilli-layout-dynamic")).getShadowRoot();
    WebElement shadowElement = searchContext.findElement(By.cssSelector("div[data-name='Accept Button']"));




    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void clickLogin(){
        shadowElement.click();
        setImplicitWaitTime(3);
        waitForElement(login,10);
        click(login);
        waitForElement(btnLogin,10);
        click(btnLogin);
        logger.info("deneme");

    }

    public void searchProduct(){
        shadowElement.click();
        setImplicitWaitTime(3);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('.js_search_button').style.display='none';");
        searchInput.click();
        searchInput.sendKeys("Macbook");
        searchInput.sendKeys(Keys.ENTER);

    }

    public void succesfulLoginControl()  {
        setImplicitWaitTime(10);
        accountElement = driver.findElement(account);
        Assertions.assertTrue(accountElement.isDisplayed(),"Login olunamadı!");
        logger.info("Tekonosa Login test başarıyla gerçekleşmiştir!!");
    }
}
