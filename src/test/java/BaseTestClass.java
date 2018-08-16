import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by root on 8/16/2018.
 */
public class BaseTestClass {

    WebDriver driver;
    public BaseTestClass() {
        ;
    }

    @BeforeMethod
    public void before(){
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
        driver = WebDriverSingleton.getInstance();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        driver.get("http://inlinelviv.com/");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void after(){
        //driver.close();
        //driver.quit();

    }

    @AfterClass
    public void after_class(){
        driver.close();
        driver.quit();

    }

            /*protected setUpBeforeTestClass() {
            // ініціалізувати драйвер браузера, підключитися до серверів
            }

             protected  setUpBeforeTestMethod ()  {
            ініціалізувати testPage
            // входити в додаток, якщо необхідно
            }

            protected  tearDownAfterTestMethod ()  {
            // вийти з програми, при необхідності
            }

           protected   tearDownAfterTestClass ()  {
            // закрити з'єднання, закрити браузер у міру необхідності
            }

    */




}
