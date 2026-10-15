package com.qa.config.management;

public class ConfigManager {

  private static final ConfigUtils instance;

  private ConfigManager() {
  }

  static {
    instance = new ConfigUtils();
    ConfigReader loader = new ConfigReader();

    try {
      String fileName = "configs/app-config.properties";
      loader.load(instance, fileName);
    } catch (Exception e) {
      throw new ExceptionInInitializerError("Failed to initialize properties: " + e.getMessage());
    }
  }

  public static ConfigUtils getInstance() {
    return instance;
  }
}
