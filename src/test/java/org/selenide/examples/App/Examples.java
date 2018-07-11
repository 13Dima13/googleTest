///*
//package org.selenide.examples.App;
//
//import com.codeborne.selenide.CollectionCondition;
//import com.codeborne.selenide.Condition;
//import com.codeborne.selenide.Selenide.*;
//import com.codeborne.selenide.junit.ScreenShooter;
//import org.junit.AfterClass;
//import org.junit.Rule;
//import org.junit.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//
//import static com.codeborne.selenide.Condition.*;
//import static com.codeborne.selenide.Screenshots.takeScreenShot;
//import static com.codeborne.selenide.Selectors.*;
//import static com.codeborne.selenide.Selenide.*;
//import static com.codeborne.selenide.WebDriverRunner.source;
//import static com.codeborne.selenide.WebDriverRunner.url;
//
//// https://youtu.be/fR8CyLcxBZ0 (Selenide: Concise UI Tests in Java)
////https://github.com/selenide-examples/
//
//public class Examples {
//    @Test
//    public void examplesOf() throws FileNotFoundException {
//        //Find element by ID
//        WebElement customer = $("#customerContainer");
//        //OR
//        WebElement customer = $(By.id("customerContainer"));
//
//        //Assert that element has a correct text
//        $("#customerContainer").shouldHave(text("Customer profile"));
//
//        //Ajax support (waiting for some event to happen)
//        $("TEXTAREA").shouldHave(value("John"));
//
//        //Assert that element has a correct CSS class
//        $("#customerContainer").shouldHave(cssClass("errorField"));
//
//        //Find element by text
//        WebElement customer = $(byText("Customer profile"));
//
//        //Assert that element text matches a regular expression
//        $("#customerContainer").should(matchText("profile"));
//
//        //Assert that element does not exist
//        $("#customerContainer").shouldNot(exist);
//
//        //Looking for element inside parent element
//        $("#customerContainer").find(".user_name");
//
//        //Looking for Nth element
//        $("li", 5);
//        //Click "Ok" in alert dialog
//        confirm("Are you sure to delete your profile?");
//        //OR
//        dismiss("Are you sure to delete your profile?");
//
//        //Debugging info for elements
//        System.out.println($("#customerContainer"));
//        // output looks like this: "<option value=livemail.ru checked=true selected:true>@livemail.ru</option>"
//
//        //Take a screenshot
//        takeScreenShot("my-test-case");
//        //For JUnit users it's even more simpler:
//        public class MyTest {
//            //@Rule // automatically takes screenshot of every failed test
//            public ScreenShooter makeScreenshotOnFailure = ScreenShooter.failedTests();
//        }
//
//        //Select a radio button
//        $("test").selectRadio(By.name("sex"), "woman");
//
//        //Reload current page
//        refresh();
//
//        //Get the current page URL, title or source
//        url();
//        title();
//        source();
//
//
//
//
//
//
//
//
////Selenide - wrapper над Selenium
//
////ожидание
//        $("div").should(exist);
//
//
////or
////        try {
////            wait for element
////            return true
////        }
////        catch(NotFoudnException e){
////            return false;
////        }
//
////or
//        if ($("#info").isDisplayed()) {
//            $("#info-close").click();
//        }
//
////or
////        public boolean isVisible() {
////            try {
////                $("div").should(exist);
////                return true
////            } catch (error) {
////                return false
////            }
////        }
////КОл-во элменетов в списке
////        List<WebElement> list = wd.findElements(By.cssSelector("div.SAInfo div i.sex"));
////        assertThat(12, equalTo(list.size()));
//
//
////$ - первый элемент
////$$ - колекция
//
////ПОдождать пока элемент не пропадет на странице, если он уже есть
//        $("XXXXX").shouldNotBe(visible);
//
////Например модальное окно должно появиться, а внутри него какой-то элемент не должен появиться.
//        $("modal").should(appear);
//        $("modal #xxxxx").shouldNotBe(visible);
//
//        //Forget about AJAX - Smart waiting
//        $("loading_progress").shouldBe(visible);
//        $("#menu").shouldHave(text("Hello"));
//        $(By.name("sex")).shouldNotBe(selected);
//        $(By.name("sex")).should(disappear);
//
//        //should*() methods - waiting up to 4 seconds . Config "mvn -Dselenide.timeout=8000"
//
//        $(".error-msg").shouldNotBe(visible);
//        //Error messages
//        $(".alert").shouldNotHave(text("Error"));
//        //For collection
//        $$(".error").shouldHave(CollectionCondition.size(3));
//        $$("#employees tbody tr").shouldHave(CollectionCondition.texts(
//                "Jon",
//                "Vasya",
//                "Mike"
//        ));
//        $$("#employees tbody tr").filter((visible)).shouldHave(CollectionCondition.size(4));
//        //Upload file $.uploadFile(File file)
//        $("#cv").uploadFile(new File("cv1.doc"));
//        $("#cv").uploadFile(new File("cv1.doc"), new File("cv2.doc"));
//        //Download file $.download() - Selenide style
//        File pdf = $(".btn#cv").download();
//        //Custom matchers
//        //$("h1").shouldHave(css("font-size", "16px"));
//        //Find elements by text
//        $(byText("Hello, Portland!")).shouldBe(visible);
//        $(withText("ortla")).shouldHave(text("Hello, Portland!"));
//        //Search for parents or children
//        $("td").parent();
//        $("td").closest("tr");
//        $(".btn").closest("modal");
//        $("div").find(By.name("q"));
//        //Sizzle selectors
//        $$(":input").shouldHave(CollectionCondition.size(3));
//        $$(":input:not(.masked)").shouldHave(CollectionCondition.size(2));
//        $$(":header").shouldHave(CollectionCondition.size(3)); //h1, h1, h2
//        $$(":parent").shouldHave(CollectionCondition.size(13)); //all non-leaf elements
//        $$(":not(:parent)").shouldHave(CollectionCondition.size(12)); //all leaf elements
//
//        $(":input:first").shouldHave(attribute("name", "username"));
//        $(":input:nth(1)").shouldHave(attribute("name", "password"));
//        $(":input:last").shouldHave(attribute("name", "rememberMe"));
//        //Fast set value (sendKeys() is slow) Config "mvn -Dselenide.fastSetValue=true"
//        //$.setValue("John") - fast
//        //$.sendKeys("John") - for autocompletion
//
//        //Sizzle selectors
//        $$(":input").shouldHave(CollectionCondition.size(3));
//        $$(":input:not(.masked)").shouldHave(CollectionCondition.size(2));
//        $$(":header").shouldHave(CollectionCondition.size(3)); //h1, h1, h2
//        $$(":parent").shouldHave(CollectionCondition.size(13)); //all non-leaf elements
//        $$(":not(:parent)").shouldHave(CollectionCondition.size(12)); //all leaf elements
//
//        $(":input:first").shouldHave(attribute("name", "username"));
//        $(":input:nth(1)").shouldHave(attribute("name", "password"));
//        $(":input:last").shouldHave(attribute("name", "rememberMe"));
//        //Fast set value (sendKeys() is slow) Config "mvn -Dselenide.fastSetValue=true"
//        //$.setValue("John") - fast
//        //$.sendKeys("John") - for autocompletion
//
//
//        //Helpfull functions
//        $("div").scrollTo();
//        $("div").innerText();
//        $("div").innerHtml();
//        $("div").exists();
//        $("select").isImage();
//        $("select").getSelectedText();
//        $("select").getSelectedValue();
//        $("div").doubleClick();
//        $("div").contextClick();
//        $("div").hover(); //Навести мышь на объект, удобно если надо проверить какой-то popup, дальше можно просто By.text("hwge").visible
//        //Configuration.browser = "firefox";
//        //Configuration.startMaximized = false;
//        getJavascriptErrors();
//        executeJavaScript("alert(1)");
//
//
//        //zoom(2.5);
//        $("div.file").dragAndDropTo("div.fieldSelection-area"); // https://toster.ru/q/495169
//
//
//
//    }
//
//    @AfterClass
//    protected static void waitUntilPageIsLoaded(){
//        $(byText("Loading")).shouldBe(visible); //will be used default timeout from config (4000)
//        //or
//        $(byText("Loading")).waitUntil(disappears, 20000); //will be used inputed timeout (20000)
//    }
//    // For custom matchers
////    private static Condition css(String name, final String value) {
////        return new Condition("css") {
////
////            public boolean apply(WebElement element) {
////                return value.equals(element.getCssValue(name));
////            }
////        };
////    }
//
//
//}
//*/
