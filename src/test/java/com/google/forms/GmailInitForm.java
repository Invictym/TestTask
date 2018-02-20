package com.google.forms;

import framework.BaseForm;
import framework.ui.Button;
import framework.ui.TextBox;
import org.openqa.selenium.By;

public class GmailInitForm extends BaseForm {

    private final TextBox tbxLogin = new TextBox(By.id("identifierId"), "Login");
    private final TextBox tbxPassword = new TextBox(By.xpath("//div[@id='password']//input"), "Password");
    private final Button btnNext = new Button(By.id("identifierNext"), "Go next button");
    private final Button btnPasswordNext = new Button(By.id("passwordNext"), "Login button");

    public GmailInitForm() {
        super(By.id("initialView"), "Gmail initialization from");
    }

    public void loginGmail(String indetificator, String password) {
        tbxLogin.sendKey(indetificator);
        btnNext.click();
        tbxPassword.sendKey(password);
        btnPasswordNext.clickViaJS();
    }
}
