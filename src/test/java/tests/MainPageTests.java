package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.MainPage;

@Owner("Акопов Артур")
@Tag("mainPage")
@DisplayName("Тесты для главной страницы \"https://www.it-one.ru/\"")
public class MainPageTests extends TestBase {

    MainPage step = new MainPage();

    @Test
    @DisplayName("Проверка содержания ссылки \"https://www.it-one.ru/\" в логотипе")
    void logoContainsLink() {
        step.openPage()
                .checkLinkHeaderLogo("https://www.it-one.ru/");
    }

    @Test
    @DisplayName("Проверка наименований разделов навигации в бургер-меню")
    void nameElementOfMenuNavigation() {
        step.openPage()
                .openBurgerMenu()
                .checkNameElement("""
                        Компания
                        Услуги IT_ONE
                        Карьера в IT_ONE
                        Вакансии
                        Новости и мероприятия
                        Контакты
                        """);
    }

    @Test
    @DisplayName("Проверка титульного названия раздела услуг компании")
    void titleNameAfterClickToButtonAllProvider() {
        step.openPage()
                .openAllProvider()
                .checkHeaderOpenPage("Услуги IT_ONE");
    }

    @Test
    @DisplayName("Проверка титульного названия раздела вакансий компании")
    void titleNameAfterClickToButtonAllVacancies() {
        step.openPage()
                .openAllVacancies()
                .checkHeaderOpenPage("Вакансии");
    }

    @Test
    @DisplayName("Проверка работы кнопки \"Компания\" в разделе навигации в бургер-меню")
    void titleNameAfterClickToButtonAllNews() {
        step.openPage()
                .openBurgerMenu()
                .openElementNavigationInBurgerMenu("Компания")
                .checkUrl("https://www.it-one.ru/company/");
    }
}

