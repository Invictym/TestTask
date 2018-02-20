package com.google.forms;

import framework.ui.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.annotation.Nullable;

public class GmailInputMailForm extends GmailBaseFrom{

    private String mailLocator = "//span[@email='%s']/ancestor::tr//td[contains(@class, 'xW')]";

    public GmailInputMailForm() {
        super(By.xpath("//div[contains(@class,'AO')]"),
                "Input mail page");
    }

    public void openMailFromUserAfterTime(String user, final int time) {
        new WebDriverWait(getBrowser().getDriver(), Integer.parseInt(fileWorker.getProperties("timeout")))
        .until(new ExpectedCondition<Boolean>() {
                   @Nullable
                   @Override
                   public Boolean apply(@Nullable WebDriver driver) {
                       return Integer.parseInt(new Label(By.xpath(String.format(mailLocator, user)), user + "mail")
                               .getText()
                               .replace(":", "")) <= time;
                   }
               });
        new Label(By.xpath(String.format(mailLocator, user)), user + " mail").click();
    }
}
