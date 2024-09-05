package pageObjectsTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class UiTest {
    private WebDriver driver;
    private String url;
    WebDriverWait wait;
    @BeforeMethod
    public void startUp(){
        System.setProperty("web.chrome.driver","chromedriver");
        driver=new ChromeDriver();
        url="https://www.demoblaze.com/index.html";
        wait=new WebDriverWait(driver,10,200);

    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
    @Test
    public void uiTest() throws InterruptedException {
//        Зарегистрироваться под любыми данными
        HomePage homePage=new HomePage(driver);
        homePage.isOpen(url);
        SignUpPage signUpPage=homePage.clickButtonSignUp();
        signUpPage.createUsers("Users121212","Users121212");
//        2.Залогиниться с этими данными
        LoginPage loginPage=homePage.clickBottonLogin();
      HomePage homePage1=loginPage.login("Users121212","Users121212");
        Assert.assertTrue(homePage1.isOpen());
//        3.Добавить в корзину по одному любому гаджету из каждой категории
        PhonesPage phonesPage=homePage1.ClickButtonPhones();
        phonesPage.addPhone();
        LaptopsPage laptopsPage=homePage1.clickLaptopsButton();
        laptopsPage.ByeLaptop();
//5.Перейти в корзину и убедиться, что общая цена посчитана верно
        CartPage cartPage=homePage.ClickCart();
//        6.Оформить заказ
        OrderPage orderPage=cartPage.PlaceAnOrder();
      orderPage.purchase("a","a","a","a","a","a");




//        homePage1.equalsPrice();









    }
}
