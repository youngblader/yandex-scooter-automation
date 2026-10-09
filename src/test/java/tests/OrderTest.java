package tests;

import models.Color;
import models.OrderData;
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
    void successOrderTopButton(OrderData data) {
        homePage.clickTopOrderButton();
        orderPage.completeOrder(data);

        assertTrue(orderPage.isSuccessOrderModalDisplayed(), "Сообщение об успешном заказе не отображается");
    }

    @ParameterizedTest
    @MethodSource("orderData")
    void successOrderBottomButton(OrderData data) {
        homePage.clickBottomOrderButton();
        orderPage.completeOrder(data);

        assertTrue(orderPage.isSuccessOrderModalDisplayed(), "Сообщение об успешном заказе не отображается");
    }

    private static Stream<Arguments> orderData() {
        return Stream.of(
                Arguments.of(new OrderData(
                        "Андрей", "Богомолов", "Московская", "Лубянка",
                        "+79912328382", "16.07.2026", "двое суток", Color.BLACK, "Не звонить")),
                Arguments.of(new OrderData(
                        "Екатерина", "Высоцкая", "Питерская", "Комсомольская",
                        "+79912371829", "16.07.2026", "сутки", Color.GREY, "Звонить днем"))
        );
    }
}
