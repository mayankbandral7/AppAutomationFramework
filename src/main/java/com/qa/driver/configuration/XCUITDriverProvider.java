package com.qa.driver.configuration;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.options.BaseOptions;

import java.net.URL;

public class XCUITDriverProvider implements DriverProvider {

    @Override
    public IOSDriver getDriver(URL url, BaseOptions<?> baseOptions) {
        return new IOSDriver(url, baseOptions);
    }
}
