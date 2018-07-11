package org.selenide.examples;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class GoogleSearch {
    static String URL = null;
    static String word = null;

    @BeforeAll
    public static void variables() {
        URL = "http://www.google.com";
        word = "Cheese";
    }

    @Test
    public void simpleGoogleSearch() {
        open(URL);
        $(By.name("q")).setValue(word).pressEnter();
        System.out.println("Page title is: " + title());
        screenshot("G");
        assertEquals( word+" - "+"Пошук Google", title());
        $$(By.xpath("//*[@id=\"rso\"]/div/div/div")).shouldHave(size(11));
    }
}


