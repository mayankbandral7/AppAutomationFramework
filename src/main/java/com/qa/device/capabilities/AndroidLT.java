package com.qa.device.capabilities;

import io.appium.java_client.android.options.UiAutomator2Options;

public class AndroidLT implements DeviceCapabilities<UiAutomator2Options> {

  @Override
  public UiAutomator2Options init() {
    UiAutomator2Options options = new UiAutomator2Options();
    options.setCapability("platformName", "Android");
    options.setCapability("platformVersion", "8.0");
    options.setCapability("deviceName", "Android");

    return options;
  }
}
