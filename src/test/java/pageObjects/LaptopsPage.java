package pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LaptopsPage {
    private WebDriver driver;
    WebDriverWait wait;

    public LaptopsPage(WebDriver driver) {
        this.driver = driver;
        wait=new WebDriverWait(driver,10,200);
    }
    private WebElement getClickSonyVaioI5(){
        return driver.findElement(By.xpath("(//*[@class='hrefch'])[1]"));
    }
    private WebElement getAddVaioI5(){
        By locator2=By.xpath("//*[@onclick='addToCart(8)']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator2));
        return driver.findElement(locator2);
    }
    private WebElement getHomeClick(){
        return driver.findElement(By.xpath("(//*[@href='index.html'])[2]"));
    }
    public HomePage ByeLaptop() throws InterruptedException {
        getClickSonyVaioI5().click();
        getAddVaioI5().click();
        Thread.sleep(5000);
        Alert alert = driver.switchTo().alert();
        alert.accept();
        getHomeClick().click();
        return new HomePage(driver);
    }


}
