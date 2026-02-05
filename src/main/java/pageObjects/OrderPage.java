package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;


public class OrderPage {

    private WebDriver driver;

    private final By nameField = By.xpath(".//input[@placeholder='* Имя']");
    private final By surnameField = By.xpath(".//input[@placeholder='* Фамилия']");
    private final By addressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private final By subwayField = By.xpath(".//input[@placeholder='* Станция метро']");
    private final By phoneField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private final By nextButton = By.xpath(".//button[text()='Далее']");


    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    /** Заполнение поля Имя */
    public void fillNameField(String nameValue) {
        driver.findElement(nameField).sendKeys(nameValue);
    }

    /** Заполнение поля Фамилия */
    public void fillSurnameField(String surnameValue) {
        driver.findElement(surnameField).sendKeys(surnameValue);
    }

    /** Заполнение поля Адрес */
    public void fillAddressField(String addressValue) {
        driver.findElement(addressField).sendKeys(addressValue);
    }

    /** Заполнение поля Метро */
    public void fillSubwayField(String subwayValue) {
        driver.findElement(subwayField).click();
        driver.findElement(subwayField).sendKeys(subwayValue);
        driver.findElement(subwayField).sendKeys(Keys.DOWN,Keys.ENTER);
    }

    /** Заполнение поля Телефон */
    public void fillPhoneField(String phoneValue) {
        driver.findElement(phoneField).sendKeys(phoneValue);
    }

    /** Клик по кнопке Далее */
    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }
}


