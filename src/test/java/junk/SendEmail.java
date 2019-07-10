package junk;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.testng.annotations.Test;

public class SendEmail {

    @Test
    public void sendEmail() throws EmailException {
        Email email = new SimpleEmail(); // Create Object
        email.setHostName("smtp.googlemail.com"); // Set SMTP hostname
        email.setSmtpPort(465); // Set port
        email.setAuthenticator(new DefaultAuthenticator("ivanova.marichka@gmail.com", "qwe1rty2")); // Set email/password
        email.setSSLOnConnect(true); // SSL true
        email.setFrom("ivanova.marichka@gmail.com"); // set FROM
        email.setSubject("TestMail"); // set Subject
        email.setMsg("This is a test mail ... :-)"); // Set message
        email.addTo("ivanova.marichka+4@gmail.com"); // Set recipients
        email.send();
    }

    //https://myaccount.google.com/lesssecureapps настрйоки > Pop/IMAP ВРУБИТЬ ВСЬО

}
