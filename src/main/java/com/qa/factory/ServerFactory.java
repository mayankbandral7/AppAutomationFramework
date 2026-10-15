package com.qa.factory;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

import com.qa.appium.configuration.AppiumServerInitializer;
import com.qa.appium.configuration.LTServerInitializer;
import com.qa.appium.configuration.LocalServerInitializer;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;

public class ServerFactory {

  private static final Supplier<AppiumServerInitializer> ltServerInitialiser = LTServerInitializer::new;
  private static final Supplier<AppiumServerInitializer> localServerInitialiser = LocalServerInitializer::new;
  private static final Map<Boolean, Supplier<AppiumServerInitializer>> serverMap = new ConcurrentHashMap<>();

  static {
    serverMap.put(TRUE, ltServerInitialiser);
    serverMap.put(FALSE, localServerInitialiser);
  }

  public static AppiumServerInitializer getAppiumServerInitialiser(Boolean isLambdaTest) {
    return serverMap.get(isLambdaTest).get();
  }

}
