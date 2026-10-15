package com.qa.appium.configuration;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class LTServerInitializer implements AppiumServerInitializer {

  @Override
  public URL initialiseAppiumServer() {
    try {
      return URI.create("https://lambdatest.com:fdfd/").toURL();
    } catch (MalformedURLException e) {
      throw new RuntimeException(e);
    }

  }
}
