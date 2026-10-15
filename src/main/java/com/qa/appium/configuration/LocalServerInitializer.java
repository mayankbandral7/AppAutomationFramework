package com.qa.appium.configuration;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class LocalServerInitializer implements AppiumServerInitializer {

  @Override
  public URL initialiseAppiumServer() {
    try {
      return URI.create("http://127.0.0.1:4723/").toURL();
    } catch (MalformedURLException e) {
      throw new RuntimeException(e);
    }
  }
}
