import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.MainPage;

import java.time.Duration;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ImportantQuestionsTest extends CommonActions{

    static MainPage objMainPage = new MainPage(driver);

    private static Stream<Arguments> importantAnswers() {
        return Stream.of(
                Arguments.of(objMainPage.getQuestionElement("0"),
                        objMainPage.getAnswerElement("0"),
                        "Сутки — 400 рублей. Оплата курьеру — наличными или картой."),
                Arguments.of(objMainPage.getQuestionElement("1"),
                        objMainPage.getAnswerElement("1"),
                        "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."),
                Arguments.of(objMainPage.getQuestionElement("2"),
                        objMainPage.getAnswerElement("2"),
                        "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."),
                Arguments.of(objMainPage.getQuestionElement("3"),
                        objMainPage.getAnswerElement("3"),
                        "Только начиная с завтрашнего дня. Но скоро станем расторопнее."),
                Arguments.of(objMainPage.getQuestionElement("4"),
                        objMainPage.getAnswerElement("4"),
                        "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."),
                Arguments.of(objMainPage.getQuestionElement("5"),
                        objMainPage.getAnswerElement("5"),
                        "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."),
                Arguments.of(objMainPage.getQuestionElement("6"),
                        objMainPage.getAnswerElement("6"),
                        "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."),
                Arguments.of(objMainPage.getQuestionElement("7"),
                        objMainPage.getAnswerElement("7"),
                        "Да, обязательно. Всем самокатов! И Москве, и Московской области.")
        );
    }

    @ParameterizedTest
    @MethodSource("importantAnswers")
    public void answerListContentsTest(By questionElement, By answerElement, String expected) {
        MainPage objMainPage = new MainPage(driver);

        objMainPage.scrollPageToElement(questionElement);
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(driver -> (driver.findElement(questionElement).isEnabled()));
        driver.findElement(questionElement).click();
        objMainPage.scrollPageToElement(answerElement);
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(driver -> !driver.findElement(answerElement).getText().isEmpty());
        assertEquals(expected, driver.findElement(answerElement).getText());

    }
}
