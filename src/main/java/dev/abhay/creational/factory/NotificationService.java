package dev.abhay.creational.factory;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class NotificationService {

  private NotificationMessageRouter notificationMessageRouter;

  public void sendNotification(User user, String message, NotificationType notificationType) {
    notificationMessageRouter.routeMessage(user, message, notificationType);
  }
}
