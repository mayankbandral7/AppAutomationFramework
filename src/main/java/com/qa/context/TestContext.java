package com.qa.context;

import com.qa.actions.facade.ActionsFacade;
import io.appium.java_client.AppiumDriver;

public record TestContext(AppiumDriver appiumDriver, ActionsFacade actionsFacade) {

}
