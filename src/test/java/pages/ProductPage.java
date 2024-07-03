package pages;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import steps.Methods;

import java.util.List;

public class ProductPage extends Methods {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    private static Logger logger = Logger.getLogger(MainPage.class.getName());

    List<WebElement> elements = driver.findElements(By.className("prd-inner"));

    private final By product = By.xpath("//a[@href='/apple-macbook-air-m2-8c-cpu-8c-gpu-256gb-ssd-136-uzay-grisi-dizustu-bilgisayar-mlxw3tua-p-125035423']");

    private final By addBasket = By.xpath("//button[@class='js-add-to-cart js-enable-btn btn btn-primary js-shop_offer_592713']");

    private final By basket = By.xpath("//div[@class='pac-buttons']/a[contains(.,'Sepetime Git')]");

    private final By productAdd = By.id("quantity_0");

    private WebElement productAddElement;



    public void addProduct(){
        setImplicitWaitTime(4);
        click(product);
        setImplicitWaitTime(5);
        click(addBasket);
        setImplicitWaitTime(7);
        click(basket);
        setImplicitWaitTime(7);

    }
    public void succesfulBasketPage()  {
        setImplicitWaitTime(10);
        productAddElement = driver.findElement(productAdd);
        Assertions.assertTrue(productAddElement.isDisplayed(),"Urun sepete eklenemedi!");
        logger.info("Tekonosa sepete urun ekleme testi başarıyla gerçekleşmiştir!!");


    }

}
