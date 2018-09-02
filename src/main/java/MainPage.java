import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by root on 9/3/2018.
 */
public class MainPage {

    WebDriver driver;

    String newsMenu_xpath = "//div[class='news']";

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }


    public NewsPage clickMenuNews() {
        driver.findElement(By.xpath(newsMenu_xpath)).click();
        return new NewsPage(this.driver);
    }
}
