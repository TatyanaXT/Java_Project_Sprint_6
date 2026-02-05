import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import pageObjects.MainPage;
import pageObjects.OrderPage;
import pageObjects.RentPage;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ScooterOrderTest extends CommonActions{

    private static Stream<Arguments> inputData() {

        List<String> orderData1 = List.of("Татьяна", "Ларина", "Пушкинская 32", "Пушкинская", "+79214896358");
        List<String> orderData2 = List.of("Кирилл", "Мефодьевич", "Алфавитная 16", "ВДНХ", "89214963587");

        List<String> rentData1 = List.of("2026.02.10", "сутки", "black", "не звоните");
        List<String> rentData2 = List.of("2027.01.02", "трое суток", "grey", "напомните за пару дней");

        return Stream.of(
                Arguments.of(orderData1, rentData1),
                Arguments.of(orderData2, rentData2)
        );
    }

    private void commonActionsForOrdering (List<String> orderData, List<String> rentData) {

        OrderPage objOrderPage = new OrderPage(driver);
        RentPage objRentPage = new RentPage(driver);

        objOrderPage.fillNameField(orderData.get(0));
        objOrderPage.fillSurnameField(orderData.get(1));
        objOrderPage.fillAddressField(orderData.get(2));
        objOrderPage.fillSubwayField(orderData.get(3));
        objOrderPage.fillPhoneField(orderData.get(4));
        objOrderPage.clickNextButton();

        objRentPage.fillDataField(rentData.get(0));
        objRentPage.fillRentalPeriodField(
                objRentPage.getRentalTime(rentData.get(1))
        );
        objRentPage.clickCheckBoxColour(rentData.get(2));
        objRentPage.sendComment(rentData.get(3));
        objRentPage.clickOrderButton();
        objRentPage.clickConfirmButton();

    }

    @ParameterizedTest
    @MethodSource("inputData")
    public void orderFromHeaderTest(List<String> orderData, List<String>rentData) {
        MainPage objMainPage = new MainPage(driver);
        RentPage objRentPage = new RentPage(driver);

        objMainPage.clickHeaderOrderButton();
        commonActionsForOrdering (orderData, rentData);
        assertTrue(objRentPage.isModalWindowSuccessEnable());

    }

    @ParameterizedTest
    @MethodSource("inputData")
    public void orderFromMiddleTest(List<String> orderData, List<String>rentData) {
        MainPage objMainPage = new MainPage(driver);
        RentPage objRentPage = new RentPage(driver);

        objMainPage.clickMiddleOrderButton();
        commonActionsForOrdering (orderData, rentData);
        assertTrue(objRentPage.isModalWindowSuccessEnable());

    }

}
