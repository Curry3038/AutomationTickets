package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage {
    private  WebDriver driver;

    WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait=new WebDriverWait(driver,10,200);
    }
    private WebElement getButtonSignUp(){
        return driver.findElement(By.xpath("//*[@id='signin2']"));
    }
    public SignUpPage clickButtonSignUp(){
        getButtonSignUp().click();
        return new SignUpPage(driver);
    }
    public void isOpen(String url){
        driver.get(url);
    }
    private WebElement getButtonLogin(){
       return driver.findElement(By.xpath("//*[@id='login2']"));

    }
    public LoginPage clickBottonLogin(){
        getButtonLogin().click();
        return new LoginPage(driver);
    }
    private WebElement getButtonPhone(){
        By locator=By.xpath("/(//*[@id='itemc'])[1]");
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        return driver.findElement(locator);
    }

    public boolean isOpen(){
        By homelocator=By.xpath("//*[@id='nameofuser']");
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(homelocator));
            return true;
        }catch (TimeoutException ignored){
            return false;
        }
    }
    private WebElement getClickPhonesPage(){
        return driver.findElement(By.xpath("(//*[@id='itemc'])[1]"));
    }
    public PhonesPage  ClickButtonPhones(){
        getClickPhonesPage().click();
        return new PhonesPage(driver);
    }
    private WebElement getButtonLaptops(){
        By locator=By.xpath("(//*[@class='list-group-item'])[3]");
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        return driver.findElement(locator);
    }
    public LaptopsPage  clickLaptopsButton(){
        getButtonLaptops().click();
        return new LaptopsPage(driver);
    }
//    private WebElement getEqualsPrice() {
//        return driver.findElement(By.xpath("(//div[@class='card h-100'])[1]//h5"));
//    }
//    private WebElement getPriceInCardProduct(){
//        return driver.findElement(By.xpath("class='price-container'"));
//    }
//
//    public void equalsPrice(){
//        String innerText=getEqualsPrice().getText();
//        getClickPhonesPage().click();
//        String innerText1=getPriceInCardProduct().getText();
//        Assert.assertEquals(innerText,innerText1);
    private WebElement getButtonCart(){
        By locator3=By.xpath("//*[@id='cartur']");
        wait.until(ExpectedConditions.elementToBeClickable(locator3));
        return driver.findElement(locator3);
    }
    public CartPage ClickCart(){
        getButtonCart().click();
       return new CartPage(driver);
    }


    }













