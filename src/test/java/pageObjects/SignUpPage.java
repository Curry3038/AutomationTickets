package pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage {
    private WebDriver driver;
    WebDriverWait wait;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        this.wait = wait;
    }
    private WebElement getFieldLoginInSign(){
       return driver.findElement(By.xpath("//*[@id='sign-username']"));
    }
    private WebElement getFieldPasswordInSign(){
        return driver.findElement(By.xpath("//*[@id='sign-password']"));
    }
    private WebElement getBlueButtonSign(){
        return driver.findElement(By.xpath("//*[@onclick='register()']"));
    }
    private WebElement getCloseSign(){
        return driver.findElement(By.xpath("(//*[@aria-hidden='true'])[3]"));
    }
    public void createUsers(String username,String password) throws InterruptedException {
        getFieldLoginInSign().sendKeys(username);
        getFieldPasswordInSign().sendKeys(password);
        getBlueButtonSign().click();
        Thread.sleep(4000);
        Alert alert = driver.switchTo().alert();
        alert.accept();
        getCloseSign().click();

    }
}
