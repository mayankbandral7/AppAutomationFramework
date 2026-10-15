package com.qa.factory;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

import com.qa.device.capabilities.AndroidLT;
import com.qa.device.capabilities.AndroidLocalEmulator;
import com.qa.device.capabilities.DeviceCapabilities;

import com.qa.enums.Platform;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.options.BaseOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class DeviceFactory {

  private static final Map<Boolean, Supplier<? extends DeviceCapabilities<? extends BaseOptions<?>>>> androidDeviceMap = new HashMap<>();
  private static final Map<Platform, Map<Boolean, Supplier<? extends DeviceCapabilities<? extends BaseOptions<?>>>>> deviceMap = new HashMap<>();
  private static final Supplier<AndroidLocalEmulator> androidLocalEmulator = AndroidLocalEmulator::new;
  private static final Supplier<AndroidLT> androidLambdaTest = AndroidLT::new;

  static {
    androidDeviceMap.put(FALSE, androidLocalEmulator);
    androidDeviceMap.put(TRUE, androidLambdaTest);
    deviceMap.put(Platform.ANDROID, androidDeviceMap);
  }

  public static DeviceCapabilities<? extends BaseOptions<?>> getDeviceCapabilities(
      Platform platform,
      Boolean isLambdaTest) {
    return deviceMap.get(platform).get(isLambdaTest).get();
  }

}
