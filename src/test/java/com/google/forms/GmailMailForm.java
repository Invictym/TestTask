package com.google.forms;

import framework.BaseForm;
import framework.ui.Label;
import org.openqa.selenium.By;

public class GmailMailForm extends GmailBaseFrom{

    private final Label lblMailText = new Label(By.xpath("//div[@role='list']//div[contains(@class,'aXjCH')]/div[@dir]"), "Mail text");

    public GmailMailForm() {
        super(By.xpath("//div[@role='list']"), "Mail page");
    }

    public String getMailText() {
        return lblMailText.getText();
    }
}
