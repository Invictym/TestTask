package com.google.tests;

import com.google.forms.*;
import framework.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Calendar;

public class GoogleTest extends BaseTest {

    @Test
    public void testing()  {

        System.out.println("-==Step 1 : Open page==-");

        GoogleMainForm googleMainForm = new GoogleMainForm();

        System.out.println("-==Step 2 : Open gmail==-");

        googleMainForm.openGMail();

        System.out.println("-==Step 3 : Login gmail==-");

        GmailInitForm gmailInitForm = new GmailInitForm();
        gmailInitForm.loginGmail(parameters.get("login"), parameters.get("password"));

        System.out.println("-==Step 4 : Write mail==-");

        GmailInputMailForm gmailInputMailForm = new GmailInputMailForm();
        gmailInputMailForm.opneWriteMailDialog();

        WriteMailForm writeMailForm = new WriteMailForm();
        writeMailForm.sendMail(parameters.get("login"), parameters.get("text"));

        System.out.println("-==Step 5 : Open mail==-");

        gmailInputMailForm.gmailMenu.clickItme(GmailMenu.MenuItem.INPUT);

        Calendar calendar = Calendar.getInstance();

        gmailInputMailForm.openMailFromUserAfterTime(parameters.get("login"), calendar.get(Calendar.HOUR_OF_DAY)*100 + calendar.get(Calendar.MINUTE));

        System.out.println("-==Step 6 : Check mail for text==-");

        GmailMailForm gmailMailForm = new GmailMailForm();
        Assert.assertEquals(gmailMailForm.getMailText(), parameters.get("text"));
    }
}
