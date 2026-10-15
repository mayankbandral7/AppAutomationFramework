package com.qa.actions.facade;

import com.qa.actions.base.BaseActions;
import com.qa.actions.platform.interfaces.IMobileActions;
import com.qa.enums.Platform;
import com.qa.factory.ActionFactory;
import io.appium.java_client.AppiumDriver;

public class ActionsFacade extends BaseActions {

  private final IMobileActions mobileActions;

  private ActionsFacade(IMobileActions actions, AppiumDriver driver) {
    super(driver);
    this.mobileActions = actions;
  }

  public static ActionsFacade create(Platform platform, AppiumDriver driver) {
    IMobileActions actions = ActionFactory.getAction(platform, driver);
    return new ActionsFacade(actions, driver);
  }

  public void openApp() {
    mobileActions.openApp();
  }

  public void closeApp() {
    mobileActions.closeApp();
  }

  public void hideKeyboard() {
    mobileActions.hideKeyboard();
  }

  public Boolean isKeyboardShown() {
    return mobileActions.isKeyboardShown();
  }

  public String appPackageBundleId() {
    return mobileActions.getAppPackageBundleId();
  }

  public <T> T as(Class<T> extensionType) {
    if (extensionType.isInstance(mobileActions)) {
      return extensionType.cast(mobileActions);
    }
    throw new UnsupportedOperationException(
        "The current platform driver does not support the extension: "
            + extensionType.getSimpleName());
  }

}
