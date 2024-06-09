package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Logout {

    private WebDriver driver;
    public Logout(WebDriver driver) {
        this.driver = driver;
    }
    public static final By LOGOUT_BUTTON_LOCATOR = By.xpath(".//button[text()='Выход']");
    @Step("Клик по кнопке [Выход]")
    //метод для клика по кнопке [Выход]
    public Logout clickLogoutButton() {
        new CustomClick().clickOnElement(driver, LOGOUT_BUTTON_LOCATOR);
        return this;
    }
    @Step("Переход на страницу \"Личного кабинета\"")
    //метод проверки перехода на страницу "Личного кабинета"
    public Logout checkSuccessfulRedirect() {
        new Login(driver).checkOpeningLoginPage();
        return this;
    }



}
