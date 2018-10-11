import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;


/**
 * Created by root on 8/13/2018.
 */
public class test_1 extends BaseTestClass {
    private static volatile test_1 instance;

    private test_1() {
    }

    @Test(description="Check menu item Галерея", groups={"funct"})
    public void test_1() {
        MainPage mainPage = new MainPage(WebDriverSingleton.getInstance());
        mainPage.openSite();
        String[] str = new String[1];
        str = new String[]{"Галерея"};
        checkMenuItem(str, "");
        WebDriverSingleton.getInstance().switchTo().frame("comp-jd0hhh6eiframe");
        Boolean img = WebDriverSingleton.getInstance().findElement(By.xpath("//*[@class=\"imgContainer ng-scope\"]")).isDisplayed();
        System.out.println(img);
        System.out.println(WebDriverSingleton.getInstance().getCurrentUrl().equals("https://olegregist.wixsite.com/skateslviv/media"));
        Assert.assertTrue((WebDriverSingleton.getInstance().getCurrentUrl().equals("https://olegregist.wixsite.com/skateslviv/media"))&&img, " Page not loaded");

    }

    @Test(description="Check menu item Де покататись", groups={"funct"})
    public void test_2() {
        MainPage mainPage = new MainPage(WebDriverSingleton.getInstance());
        mainPage.openSite();
        String[] str = new String[2];
        str = new String[]{"Де ...", "... покататись?"};
        checkMenuItem(str, "Місця для катання на роликах");
    }

    @Test(description="Check menu item Де купити", groups={"funct"})
    public void test_3() {
        MainPage mainPage = new MainPage(WebDriverSingleton.getInstance());
        mainPage.openSite();
        String[] str = new String[2];
        str = new String[]{"Де ...", "... купити?"};
        checkMenuItem(str, "Купівля роликів");
    }

    @Test(description="Check menu item Стилі катання", groups={"funct"})
    public void test_4() {
        MainPage mainPage = new MainPage(WebDriverSingleton.getInstance());
        mainPage.openSite();
        String[] str = new String[2];
        str = new String[]{"Про Ролики", "Стилі катання"};
        checkMenuItem(str, "Стилі катання на роликах");
    }


    @Test(description="Check menu item Новини", groups={"funct"})
    public void test_5() {
        MainPage mainPage = new MainPage(WebDriverSingleton.getInstance());
        mainPage.openSite();
        String[] str = new String[0];
        str = new String[]{};
        WebElement menu_el = WebDriverSingleton.getInstance().findElement(By.xpath("//p[contains(text(),\"Новини\")]"));
        menu_el.click();
        WebDriverSingleton.getInstance().switchTo().frame("TPASection_jdbkbazeiframe");
        checkMenuItem(str, "Всі дописи");


    }

    @Test(description="Check menu item Корисні посилання", groups={"link"})
    public void test_6(){
        MainPage mainPage = new MainPage(WebDriverSingleton.getInstance());
        mainPage.openSite();
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
    @Test(description="Execute JS from web driver", groups={"funct"})
    public void test_7() throws InterruptedException {
        MainPage mainPage = new MainPage(WebDriverSingleton.getInstance());
        mainPage.openSite();
        log.println("Site is open");
        JavascriptExecutor js = (JavascriptExecutor) WebDriverSingleton.getInstance();
        WebElement button =WebDriverSingleton.getInstance().findElement(By.cssSelector("#comp-jdof8h9gimgimage"));
        js.executeScript("arguments[0].click()", button);
        String[] str;
        str = str = new String[]{};
        checkMenuItem(str, "Dear visitor");
        String TitleName = js.executeScript("return document.title;").toString();
        System.out.println("Title of the page = "+TitleName);
        Assert.assertTrue((WebDriverSingleton.getInstance().getCurrentUrl().equals("https://olegregist.wixsite.com/skateslviv/index-eng")), " Page not loaded");

    }

    @Test
    public void clearTest(){
        MainPage mainPage = new MainPage(WebDriverSingleton.getInstance());
        NewsPage newsPage;
        newsPage = mainPage.openSite().clickMenuNews();
        newsPage.selectLastNews();
        newsPage.scrollToNewOne();
        Assert.assertTrue(newsPage.getLastNewsTitle().equals("Last News"), "Incorrect news titile");
    }

}
