import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by root on 8/16/2018.
 */
public class BaseTestClass {

//    public WebDriver driver;
    public BaseTestClass() {
        ;
    }
    public void checkMenuItem(String[] menuItem, String ExpText){
        for (int i=0; i<menuItem.length; i++) {
            WebElement menu_el = WebDriverSingleton.getInstance().findElement(By.xpath("//p[contains(text(),\""+menuItem[i]+"\")]"));
            menu_el.click();
        }
        Assert.assertTrue(WebDriverSingleton.getInstance().findElement(By.xpath("//*[contains(text(),\""+ExpText+"\")]")).isEnabled(), ExpText+" Text not found!");

    }
    @BeforeMethod(groups = "funct")
    public void before(){

        WebDriverSingleton.getInstance().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(WebDriverSingleton.getInstance(), 20);
        WebDriverSingleton.getInstance().manage().window().maximize();
    }
    @BeforeClass(groups = "funct")
    public void init() throws IOException {
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");

    }

    @AfterMethod
    public void after(){
        //WebDriverSingleton.getInstance().close();
        //WebDriverSingleton.getInstance().quit();

    }

    @AfterSuite(groups = {"funct"})
    public void after_suit(){
        WebDriverSingleton.getInstance().close();
        WebDriverSingleton.getInstance().quit();
    }


}
