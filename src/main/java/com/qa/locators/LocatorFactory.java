package com.qa.locators;

import com.qa.enums.Platform;
import com.qa.enums.PlatformContext;
import java.io.Serializable;
import java.util.List;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jspecify.annotations.NonNull;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

/**
 * Stateless factory for creating platform-aware locators. Provides static factory methods to build
 * locators that resolve at runtime.
 * <p>
 * Design Pattern: Factory + Builder + Strategy
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class LocatorFactory {

  /**
   * Starts building platform-specific locator with Android first.
   *
   * @param androidElement Android platform locator
   * @return Builder to chain iOS locator
   * @throws RuntimeException if androidElement is null
   * <pre>
   * By locator = LocatorFactory.android(By.id("android_id"))
   *                            .ios(By.accessibilityId("ios_id"));
   * </pre>
   */
  public static LocatorBuilder android(By androidElement) {
    if (androidElement == null) {
      throw new RuntimeException("Android locator cannot be null");
    }
    return new LocatorBuilder(androidElement);
  }

  /**
   * Creates platform-specific locator from By objects.
   *
   * @param androidElement Android By locator
   * @param iosElement     iOS By locator
   * @return Platform-aware By object
   */
  public static By getBy(By androidElement, By iosElement) {
    if (androidElement == null || iosElement == null) {
      throw new RuntimeException("Locators cannot be null");
    }
    return new PlatformBy(androidElement, iosElement);
  }

  /**
   * Creates common locator that works on both platforms.
   *
   * @param commonElement Common By locator
   * @return Platform-aware By object
   */
  public static By common(By commonElement) {
    if (commonElement == null) {
      throw new RuntimeException("Common locator cannot be null");
    }
    return new PlatformBy(commonElement, commonElement);
  }

  /**
   * Creates platform-specific ID locator.
   *
   * @param androidId Android resource-id
   * @param iosId     iOS accessibility id
   * @return Platform-aware By object
   */
  public static By id(String androidId, String iosId) {
    validateNotEmpty(androidId, iosId, "IDs");
    return new PlatformBy(By.id(androidId), By.id(iosId));
  }

  public static By xpath(String androidXpath, String iosXpath) {
    validateNotEmpty(androidXpath, iosXpath, "XPaths");
    return new PlatformBy(By.xpath(androidXpath), By.xpath(iosXpath));
  }

  // ===== Validation Helper =====

  private static void validateNotEmpty(String android, String ios, String type) {
    if (android == null || android.isEmpty() || ios == null || ios.isEmpty()) {
      throw new RuntimeException(type + " cannot be null or empty");
    }
  }

  /**
   * Internal wrapper that resolves platform at runtime. Defers locator selection until
   * findElements() is called.
   */
  static class PlatformBy extends By implements Serializable {

    private static final long serialVersionUID = 1L;

    private final By androidElement;
    private final By iosElement;

    PlatformBy(By androidElement, By iosElement) {
      this.androidElement = androidElement;
      this.iosElement = iosElement;
    }

    @Override
    public List<WebElement> findElements(@NonNull SearchContext context) {
      By locator = resolveLocator();
      return locator.findElements(context);
    }

    private By resolveLocator() {
      Platform platform = PlatformContext.INSTANCE.getPlatform();
      return switch (platform) {
        case ANDROID -> androidElement;
        case IOS -> iosElement;
        default -> throw new RuntimeException("Unsupported platform: " + platform);
      };
    }


    @Override
    public String toString() {
      return String.format("PlatformBy(Android=%s, iOS=%s)", androidElement, iosElement);
    }
  }
}
