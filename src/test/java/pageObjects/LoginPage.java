package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait=new WebDriverWait(driver,10,200);
    }
    private WebElement getFieldLogin(){
        return driver.findElement(By.xpath("//*[@id='loginusername']"));
    }
    private WebElement getFieldPasswoord(){
        return driver.findElement(By.xpath("(//*[@type='password'])[2]"));
    }
    private WebElement getBlueButtonLogin(){
        return driver.findElement(By.xpath("//*[@onclick='logIn()']"));
    }
    public HomePage login(String username, String password) throws InterruptedException {
        Thread.sleep(5000);
        getFieldLogin().sendKeys(username);
        getFieldPasswoord().sendKeys(password);
        getBlueButtonLogin().click();
        return new HomePage(driver);


    }
}
