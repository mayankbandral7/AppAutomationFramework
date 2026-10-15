package com.qa.actions.platform.actions;

import com.google.common.collect.ImmutableMap;
import com.qa.actions.platform.interfaces.IAndroidExtension;
import com.qa.actions.platform.interfaces.IMobileActions;
import io.appium.java_client.android.AndroidDriver;
import java.util.List;

public class AndroidActions implements IAndroidExtension, IMobileActions {

  private final AndroidDriver driver;

  public AndroidActions(AndroidDriver driver) {
    this.driver = driver;
  }

  @Override
  public void hideKeyboard() {
    if (isKeyboardShown()) {
      driver.hideKeyboard();
    }
  }

  @Override
  public Boolean isKeyboardShown() {
    return driver.isKeyboardShown();
  }

  @Override
  public String getAppPackageBundleId() {
    return driver.getCurrentPackage();
  }

  @Override
  public void closeApp() {
    driver.executeScript("mobile: terminateApp", ImmutableMap.of("appId", getAppPackageBundleId()));
  }

  @Override
  public void openApp() {
    driver.executeScript("mobile: openApp", ImmutableMap.of("appId", getAppPackageBundleId()));

  }

  @Override
  public void startActivity(String appActivity) {
    driver.executeScript("mobile: startActivity", ImmutableMap.of(
        "component", String.format("%s/%s", getAppPackageBundleId(), appActivity)));
  }

  @Override
  public void openNotification() {
    driver.openNotifications();
  }

}
