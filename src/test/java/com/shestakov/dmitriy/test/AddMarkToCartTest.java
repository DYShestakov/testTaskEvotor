package com.shestakov.dmitriy.test;

import com.shestakov.dmitriy.pages.AddMarkToCartPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static java.lang.Thread.sleep;

@Feature("Товар в корзине")
public class AddMarkToCartTest extends AddMarkToCartBase {
    AddMarkToCartPage addMarkToCartPage = new AddMarkToCartPage();
    private final int TERMINAL_QUANTITY = 5;


    @Test
    @Story("Добавление товара в корзину")
    @Owner("shestakovdyu")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://market.evotor.ru/store/apps/e7e1a9af-d0ad-4dec-97ce-8b27805c145d#section-tariff")
    @DisplayName("Добавление подписки в корзину и открытие корзины через значок корзины")
    void AddToCartOpenCartByIcon() throws InterruptedException {
        open("/store/apps/e7e1a9af-d0ad-4dec-97ce-8b27805c145d");
        sleep(5000);
        addMarkToCartPage
                .verifySubscriptionExisting()
                .addToCart()
                .openTheCartIcon()
                .verifyCartContent();
    }

    @Test
    @Story("Добавление товара в корзину")
    @Owner("shestakovdyu")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://market.evotor.ru/store/apps/e7e1a9af-d0ad-4dec-97ce-8b27805c145d#section-tariff")
    @DisplayName("Добавление подписки в корзину и открытие корзины через кнопку \"В КОРЗИНЕ\"")
    void AddToCartOpenCartByButton() {
        addMarkToCartPage.openPage()
                .verifySubscriptionExisting()
                .addToCart()
                .openTheCartButton()
                .verifyCartContent();
    }


    @Test
    @Story("Добавление товара в корзину")
    @Owner("shestakovdyu")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://market.evotor.ru/store/apps/e7e1a9af-d0ad-4dec-97ce-8b27805c145d#section-tariff")
    @DisplayName("Добавление подписки с несколькими терминалами")
    void addToCartSeveralTerminals() {
        addMarkToCartPage.openPage()
                .verifySubscriptionExisting()
                .increaseTerminal(TERMINAL_QUANTITY)
                .addToCart()
                .openTheCartIcon()
                .verifyCartContent(TERMINAL_QUANTITY);
    }


}
