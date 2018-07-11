package org.selenide.examples;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DuckGo {

    @Test
    public void searchInDuckDuckGo() {
        open("https://duckduckgo.com");
        sleep(1000);
        $(By.id("search_form_input_homepage")).setValue("Maven in 5 minutes").pressEnter();
        screenshot("text in DuckDuckGo");
        $$(By.className("result__a")).shouldHave(size(30));
        $("div#r1-0 div.result__snippet").shouldHave(
                text("Maven"),
                text("understanding"));
    }
}
