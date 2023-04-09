package com.shestakov.dmitriy.test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

public class AddMarkToCartBase {

    @AfterEach
    public void afterEach() {
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
    }

    @BeforeAll
    public static void beforeAll() {
        Configuration.baseUrl = "https://market.evotor.ru";
    }

}
