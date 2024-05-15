package dev.abhay.creational.factory.implementations;

import dev.abhay.creational.factory.NotificationHandler;
import dev.abhay.creational.factory.User;
import dev.abhay.creational.factory.externalservices.PushNotificationService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PushNotificationHandler implements NotificationHandler {

  private PushNotificationService pushNotificationService;

  @Override
  public void handleNotification(User user, String message) {
    pushNotificationService.sendPushNotification(user.getDevice(), message);
  }
}
