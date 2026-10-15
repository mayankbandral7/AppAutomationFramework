package com.qa.tests;

import com.qa.base.BaseTest;
import com.qa.context.TestContext;
import com.qa.pages.facade.FormFacade;
import org.testng.annotations.Test;

public class FormTests extends BaseTest {

  @Test
  public void testFormsFeature() {
    TestContext ctx = getTestContext();
    FormFacade formFacade = new FormFacade(ctx);
    formFacade.enterTextAndClickOnActiveButton("Mayank");
  }

}
