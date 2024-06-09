package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CustomClick {

    public void clickOnElement(WebDriver driver, By locator) {
//        if ("firefox".equals(System.getProperty("browser"))) {
//            //new WebDriverWait(driver, Duration.ofSeconds(Constants.DEFAULT_TIMER));
//            new JSUtils().clickElementByJS(driver, locator);
//        } else {
//            new WebDriverWait(driver, Duration.ofSeconds(Constants.DEFAULT_TIMER))
//                    .until(ExpectedConditions.elementToBeClickable(locator));
//            driver.findElement(locator).click();
//        }



        new WebDriverWait(driver, Duration.ofSeconds(Constants.DEFAULT_TIMER))
                .until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }
}
