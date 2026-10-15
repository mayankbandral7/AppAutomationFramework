package com.qa.base;

import com.qa.actions.facade.ActionsFacade;
import com.qa.appium.configuration.AppiumServerInitializer;
import com.qa.context.TestContext;
import com.qa.device.capabilities.DeviceCapabilities;
import com.qa.driver.configuration.DriverProvider;
import com.qa.enums.Platform;
import com.qa.enums.PlatformContext;
import com.qa.factory.DeviceFactory;
import com.qa.factory.DriverFactory;
import com.qa.factory.ServerFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.options.BaseOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

  protected ThreadLocal<TestContext> testContextThreadLocal = new ThreadLocal<>();

  @BeforeTest()
  public void init() {
    Boolean isLambdaTest = isLambdaTest();
    platformInit();
    Platform platform = PlatformContext.INSTANCE.getPlatform();
    DeviceCapabilities<? extends BaseOptions<?>> deviceCapabilities = DeviceFactory.getDeviceCapabilities(
        platform,
        isLambdaTest);
    AppiumServerInitializer appiumServerInitializer = ServerFactory.getAppiumServerInitialiser(
        isLambdaTest);
    DriverProvider driverInterface = DriverFactory.getDriver(platform);
    AppiumDriver driver = driverInterface.getDriver(
        appiumServerInitializer.initialiseAppiumServer(), deviceCapabilities.init());
    ActionsFacade actionsFacade = ActionsFacade.create(platform, driver);
    testContextThreadLocal.set(new TestContext(driver, actionsFacade));
    System.out.println("Appium Driver initialized successfully.");
  }

  @AfterTest
  public void tearDown() {
    if (getAppiumDriver() != null) {
      getAppiumDriver().quit();
    }
    testContextThreadLocal.remove();
  }

  private void platformInit() {
    String platform = System.getProperty("platform", "android");
    PlatformContext.INSTANCE.setPlatform(platform);
  }

  private Boolean isLambdaTest() {
    String getLambdaTest = System.getProperty("lambdatest");
    return Boolean.parseBoolean(getLambdaTest);
  }

  private AppiumDriver getAppiumDriver() {
    return getTestContext().appiumDriver();
  }

  public TestContext getTestContext() {
    return testContextThreadLocal.get();
  }

}
