package com.qa.actions.platform.actions;

import com.google.common.collect.ImmutableMap;
import com.qa.actions.platform.interfaces.IMobileActions;
import io.appium.java_client.ios.IOSDriver;

import java.util.Map;

public class IOSActions implements IMobileActions {

  private final IOSDriver iosDriver;

  public IOSActions(IOSDriver iosDriver) {
    this.iosDriver = iosDriver;
  }

  @Override
  public String getAppPackageBundleId() {
    @SuppressWarnings("unchecked") Map<String, Object> activeAppInfo = (Map<String, Object>) iosDriver.executeScript(
        "mobile: activeAppInfo");
    assert activeAppInfo != null;
    return (String) activeAppInfo.get("bundleId");
  }

  @Override
  public void closeApp() {
    iosDriver.executeScript("mobile: terminateApp",
        ImmutableMap.of("bundleId", getAppPackageBundleId()));
  }

  @Override
  public void openApp() {
    iosDriver.executeScript("mobile: activateApp",
        ImmutableMap.of("bundleId", getAppPackageBundleId()));
  }

  @Override
  public void hideKeyboard() {
    if (isKeyboardShown()) {
      iosDriver.hideKeyboard();
    }
  }

  @Override
  public Boolean isKeyboardShown() {
    return iosDriver.isKeyboardShown();
  }

}
