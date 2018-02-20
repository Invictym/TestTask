package com.google.forms;

import framework.BaseForm;
import framework.ui.Button;
import framework.ui.TextBox;
import org.openqa.selenium.By;

public class WriteMailForm extends BaseForm {

    private final TextBox tbxReceiver = new TextBox(By.xpath("//div[@role='dialog']//textarea[@name='to']"), "Receiver text box");
    private final TextBox tbxMailText = new TextBox(By.xpath("//div[@role='dialog']//div[@role='textbox']"), "Mail text box");
    private final Button btnSendMail = new Button(By.xpath("//div[@role='dialog']//div[contains(text(), 'Отправить')]"), "Send mail button");

    public WriteMailForm() {
        super(By.xpath("//div[@role='dialog']"), "Write mail form");
    }

    public void sendMail(String receiver, String text) {
        tbxReceiver.sendKey(receiver);
        tbxMailText.sendKey(text);
        btnSendMail.click();
    }


}
