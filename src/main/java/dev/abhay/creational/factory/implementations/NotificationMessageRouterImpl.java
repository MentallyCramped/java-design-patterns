package dev.abhay.creational.factory.implementations;

import dev.abhay.creational.factory.NotificationHandler;
import dev.abhay.creational.factory.NotificationHandlerFactory;
import dev.abhay.creational.factory.NotificationMessageRouter;
import dev.abhay.creational.factory.NotificationType;
import dev.abhay.creational.factory.User;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class NotificationMessageRouterImpl implements NotificationMessageRouter {

  private NotificationHandlerFactory notificationHandlerFactory;

  @Override
  public void routeMessage(User user, String message, NotificationType notificationType)
      throws RuntimeException {
    NotificationHandler notificationHandler = notificationHandlerFactory.getNotificationHandler(
        notificationType);

    if (notificationHandler != null) {
      notificationHandler.handleNotification(user, message);
    } else {
      throw new RuntimeException("Notification type not supported");
    }
  }
}
