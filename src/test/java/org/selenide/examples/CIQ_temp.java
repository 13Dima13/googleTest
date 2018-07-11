package org.selenide.examples;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selenide.*;

public class CIQ_temp {
    @Test
    @Tag("smoke")
    public void shortCIQtest() {
        open("https://staging.creatoriq.com/login.php");
        sleep(1000);
        $(By.id("okta-signin-username")).setValue("dmytro.stadnik@creatoriq.com");
        $(By.id("okta-signin-password")).setValue("1111").pressEnter();

        screenshot("Login");
        $$(By.xpath("/html/body/div[1]/header/div/nav/div[2]/div/div[2]/div[1]/a/div[2]/text()")).shouldHave(texts("Dmytro Stadnik"));

//        $$(By.className("result__a")).shouldHave(size(30));
        //$$(By.xpath("//*[@id=\"rso\"]/div/div/div[1]/div/div/h3/a")).shouldHave(texts("Maven – Maven in 5 Minutes"));
    }
}
