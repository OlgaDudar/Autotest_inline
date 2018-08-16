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
        String[] str = new String[0];
        str = new String[]{};
        WebElement menu_el = driver.findElement(By.xpath("//p[contains(text(),\"Новини\")]"));
        menu_el.click();
        driver.switchTo().frame("TPASection_jdbkbazeiframe");
        checkMenuItem(str, "Всі дописи");


    }

}
