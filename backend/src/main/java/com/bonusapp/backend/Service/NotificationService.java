package com.bonusapp.backend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    @Autowired
    private JavaMailSender mailSender;

    public void notifierBonus(String email, int bonusAjoute) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(email);
        msg.setSubject("Bonus ajouté");
        msg.setText("Un bonus de " + bonusAjoute + " a été ajouté à votre compte.");
        mailSender.send(msg);
    }
}
