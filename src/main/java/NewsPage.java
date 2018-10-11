import org.openqa.selenium.WebDriver;

/**
 * Created by root on 9/3/2018.
 */
public class NewsPage {

    private WebDriver driver;

    public NewsPage(WebDriver driver) {
        this.driver = driver;
    }

    public NewsPage selectLastNews() {
        return this;
    }

    public NewsPage scrollToNewOne(){
        return this;
    }

    public String getLastNewsTitle() {
        return "";
    }
}
