package com.google.forms;

import framework.BaseForm;
import framework.ui.Label;
import org.openqa.selenium.By;

public class GoogleMainForm extends BaseForm {

    private final Label lblGMail = new Label(By.xpath("//div[@id='gb']//a[contains(@href, 'mail') and contains(@class, 'gb_P')]"), "Mail label");

    public GoogleMainForm() {
        super(By.id("main"), "Google main page");
    }

    public void openGMail() {
        lblGMail.click();
    }
}
