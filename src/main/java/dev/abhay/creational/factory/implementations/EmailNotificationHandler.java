package dev.abhay.creational.factory.implementations;

import dev.abhay.creational.factory.NotificationHandler;
import dev.abhay.creational.factory.User;
import dev.abhay.creational.factory.externalservices.EmailService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EmailNotificationHandler implements NotificationHandler {

  private EmailService emailService;

  @Override
  public void handleNotification(User user, String message) {
    emailService.sendEmail(user.getEmail(), message);
  }
}
