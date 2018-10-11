import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by root on 9/3/2018.
 */
public class MainPage {

    private WebDriver driver;

    String newsMenu_xpath="//p[contains(text(),\"Новини\")]";

    public MainPage(WebDriver driver) {
        this.driver = driver;

        //newsMenu_xpath = "//p[contains(text(),'Новини')]";
    }

    public MainPage openSite() {
        driver.get("https://olegregist.wixsite.com/skateslviv");
        return this;
    }

    public NewsPage clickMenuNews() {
        driver.findElement(By.xpath(newsMenu_xpath)).click();
        return new NewsPage(this.driver);
    }
}
