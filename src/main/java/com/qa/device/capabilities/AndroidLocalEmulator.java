package com.qa.device.capabilities;

import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import java.nio.file.Path;
import java.time.Duration;
import org.openqa.selenium.Platform;

public class AndroidLocalEmulator implements DeviceCapabilities<UiAutomator2Options> {

  private static final String APP_DIR = "src/test/resources/app";
  private static final Duration CMD_TIMEOUT = Duration.ofSeconds(60);

  @Override
  public UiAutomator2Options init() {
    UiAutomator2Options options = new UiAutomator2Options();
    options.setPlatformName(Platform.ANDROID.name());
    options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
    options.setDeviceName(configUtils.getConfig("android.device.name"));
    options.setPlatformVersion(configUtils.getConfig("android.platform.version"));
    options.setAutoGrantPermissions(true);
    options.setUdid(configUtils.getConfig("android.udid"));
    Path apk = Path.of(System.getProperty("user.dir")).resolve(APP_DIR)
        .resolve(configUtils.getConfig("android.app.path"));
    options.setApp(apk.toString());
    options.setNewCommandTimeout(CMD_TIMEOUT);
    return options;
  }
}
