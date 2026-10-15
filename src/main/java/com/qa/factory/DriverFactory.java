package com.qa.factory;

import com.qa.driver.configuration.AndroidDriverProvider;
import com.qa.driver.configuration.DriverProvider;
import com.qa.driver.configuration.XCUITDriverProvider;

import com.qa.enums.Platform;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class DriverFactory {

  private static final Supplier<DriverProvider> getAndroidDriver = AndroidDriverProvider::new;
  private static final Supplier<DriverProvider> getIOSDriver = XCUITDriverProvider::new;
  private static final Map<Platform, Supplier<DriverProvider>> getDriversMap = new HashMap<>();

  static {
    getDriversMap.put(Platform.ANDROID, getAndroidDriver);
    getDriversMap.put(Platform.IOS, getIOSDriver);
  }

  public static DriverProvider getDriver(Platform platform) {
    return getDriversMap.get(platform).get();
  }

}
