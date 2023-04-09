package com.shestakov.dmitriy.pages;

import com.shestakov.dmitriy.utils.ConvertToString;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AddMarkToCartPage {
    private final String TITLE_TEXT = "Маркировка";
    private final String BASIK_SUBSCRIPTION = "Базовая подписка";
    private final int PRICE = 6700;
    private String titleAndPrice(int quantity){
        return TITLE_TEXT +" " + ConvertToString.convertIntToString(PRICE * quantity) + " руб.  / год";
    };

    @Step("Открыть страницу с товаром \"Маркировка\"")
    public AddMarkToCartPage openPage(){
        open("/store/apps/e7e1a9af-d0ad-4dec-97ce-8b27805c145d");
        $(".app-basic__title").shouldHave(text(TITLE_TEXT));
        return this;
    }

    @Step("Найти карточку \"Базовая подписка\"")
    public AddMarkToCartPage verifySubscriptionExisting() {
        $("plan-item .plan__name").shouldHave(text(BASIK_SUBSCRIPTION));
        return this;
    }

    @Step("Проверить содержимое корзины")
    public AddMarkToCartPage verifyCartContent(int terminalQuantity) {
        $(".basket__list-item").shouldHave(text(titleAndPrice(terminalQuantity)));
        return this;
    }

    @Step("Проверить содержимое корзины")
    public AddMarkToCartPage verifyCartContent() {
        int terminalQuantity = 1;
        $(".basket__list-item").shouldHave(text(titleAndPrice(terminalQuantity)));
        return this;
    }

    @Step("Добавить карточку в корзину")
    public AddMarkToCartPage addToCart(){
        $(".plan-item-controls__basket-button").click();
        return this;
    }

    @Step("Увеличить колличество терминалов в карточке до {terminalQuantity}")
    public AddMarkToCartPage increaseTerminal(int terminalQuantity){
        for(int i = 0; i<terminalQuantity-1; i++) {
            $(".evo-plus-minus__button:nth-child(2)").click();
        }
        if(terminalQuantity < 5){
            $(".plan-devices__title").shouldHave(text(terminalQuantity + " терминала"));
        } else {
            $(".plan-devices__title").shouldHave(text(terminalQuantity + " терминалов"));
        }
        return this;
    }

    @Step("Открыть корзину через значок \"Корзины\"")
    public AddMarkToCartPage openTheCartIcon(){
        $(".header__button_basket").click();
        return this;
    }

    @Step("Открыть корзину через кнопку \"В КОРЗИНЕ\"")
    public AddMarkToCartPage openTheCartButton(){
        $(".plan-item-controls__basket-button").shouldHave(text("В корзине")).click();
        return this;
    }
}
