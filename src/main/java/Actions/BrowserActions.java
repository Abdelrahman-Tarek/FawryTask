package Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserActions {
    public static WebDriver driver;
    public WebDriver initializeTheWebDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        return driver;
    }

    public void maximizeScreen(){
        driver.manage().window().maximize();
    }
    public void closeDriver(){
        driver.close();
    }

}

