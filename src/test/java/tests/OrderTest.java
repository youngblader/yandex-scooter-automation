package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pages.HomePage;
import pages.OrderPage;
import utils.BaseTest;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrderTest extends BaseTest {
    private HomePage homePage;
    private OrderPage orderPage;

    @BeforeEach
    void setUp() {
        initPages();
        homePage.clickCloseCookie();
    }

    void initPages() {
        homePage = new HomePage(driver);
        orderPage = new OrderPage(driver);
    }

    @ParameterizedTest
    @MethodSource("orderData")
    void successOrderTopButton(String name, String surname, String address, String subway, String phone, String date, String period, String color, String comment) {
        homePage.clickTopOrderButton();
        orderPage.completeOrder(name, surname, address, subway, phone, date, period, color, comment);

        assertTrue(orderPage.isSuccessOrderModalDisplayed(), "Сообщение об успешном заказе не отображается");
    }

    @ParameterizedTest
    @MethodSource("orderData")
    void successOrderBottomButton(String name, String surname, String address, String subway, String phone, String date, String period, String color, String comment) {
        homePage.clickBottomOrderButton();
        orderPage.completeOrder(name, surname, address, subway, phone, date, period, color, comment);

        assertTrue(orderPage.isSuccessOrderModalDisplayed(), "Сообщение об успешном заказе не отображается");
    }

    private static Stream<Arguments> orderData() {
        return Stream.of(
                Arguments.of(
                        "Андрей",
                        "Богомолов",
                        "Московская",
                        "Лубянка",
                        "+79912328382",
                        "16.07.2026",
                        "двое суток",
                        "black",
                        "Не звонить"
                ),
                Arguments.of(
                        "Екатерина",
                        "Высоцкая",
                        "Питерская",
                        "Комсомольская",
                        "+79912371829",
                        "16.07.2026",
                        "сутки",
                        "grey",
                        "Звонить днем"
                )
        );
    }
}
