package com.qa.driver.configuration;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.options.BaseOptions;

import java.net.URL;


public interface DriverProvider {
    AppiumDriver getDriver(URL url, BaseOptions<?> baseOptions );
}
