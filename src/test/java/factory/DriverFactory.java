package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import userapieditor.Resources;

import java.util.concurrent.TimeUnit;


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
//        if ("firefox".equals(System.getProperty("browser"))) {
//            initFirefox();
//        } else if ("yandex".equals(System.getProperty("browser"))) {
//            initYa();
//        } else {
//            initChrome();

            initYa();

    }

    private void initChrome() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    private void initFirefox() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();

    }

    private void initYa() {
//        WebDriverManager.chromedriver().setup();
//        ChromeOptions options = new ChromeOptions();
//        options.setBinary("C:\\Users\\Xiaomi\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
//        driver = new ChromeDriver(options);



            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.setBinary("C:\\Users\\Xiaomi\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
            driver = new ChromeDriver(options);


//            options.setBinary(System.getProperty("webdriver.yandex.bin"));

//            options.setCapability("browser", System.getProperty("browser"));
//            options.setCapability("version", System.getProperty("version"));

//        mvn -Dbrowser=yandex -Dbdriver.version=122.0.6261.94 -Dwebdriver.yandex.bin="C:/Users/Xiaomi/AppData/Local/Yandex/YandexBrowser/Application.browser.exe" test
    }

    public WebDriver getDriver() {
        return driver;
    }
}
