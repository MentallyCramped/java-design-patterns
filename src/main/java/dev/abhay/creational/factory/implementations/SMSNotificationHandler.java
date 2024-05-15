package dev.abhay.creational.factory.implementations;

import dev.abhay.creational.factory.NotificationHandler;
import dev.abhay.creational.factory.User;
import dev.abhay.creational.factory.externalservices.SMSService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SMSNotificationHandler implements NotificationHandler {

  private SMSService smsService;

  @Override
  public void handleNotification(User user, String message) {
    smsService.sendSMS(user.getPhoneNumber(), message);
  }
}
