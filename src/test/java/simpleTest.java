import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class simpleTest {
    private WebDriver driver;
    WebDriverWait wait;
    @BeforeMethod
    public void startUp(){
        System.setProperty("web.chrome.driver","chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.demoblaze.com/");
        wait=new WebDriverWait(driver,10,200);
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }







    }

