package com.qa.locators;

import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;

/**
 * Builder for creating platform-specific locators with fluent API.
 *
 * Usage:
 * <pre>
 * By locator = LocatorFactory.android(By.id("android_id"))
 *                            .ios(By.accessibilityId("ios_id"));
 * </pre>
 */
@RequiredArgsConstructor
public class LocatorBuilder {

  private final By androidElement;

  public By ios(By iosElement) {
    if (iosElement == null) {
      throw new RuntimeException("iOS locator cannot be null");
    }
    return new LocatorFactory.PlatformBy(androidElement, iosElement);
  }
}
