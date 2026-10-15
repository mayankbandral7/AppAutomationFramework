package com.qa.config.management;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

  public void load(ConfigUtils appProperties, String fileName) throws IOException {
    try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName)) {
      if (inputStream == null) {
        throw new IOException("Properties file not found: " + fileName);
      }
      Properties props = new Properties();
      props.load(inputStream);
      appProperties.loadFromProperties(props);
      System.out.println("Properties loaded successfully from: " + fileName);
    }
  }
}
