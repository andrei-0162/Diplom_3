package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UserRegistration {
    private WebDriver driver;
    public UserRegistration(WebDriver driver) {
        this.driver = driver;
    }

    //URL для перехода на страницу регистрации
    private final String REGISTRATION_URL = "https://stellarburgers.nomoreparties.site/register";

    //локаторы полей регистрации, кнопки [Зарегистрироваться], текста "Некорректный пароль"
    private By nameField = By.xpath("//label[text() = 'Имя']/parent::div/input");
    private By emailField = By.xpath("//label[text() = 'Email']/parent::div/input");
    private By passwordField = By.xpath("//label[text() = 'Пароль']/parent::div/input");
    private By registerButton = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']");
    private By invalidPasswordLabel = By.xpath(".//p[text()='Некорректный пароль']");

    @Step("Переход на страницу Регистрации")
    //метод для перехода на страницу "Регистрации"
    public UserRegistration openRegistrationPage() {
        driver.get(REGISTRATION_URL);
        return this;
    }

    @Step("Ввод Имени")
    //метод для ввода Имени
    public UserRegistration setNameField(String name) {
        driver.findElement(nameField).sendKeys(name);
        return this;
    }
    @Step("Ввод Email")
    //метод для ввода Email
    public UserRegistration setEmailField(String email) {
        driver.findElement(emailField).sendKeys(email);
        return this;
    }
    @Step("Ввод Пароля")
    //метод для ввода Пароля
    public UserRegistration setPasswordField(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }
    @Step("Клик по кнопке [Зарегистрироваться]")
    //метод для клика на кнопку [Зарегистрироваться]
    public UserRegistration clickRegisterButton () {
        new CustomClick().clickOnElement(driver, registerButton);
        return this;
    }
    @Step("Проверка успешной регистрации")
    //метод проверки успешной регистрации
    public UserRegistration checkSuccessfulRegistration() {
        new Login(driver).checkOpeningLoginPage();
        return this;
    }
    @Step("Проверка безуспешной регистрации")
    //метод проверки безуспешной регистрации
    public UserRegistration checkUnsuccessfulRegistration() {
        new WebDriverWait(driver, Duration.ofSeconds(Constants.DEFAULT_TIMER))
                .until(ExpectedConditions.visibilityOfElementLocated(invalidPasswordLabel));
        return this;
    }
    @Step("Регистрации пользователя")
    //метод регистрации пользователя
    public UserRegistration userRegistration(String name, String email, String password) {
                openRegistrationPage();
                setNameField(name);
                setEmailField(email);
                setPasswordField(password);
                clickRegisterButton();
        return this;
    }




}
