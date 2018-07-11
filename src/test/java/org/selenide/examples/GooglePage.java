package org.selenide.examples;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selenide.*;

public class GooglePage {

    @Test
    public void userCanSearch() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = false;
        Configuration.fastSetValue = true;


        open("http://google.com");
        sleep(1000);
        $(By.name("q")).setValue("Maven in 5 minutes").pressEnter();
        screenshot("text in google");
        $$(By.xpath("//*[@id=\"rso\"]/div/div/div")).shouldHave(size(9));
        $$(By.xpath("//*[@id=\"rso\"]/div/div/div[1]/div/div/h3/a")).shouldHave(texts("Maven - Maven in 5 Minutes - The Apache Software Foundation!"));
    }
}


//    open("http://www.google.com");
//    assertEquals("Google", title());   // OK
//        $("title").shouldHave(exactText("Google"));  // NOK