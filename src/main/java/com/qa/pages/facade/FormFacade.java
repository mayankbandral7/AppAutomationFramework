package com.qa.pages.facade;

import com.qa.context.TestContext;
import com.qa.pages.android.FormComponents;


public class FormFacade {

  private final FormComponents formComponents;

  public FormFacade(TestContext ctx) {
    this.formComponents = new FormComponents(ctx.actionsFacade());
  }

  public void enterTextAndClickOnActiveButton(String text) {
    formComponents.openFormScreen();
    formComponents.enterTextInMainInput(text);
    formComponents.enterActiveButton();
  }
}
