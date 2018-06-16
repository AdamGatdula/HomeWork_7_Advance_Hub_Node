import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class OpenGoogle {
    private WebDriver driver;

    @Parameters("browser")
    @BeforeClass
    public void test (String browser) throws MalformedURLException {
        DesiredCapabilities cap = null;
        if (browser.equalsIgnoreCase("chrome")){
            driver= new RemoteWebDriver(new URL("http://192.168.1.80:4445/wd/hub"),new ChromeOptions());
        } else if (browser.equalsIgnoreCase("firefox")){
            driver = new RemoteWebDriver(new URL("http://192.168.1.80:4445/wd/hub"),new FirefoxOptions());
        }
            driver.get("https://www.google.com");
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
    @Test
    public void openBrowser(){
        driver.findElement(By.id("lst-ib")).sendKeys("Grid");
        }
    @AfterClass public void endTest(){
        driver.quit();
    }
}

