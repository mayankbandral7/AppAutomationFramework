package com.qa.factory;

import com.qa.actions.platform.actions.AndroidActions;
import com.qa.actions.platform.actions.IOSActions;
import com.qa.actions.platform.interfaces.IMobileActions;
import com.qa.enums.Platform;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class ActionFactory {

  private ActionFactory() {
  }

  private static final Map<Platform, Function<AppiumDriver, IMobileActions>> actionsMap = new HashMap<>();

  static {
    actionsMap.put(Platform.ANDROID, driver -> new AndroidActions((AndroidDriver) driver));
    actionsMap.put(Platform.IOS, driver -> new IOSActions((IOSDriver) driver));
  }

  public static IMobileActions getAction(Platform platform, AppiumDriver driver) {
    Function<AppiumDriver, IMobileActions> action = actionsMap.get(platform);
    if (action == null) {
      throw new IllegalArgumentException("Unsupported platform: " + platform);
    }
    return action.apply(driver);
  }
}
