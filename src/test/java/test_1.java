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

    @Test
    public void clearTest(){
        MainPage mainPage = new MainPage(WebDriverSingleton.getInstance());
        NewsPage newsPage;

        newsPage = mainPage.clickMenuNews();
        newsPage.selectLastNesw()
                .scrollToNewOne();
        Assert.assertTrue(newsPage.getLastNwsTitle().equals("Last News"), "Incorrect news titile");
    }


    @Test(description="Check menu item Галерея", groups={"funct"})
    public void test_1() {
        String[] str = new String[1];
        str = new String[]{"Галерея"};
        checkMenuItem(str, "");
        WebDriverSingleton.getInstance().switchTo().frame("comp-jd0hhh6eiframe");
        Boolean img = WebDriverSingleton.getInstance().findElement(By.xpath("//*[@class=\"imgContainer ng-scope\"]")).isDisplayed();
        System.out.println(img);
        System.out.println(WebDriverSingleton.getInstance().getCurrentUrl().equals("https://www.inlinelviv.com/media"));
        Assert.assertTrue((WebDriverSingleton.getInstance().getCurrentUrl().equals("https://www.inlinelviv.com/media"))&&img, " Page not loaded");

    }

    @Test(description="Check menu item Де покататись", groups={"funct"})
    public void test_2() {
        String[] str = new String[2];
        str = new String[]{"Де ...", "... покататись?"};
        checkMenuItem(str, "Місця для катання на роликах");
    }

    @Test(description="Check menu item Де купити", groups={"funct"})
    public void test_3() {
        String[] str = new String[2];
        str = new String[]{"Де ...", "... купити?"};
        checkMenuItem(str, "Купівля роликів");
    }

    @Test(description="Check menu item Стилі катання", groups={"funct"})
    public void test_4() {
        String[] str = new String[2];
        str = new String[]{"Про Ролики", "Стилі катання"};
        checkMenuItem(str, "Стилі катання на роликах");
    }


    @Test(description="Check menu item Новини", groups={"funct"})
    public void test_5() {
        String[] str = new String[0];
        str = new String[]{};
        WebElement menu_el = WebDriverSingleton.getInstance().findElement(By.xpath("//p[contains(text(),\"Новини\")]"));
        menu_el.click();
        WebDriverSingleton.getInstance().switchTo().frame("TPASection_jdbkbazeiframe");
        checkMenuItem(str, "Всі дописи");


    }

    @Test(description="Check menu item Корисні посилання", groups={"link"})
    public void test_6(){
        Set<String> browserTabs = WebDriverSingleton.getInstance().getWindowHandles();
        String[] str = new String[1];
        str = new String[]{"Корисні посилання"};
        checkMenuItem(str, "прокат");
        System.out.println(WebDriverSingleton.getInstance().getCurrentUrl());
        WebElement link = WebDriverSingleton.getInstance().findElement(By.xpath("//a[contains(@href,'http://rollersport.com.ua/')]"));
        link.click();
        WebDriverSingleton.getInstance().switchTo().window(WebDriverSingleton.getInstance().getWindowHandles().toArray()[1].toString());
        String expectedText_1 = "Українська Федерація Роликового Спорту";
        Assert.assertTrue(WebDriverSingleton.getInstance().getPageSource().contains(expectedText_1), expectedText_1+" Text not found!");

    }


}
