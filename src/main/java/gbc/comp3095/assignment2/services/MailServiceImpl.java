/*
 * Project: Recipe App
 * Assignment: COMP3095 Assignment2
 * Author(s): Arghawan Ghulam Siddiq,  Joyce Ashley Borla
 * Student Number: 101334946, 101190436,
 */
package gbc.comp3095.assignment2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendMail(String email, Long id) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("dustin.justfortesting@gmail.com");
        message.setTo(email);
        message.setSubject("Password Reset Request");
        message.setText(
                "A password reset has been requested for your account. If it wasn't your intention, please ignore this email.\n\n\n" +
                "Otherwise, please follow this link: http://localhost:8090/resetpassword/"+id
        );
        mailSender.send(message);
    }
}
