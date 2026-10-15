package com.qa.device.capabilities;

import com.qa.config.management.ConfigManager;
import com.qa.config.management.ConfigUtils;
import io.appium.java_client.remote.options.BaseOptions;

public interface DeviceCapabilities<T extends BaseOptions<T>> {
  ConfigUtils configUtils = ConfigManager.getInstance();
  T init();
}
