package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPage {
    private WebDriver driver;
    WebDriverWait wait;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
        wait=new WebDriverWait(driver,10,200);

    }
    private WebElement getName(){
        By locator1=By.xpath("//*[@id='name']");
        wait.until(ExpectedConditions.elementToBeClickable(locator1));
        return driver.findElement(locator1);

    }
    private WebElement getCountry(){
        return driver.findElement(By.xpath("//*[@id='country']"));

    }
    private WebElement getCity(){
        return driver.findElement(By.xpath("//*[@id='city']"));
    }
    private WebElement getCard(){
        return driver.findElement(By.xpath("//*[@id='card']"));
    }
    private WebElement getMonth(){
        return driver.findElement(By.xpath("//*[@id='month']"));
    }
    private WebElement getYear(){
        return driver.findElement(By.xpath("//*[@id='year']"));
    }
    private WebElement getBlueButton(){
        return driver.findElement(By.xpath("//*[@onclick='purchaseOrder()']"));
    }
    public void purchase(String name,String Country,String City,String Card,String Month,String Year){
        getName().sendKeys(name);
        getCountry().sendKeys(Country);
        getCity().sendKeys(City);
        getCard().sendKeys(Card);
        getMonth().sendKeys(Month);
        getYear().sendKeys(Year);
        getBlueButton().click();
//        return new HomePage(driver);


    }


}
