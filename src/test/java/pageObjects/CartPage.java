package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
    private WebDriver driver;
    WebDriverWait wait;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        wait=new WebDriverWait(driver,10,200);
    }
    private WebElement getPlaceOrder(){

        By locator1=By.xpath("//*[@class='btn btn-success']");
        wait.until(ExpectedConditions.elementToBeClickable(locator1));
        return driver.findElement(locator1);
    }
    public OrderPage PlaceAnOrder(){
        getPlaceOrder().click();
        return new OrderPage(driver);

    }

}
