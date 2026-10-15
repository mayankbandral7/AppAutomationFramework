package com.qa.actions.base;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BaseActions {

  protected final AppiumDriver driver;

  public BaseActions(AppiumDriver driver) {
    this.driver = driver;
  }

  public void click(By locator) {
    driver.findElement(locator).click();
  }

  public void clickClearAndTypeInField(By locator, String text) {
    this.click(locator);
    driver.findElement(locator).clear();
    driver.findElement(locator).sendKeys(text);
  }

}
