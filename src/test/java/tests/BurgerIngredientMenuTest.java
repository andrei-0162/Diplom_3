package tests;

import factory.DriverFactory;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Rule;
import org.junit.Test;
import pageobject.BurgerIngredientMenu;

@DisplayName("Раздел «Конструктор»")
public class BurgerIngredientMenuTest {
    @Rule
    public DriverFactory driverFactory = new DriverFactory();

    @Test
    @DisplayName("Раздел «Конструктор»")
    @Description("Проверка переходов по разделам «Соберите бургер»")
    public void tabSwitch() {

        new BurgerIngredientMenu(driverFactory.getDriver())
                .openMainPage()
                .clickTabButton(BurgerIngredientMenu.SAUCE_TAB_LOCATOR)
                .checkTabRedirect(BurgerIngredientMenu.SAUCE_TITLE_LOCATOR)
                .clickTabButton(BurgerIngredientMenu.BUNS_TAB_LOCATOR)
                .checkTabRedirect(BurgerIngredientMenu.BUNS_TITLE_LOCATOR)
                .clickTabButton(BurgerIngredientMenu.TOPPING_TAB_LOCATOR)
                .checkTabRedirect(BurgerIngredientMenu.TOPPING_TITLE_LOCATOR);

    }

}
