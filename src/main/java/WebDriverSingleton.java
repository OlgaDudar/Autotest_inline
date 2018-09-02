import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by root on 8/15/2018.
 */
public class WebDriverSingleton {

    private static WebDriver driver;


    private WebDriverSingleton() {
        ;
    }

    public static WebDriver getInstance() {
        if (driver == null) {
            driver = new ChromeDriver();
        }
        return driver;
    }

    /*ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>() // thread local driver object for webdriver
    {
        public ThreadLocal<WebDriver> getInstance() {
            if (driver == null) {
                driver = new ThreadLocal<WebDriver>();
            }
            return driver;
        }
    };*/

}



