package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import userapieditor.Resources;


public class DriverFactory extends ExternalResource {






    @Override
    protected void before() throws Throwable {
        initDriver();
        RestAssured.baseURI = Resources.BASE_URL;

    }

    @Override
    protected void after() {
        driver.quit();
    }


    private WebDriver driver;

    public void initDriver() {
        if ("yandex".equals(System.getProperty("browser"))) {
            initYandex();
        } else {
            initChrome();
            }

    }

    private void initChrome() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }


    private void initYandex() {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\chromedriver.exe");
            options.setBinary("C:\\Users\\Xiaomi\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
            driver = new ChromeDriver(options);
    }

    public WebDriver getDriver() {
        return driver;
    }
}
