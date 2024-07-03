package tests;

import data.ExcelReader;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Test;
import pages.BasePage;
import pages.LoginPage;
import pages.MainPage;
import pages.ProductPage;

public class Tests extends BasePage {

    ExcelReader excelReader = new ExcelReader("C:\\Users\\simge\\IdeaProjects\\Deneme\\src\\test\\resources\\data\\LoginData.xlsx");


    @Test
    @Description("Login senaryosu")
    @Severity(SeverityLevel.CRITICAL)
    void TeknosaLoginTest()  {
        Allure.step("Kullanici uygulamaya basariyla login olacak");
        LoginPage loginPage= new LoginPage(driver);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLogin();
        loginPage.fillFields(excelReader.readExcelFile("1.0").get("mail"),excelReader.readExcelFile("1.0").get("password"));
        mainPage.succesfulLoginControl();

    }

    @Test
    @Description("Yanlis mail senaryosu")
    @Severity(SeverityLevel.CRITICAL)
    void TeknosaLoginFalseMail()  {
        Allure.step("Yanlis mail girince uygulama acilmayacak");
        LoginPage loginPage= new LoginPage(driver);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLogin();
        loginPage.falseMailControl(excelReader.readExcelFile("2.0").get("mail"));
    }

    @Test
    @Description("Yanlis sifre senaryosu")
    @Severity(SeverityLevel.CRITICAL)
    void TeknosaFalsePassword() {
        Allure.step("Yanlis sifre girince uygulama acilmayacak");
        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLogin();
        loginPage.falsePasswordControl(excelReader.readExcelFile("3.0").get("mail"),excelReader.readExcelFile("3.0").get("password"));
    }
    @Test
    @Description("Sepete ekleme senaryosu")
    @Severity(SeverityLevel.MINOR)
    void TeknosaAddToBasket() {
        Allure.step("Urun sepete eklenecek");
        MainPage mainPage = new MainPage(driver);
        ProductPage productPage = new ProductPage(driver);
        mainPage.searchProduct();
        productPage.addProduct();
        productPage.succesfulBasketPage();
    }
}
