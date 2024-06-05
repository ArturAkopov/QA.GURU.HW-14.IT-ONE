package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.href;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.currentFrameUrl;

public class MainPage {

    private final SelenideElement
            headerLogo = $(".header__logo-link"),
            burgerButton = $(".burger-button"),
            menuNavigation = $(".menu__nav"),
            allProvider = $(".section").$(byText("Все услуги")),
            bigHeading = $(".big-heading"),
            allVacancies = $("#job-section").$(byText("Все вакансии"));

    @Step("Открытие страницы \"https://www.it-one.ru/\"")
    public MainPage openPage() {
        open("");
        return this;
    }

    @Step("Открытие бургер-меню")
    public MainPage openBurgerMenu() {
        burgerButton.click();
        return this;
    }

    @Step("Открытие раздела \"Все услуги\"")
    public MainPage openAllProvider() {
        allProvider.click();
        return this;
    }

    @Step("Открытие раздела \"Все вакансии\"")
    public MainPage openAllVacancies() {
        allVacancies.click();
        return this;
    }

    @Step("Нажатие кнопки навигации {key} в бургер-меню")
    public MainPage openElementNavigationInBurgerMenu(String key) {
        menuNavigation.$(byText(key)).click();
        return this;
    }

    @Step("Проверка наличия ссылки {key} в логотипе компании")
    public void checkLinkHeaderLogo(String key) {
        headerLogo.shouldHave(href(key));
    }

    @Step("Проверка заголовка {key} в открывшемся разделе")
    public void checkHeaderOpenPage(String key) {
        bigHeading.shouldHave(text(key));
    }

    @Step("Проверка названий элементов навигации бургер-меню")
    public void checkNameElement(String key) {
        menuNavigation.shouldHave(text(key));
    }

    @Step("Проверка совпадения Url текущей страницы с {key}")
    public void checkUrl(String key) {
        webdriver().shouldHave(currentFrameUrl(key));
    }
}
