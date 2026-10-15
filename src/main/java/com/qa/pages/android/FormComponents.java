package com.qa.pages.android;

import com.qa.actions.facade.ActionsFacade;
import com.qa.locators.LocatorFactory;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class FormComponents {
//AppiumBy.accessibilityId("Forms");
  private final By formsButton = LocatorFactory.android(AppiumBy.accessibilityId("Forms"))
      .ios(AppiumBy.accessibilityId("Forms"));
  private final By main_input = AppiumBy.accessibilityId("text-input");
  private final By input_text_result = AppiumBy.accessibilityId("input-text-result");
  private final By active_button = AppiumBy.accessibilityId("button-Active");
  private final By ok_button = AppiumBy.id("android:id/button1");

  private final ActionsFacade actions;

  public FormComponents(ActionsFacade actions) {
    this.actions = actions;
  }

  public void openFormScreen() {
    actions.click(formsButton);
  }

  public void enterTextInMainInput(String text) {
    actions.clickClearAndTypeInField(main_input, text);
  }

  public void enterActiveButton() {
    actions.hideKeyboard();
    actions.click(active_button);
    actions.click(ok_button);
  }


}
