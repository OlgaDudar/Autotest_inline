import jdk.internal.org.objectweb.asm.Handle;
import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.TimeUnit;


/**
 * Created by root on 8/13/2018.
 */
public class test_1 {
    private static volatile test_1 instance;

    private test_1(){
    }

    public static test_1 getInstance() {
        synchronized (test_1.class) {
            if (instance == null) {
                instance = new test_1();
            }
        }
        return instance;
    }
    WebDriver driver;

    public void checkMenuItem(String[] menuItem, String ExpText){
        for (int i=0; i<menuItem.length; i++) {
            WebElement menu_el = driver.findElement(By.partialLinkText(menuItem[i]));
            menu_el.click();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(),\""+ExpText+"\")]")).isEnabled(), ExpText+" Text not found!");

    }



    @BeforeMethod
    public void before(){
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://inlinelviv.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void test_1() {
        String[] str = new String[1];
        str = new String[]{"Галерея"};
        checkMenuItem(str, "");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.switchTo().frame("comp-jd0hhh6eiframe");
        Boolean img = this.driver.findElement(By.xpath("//*[@class=\"imgContainer ng-scope\"]")).isDisplayed();
        System.out.println(img);
        System.out.println(this.driver.getCurrentUrl().equals("https://www.inlinelviv.com/media"));
        Assert.assertTrue((this.driver.getCurrentUrl().equals("https://www.inlinelviv.com/media"))&&img, " Page not loaded");

    }

    @Test
    public void test_2() {
        String[] str = new String[2];
        str = new String[]{"Де ...", "... покататись?"};
        checkMenuItem(str, "Місця для катання на роликах");
    }

    @Test
    public void test_3() {
        String[] str = new String[2];
        str = new String[]{"Де ...", "... купити?"};
        checkMenuItem(str, "Купівля роликів");
    }

    @Test
    public void test_4() {
        String[] str = new String[2];
        str = new String[]{"Про Ролики", "Стилі катання"};
        checkMenuItem(str, "Стилі катання на роликах");
    }


    @Test
    public void test_5() {
        String[] str = new String[0];
        str = new String[]{};
        WebElement menu_el = driver.findElement(By.partialLinkText("Новини"));
        menu_el.click();
        driver.switchTo().frame("TPASection_jdbkbazeiframe");
        checkMenuItem(str, "Всі дописи");


    }

    @Test
    public void test_6(){
        Set<String> browserTabs = driver.getWindowHandles();
        String[] str = new String[1];
        str = new String[]{"Корисні посилання"};
        checkMenuItem(str, "прокат");

       // menu_el.click();
        System.out.println(driver.getCurrentUrl());
        WebElement link = driver.findElement(By.partialLinkText("http://rollersport.com.ua/"));
        link.click();

        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        String expectedText_1 = "Українська Федерація Роликового Спорту";
        Assert.assertTrue(driver.getPageSource().contains(expectedText_1), expectedText_1+" Text not found!");

    }



    @AfterMethod
    public void after(){
        driver.close();
        driver.quit();
    }
}
