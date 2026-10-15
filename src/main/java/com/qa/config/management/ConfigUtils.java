package com.qa.config.management;

import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

public class ConfigUtils {

  private Map<String, String> configMap = new ConcurrentHashMap<>();

  public ConfigUtils() {
    this.configMap = new ConcurrentHashMap<>();
  }

  public String getConfig(String key) {
    return configMap.get(key);
  }

  public void setConfig(String key, String value) {
    configMap.put(key, value);
  }

  public void printConfigs() {
    configMap.forEach((key, value) -> System.out.println(key + ": " + value));
  }

  public Map<String, String> getAll() {
    return new ConcurrentHashMap<>(configMap);
  }

  void loadFromProperties(Properties props) {
    props.forEach((key, value) -> configMap.put(key.toString(), value.toString()));
  }

}
