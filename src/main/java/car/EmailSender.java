package car;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailSender {
    private EmailSender() {
        // Private constructor to prevent instantiation of the class
    }//dd

    public static void sendEmail(String from, String to, String subject, String messageText) {

        try {
            Properties properties = System.getProperties();
            properties.put("mail.smtp.host", "smtp.gmail.com");
            properties.put("mail.smtp.port", "587");
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.starttls.enable", "true");

            Session session = Session.getDefaultInstance(properties, new Authenticator() {
                        @Override
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication("laith.nnn96@gmail.com", "vstu bpov tzsd qztd");
                        }
                    }
            );

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to, false));
            message.setSubject(subject);
            message.setText(messageText);
            Transport.send(message);

        } catch (MessagingException m) {
            
        }

    }


}
