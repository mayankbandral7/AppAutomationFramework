package com.qa.enums;

public enum PlatformContext {

  INSTANCE;

  private Platform platform;

  public void setPlatform(String platformName) {
    if (this.platform != null) {
      throw new IllegalStateException("Platform already set: " + this.platform);
    }
    this.platform = platformName.equalsIgnoreCase("android") ? Platform.ANDROID
        : Platform.IOS;
  }

  public Platform getPlatform() {
    if (platform == null) {
      throw new IllegalStateException("Platform not initialized");
    }
    return platform;
  }

  public boolean isAndroid() {
    return platform == Platform.ANDROID;
  }

  public boolean isIOS() {
    return platform == Platform.IOS;
  }
}
