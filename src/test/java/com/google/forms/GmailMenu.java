package com.google.forms;

import framework.BaseForm;
import framework.ui.Label;
import org.openqa.selenium.By;

public class GmailMenu extends BaseForm {

    private final String menuLocator = "//div[contains(@class,'byl')]//a[contains(text(),'%s')]";

    public enum MenuItem {
        INPUT("Входящие");

        private String name;

        public String getName() {
            return name;
        }

        MenuItem(String name){
            this.name = name;
        }
    }

    public GmailMenu() {
        super(By.xpath("//div[contains(@class,'byl')]"),"Gmail menu");
    }

    public void clickItme(MenuItem item) {
        new Label(By.xpath(String.format(menuLocator, item.getName())), item.getName()).click();
    }
}
