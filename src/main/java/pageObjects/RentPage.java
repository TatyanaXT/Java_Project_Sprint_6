package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;


public class RentPage {
    private WebDriver driver;

    private final By dataField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private final By rentalPeriodField = By.className("Dropdown-placeholder");
    private final By courierCommentField = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    private final By orderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']");
    private final By confirmButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");
    private final By modalWindowSuccess = By.className("Order_ModalHeader__3FDaJ");


    public RentPage(WebDriver driver) {
        this.driver = driver;
    }

    public By getRentalTime (String time){
        String rentalTime = ".//*[(@role ='option' and text()='%s')]";
        return By.xpath(String.format(rentalTime, time));
    }

    public boolean isModalWindowSuccessEnable() {
        return driver.findElement(modalWindowSuccess).isDisplayed();
    }

    /** Ввод даты доставки*/
    public void fillDataField(String date) {
        driver.findElement(dataField).sendKeys(date);
        driver.findElement(dataField).sendKeys(Keys.ENTER);
    }

    /** Ввод срока аренды*/
    public void fillRentalPeriodField(By rentalTime) {
        driver.findElement(rentalPeriodField).click();
        driver.findElement(rentalTime).click();
    }

    /** Выбор цвета самоката */
    public void clickCheckBoxColour(String checkBoxColour) {
        driver.findElement(By.id(checkBoxColour)).click();
    }

    /** Ввод комментария для курьера */
    public void sendComment(String userComment) {
        driver.findElement(courierCommentField).sendKeys(userComment);
    }

    /** Нажать кнопку Заказать */
    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }

    /** Подтвердить заказ */
    public void clickConfirmButton() {
        driver.findElement(confirmButton).click();
    }

}
