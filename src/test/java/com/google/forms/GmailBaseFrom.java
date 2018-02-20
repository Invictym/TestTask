package com.google.forms;

import framework.BaseForm;
import framework.ui.Button;
import org.openqa.selenium.By;

class GmailBaseFrom extends BaseForm {

    public final GmailMenu gmailMenu = new GmailMenu();

    private final Button btnWriteMail = new Button(By.xpath("//div[contains(@class,'aj9')]//div[@role='button']"), "Write mail button");

    public GmailBaseFrom(By formLocator, String formTitle) {
        super(formLocator, formTitle);
    }

    public void opneWriteMailDialog() {
        btnWriteMail.click();
    }


}
