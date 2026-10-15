package com.qa.driver.configuration;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.options.BaseOptions;

import java.net.URL;

public class AndroidDriverProvider implements DriverProvider {

    @Override
    public AppiumDriver getDriver(URL url, BaseOptions<?> baseOptions) {
        return new AndroidDriver(url, baseOptions);
    }
}
