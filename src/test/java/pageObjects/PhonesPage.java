package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PhonesPage {
    private WebDriver driver;
    WebDriverWait wait;

    public PhonesPage(WebDriver driver) {
        this.driver = driver;
        wait=new WebDriverWait(driver,10,200);
    }
    private WebElement getClickSamsungGalaxyS6(){
        return driver.findElement(By.xpath("(//*[@class='hrefch'])[1]"));
    }
    private WebElement getAddToCart(){
        By locator2=By.xpath("//*[@onclick='addToCart(1)']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator2));
        return driver.findElement(locator2);
    }
    private WebElement getHomeClick(){
        return driver.findElement(By.xpath("(//*[@href='index.html'])[2]"));
    }
    public HomePage addPhone() throws InterruptedException {
        getClickSamsungGalaxyS6().click();
        getAddToCart().click();
        Thread.sleep(5000);
        Alert alert = driver.switchTo().alert();
        alert.accept();
        getHomeClick().click();
        return new HomePage(driver);


    }
}
