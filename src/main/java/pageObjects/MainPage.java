package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    private WebDriver driver;

    private final By cookieButton = By.id("rcc-confirm-button");

    private final By headerOrderButton = By.className("Button_Button__ra12g");
    private final By middleOrderButton = By.className("Button_UltraBig__UU3Lp");


    private static final String questionButtonId = "accordion__heading-";
    private static final String answerButtonId = "accordion__panel-";


    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public By getQuestionElement(String ids) {
        String finalId = questionButtonId + ids;
        return By.id(finalId);
    }

    public By getAnswerElement(String ids) {
        String finalId = answerButtonId + ids;
        return By.id(finalId);
    }

    /** Открыть сайт */
    public void openSite() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    /** Принять куки */
    public void clickCookieButton() {
        driver.findElement(cookieButton).click();
    }

    /** Клик по кнопке Заказать в хедере */
    public void clickHeaderOrderButton() {
        driver.findElement(headerOrderButton).click();
    }

    /** Клик по кнопке Заказать в середине страницы */
    public void clickMiddleOrderButton() {
        driver.findElement(middleOrderButton).click();
    }

    /** Скролл главной страницы до элемента */
    public void scrollPageToElement(By targetElement) {
        WebElement element = driver.findElement(targetElement);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }
}
