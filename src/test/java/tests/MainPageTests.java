package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.href;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.currentFrameUrl;

@DisplayName("Тесты для главной страницы https://www.it-one.ru/.")
public class MainPageTests extends TestBase {


    @Test
    @Tag("mainPage")
    @DisplayName("Проверка содержания ссылки https://www.it-one.ru/ в логотипе.")
    void logoContainsLink() {
        open("");
        $(".header__logo-link").shouldHave(href("https://www.it-one.ru/"));
    }

    @Test
    @Tag("mainPage")
    @DisplayName("Проверка наименований разделов навигации в бургер-меню")
    void nameElementOfMenuNavigation() {
        open("");
        $(".burger-button").click();
        $(".menu__nav").shouldHave(text("""
                Компания
                Услуги IT_ONE
                Карьера в IT_ONE
                Вакансии
                Новости и мероприятия
                Контакты
                """));
    }

    @Test
    @Tag("mainPage")
    @DisplayName("Проверка титульного названия раздела услуг компании.")
    void titleNameAfterClickToButtonAllProvider() {
        open("");
        $(".section").$(byText("Все услуги")).shouldHave(href("https://www.it-one.ru/services/")).click();
        $(".big-heading").shouldHave(text("Услуги IT_ONE"));
    }

    @Test
    @Tag("mainPage")
    @DisplayName("Проверка титульного названия раздела вакансий компании.")
    void titleNameAfterClickToButtonAllVacancies() {
        open("");
        $("#job-section").$(byText("Все вакансии")).shouldHave(href("https://www.it-one.ru/vacancies/")).click();
        $(".big-heading").shouldHave(text("Вакансии"));
    }

    @Test
    @Tag("mainPage")
    @DisplayName("Проверка работы кнопки \"Компания\" в разделе навигации в бургер-меню.")
    void titleNameAfterClickToButtonAllNews() {
        open("");
        $(".burger-button").click();
        $(".menu__nav").$(byText("Компания")).click();
        webdriver().shouldHave(currentFrameUrl("https://www.it-one.ru/company/"));
    }
}

