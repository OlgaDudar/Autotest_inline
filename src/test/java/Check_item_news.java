import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by root on 8/16/2018.
 */
public class Check_item_news extends BaseTestClass {
    @Test
    public void test_1() {
        MainPage mainPage = new MainPage(WebDriverSingleton.getInstance());
        mainPage.openSite();
        String[] str = new String[0];
        str = new String[]{};
        WebElement menu_el = WebDriverSingleton.getInstance().findElement(By.xpath("//p[contains(text(),\"Новини\")]"));
        menu_el.click();
        WebDriverSingleton.getInstance().switchTo().frame("TPASection_jdbkbazeiframe");
        checkMenuItem(str, "Всі дописи");


    }

}
