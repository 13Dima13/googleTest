package org.selenide.examples.App;

import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Configuration.*;

public class BrowserConfiguration {
    public static void setUpLocale() {
        driverManagerEnabled = true; //Always will be latest browser version
        fileDownload = Configuration.FileDownloadMode.PROXY; //need for download files, but does not work for remote working
        baseUrl = "";
        startMaximized = true;
        fastSetValue = true;
        browser = "chrome";
        System.out.println("Setup for Locale was successful");
    }}
