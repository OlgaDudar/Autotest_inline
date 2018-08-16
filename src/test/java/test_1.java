import jdk.internal.org.objectweb.asm.Handle;
import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
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
public class test_1 extends BaseTestClass {
    private static volatile test_1 instance;


    private test_1() {
    }


    public void checkMenuItem(String[] menuItem, String ExpText){
        for (int i=0; i<menuItem.length; i++) {
            WebElement menu_el = driver.findElement(By.xpath("//p[contains(text(),\""+menuItem[i]+"\")]"));
            menu_el.click();
        }
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(),\""+ExpText+"\")]")).isEnabled(), ExpText+" Text not found!");

    }



    @Test
    public void test_1() {
        String[] str = new String[1];
        str = new String[]{"Галерея"};
        checkMenuItem(str, "");
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
        WebElement menu_el = driver.findElement(By.xpath("//p[contains(text(),\"Новини\")]"));
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
        System.out.println(driver.getCurrentUrl());
        WebElement link = driver.findElement(By.partialLinkText("http://rollersport.com.ua/"));
        link.click();
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        String expectedText_1 = "Українська Федерація Роликового Спорту";
        Assert.assertTrue(driver.getPageSource().contains(expectedText_1), expectedText_1+" Text not found!");

    }


}
