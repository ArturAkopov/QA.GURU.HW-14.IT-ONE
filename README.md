# Проект по автоматизации тестирования для компании [IT-One](https://www.it-one.ru/)
> IT_ONE — современная гибкая компания, обладающая преимуществом использования новейших технологий и процессов. IT_ONE нацеленa на ускорение темпов роста цифровизации нашей страны с помощью новейших информационных технологий и ведущих мировых практик.
## :scroll: Содержание:
- [Используемый стек](#computer-используемый-стек)
- [Реализованные проверки](#ballot_box_with_check-Реализованные-проверки)
- [Запуск тестов из терминала](#arrow_forward-Запуск-автотестов)
- [Сборка в Jenkins](#-сборка-в-jenkins)
- [Пример Allure-отчета](#-пример-allure-отчета)
- [Интеграция с Allure TestOps](#-интеграция-с-allure-testOps)
- [Интеграция с Jira](#-интеграция-с-jira)
- [Уведомления в Telegram](#-уведомления-в-telegram)
- [Видео примера запуска тестов в Selenoid](#-видео-примера-запуска-теста-в-selenoid)
  
## :computer: Используемый стек
<p align="center">
<img width="6%" title="IntelliJ IDEA" src="media/logo/Intelij_IDEA.svg">
<img width="6%" title="Java" src="media/logo/Java.svg">
<img width="6%" title="Selenide" src="media/logo/Selenide.svg">
<img width="6%" title="Selenoid" src="media/logo/Selenoid.svg">
<img width="6%" title="Allure Report" src="media/logo/Allure_Report.svg">
<img width="6%" title="Gradle" src="media/logo/Gradle.svg">
<img width="6%" title="JUnit5" src="media/logo/JUnit5.svg">
<img width="6%" title="GitHub" src="media/logo/GitHub.svg">
<img width="6%" title="Jenkins" src="media/logo/Jenkins.svg">
<img width="6%" title="Telegram" src="media/logo/Telegram.svg">
</p>

- В данном проекте автотесты написаны на языке <code>Java</code> с использованием фреймворка для тестирования Selenide. 
- В качестве сборщика был использован - <code>Gradle</code>.  
- Использованы фреймворки <code>JUnit 5</code> и [Selenide](https://selenide.org/).
- При прогоне тестов браузер запускается в [Selenoid](https://aerokube.com/selenoid/).
- Для удаленного запуска реализована джоба в <code>Jenkins</code> с формированием Allure-отчета и отправкой результатов в <code>Telegram</code> при помощи бота. 

Содержание Allure-отчета:
* Шаги теста;
* Скриншот страницы на последнем шаге;
* Page Source;
* Логи браузерной консоли;
* Видео выполнения автотеста.

## :ballot_box_with_check: Реализованные проверки:

- Проверка содержания ссылки "https://www.it-one.ru/" в логотипе
- Проверка наименований разделов навигации в бургер-меню
- Проверка титульного названия раздела услуг компании
- Проверка титульного названия раздела вакансий компании
- Проверка работы кнопки "Компания" в разделе навигации в бургер-меню

## :arrow_forward: Запуск автотестов

### Запуск тестов из терминала
```
gradle clean test -Dselenoid_url="selenoid.autotests.cloud/wd/hub" -Dbrowser_size="1920х1080" -Dbrowser="chrome" -Dbrowser_version="100.0"
```
При выполнении данной команды в терминале IDE тесты запустятся удаленно в <code>Selenoid</code>.
