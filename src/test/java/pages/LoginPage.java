package pages;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import steps.Methods;

public class LoginPage extends Methods {

    private static Logger logger = Logger.getLogger(LoginPage.class);


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private final By txtEmail = By.id("j_username1");
    private final By btnEmail = By.xpath("//span[text()='Devam Et']");

    private final By txtPassword = By.id("j_password");

    private final By btnPassword = By.id("customerLoginButton");

    private final By txtFalseMail= By.xpath("//p[text()='Mail adresi ile kayıtlı bir hesap bulunamamıştır.']");
    private WebElement falseMail;

    private final By txtFalsePassword = By.xpath("//p[text()='Hatalı şifre girdiniz. Lütfen tekrar deneyin ya da ']");
    private WebElement falsePassword;

    public void fillFields(String mail, String password){
        waitForElement(txtEmail,10);
        setImplicitWaitTime(3);
        type(txtEmail,mail);
        setImplicitWaitTime(3);
        click(btnEmail);
        setImplicitWaitTime(50);
        type(txtPassword,password);
        setImplicitWaitTime(3);
        click(btnPassword);
    }
    public void falseMailControl(String mail){
        waitForElement(txtEmail,10);
        setImplicitWaitTime(3);
        type(txtEmail,mail);
        setImplicitWaitTime(3);
        click(btnEmail);
        falseMail = driver.findElement(txtFalseMail);
        Assertions.assertTrue(falseMail.isEnabled(),"Mail Yanlış!");
        logger.info("Yanlış mail testi başarıyla geçmiştir!");
    }
    public void falsePasswordControl(String mail,String password){
        waitForElement(txtEmail,10);
        setImplicitWaitTime(3);
        type(txtEmail,mail);
        setImplicitWaitTime(3);
        click(btnEmail);
        setImplicitWaitTime(3);
        type(txtPassword,password);
        setImplicitWaitTime(3);
        click(btnPassword);
        falsePassword=driver.findElement(txtFalsePassword);
        Assertions.assertTrue(falsePassword.isEnabled(),"Yanlış Parola uyarısı görülür!");
        logger.info("Yanlış parola senaryosu başarıyla çalışmıştır");

    }



}
