package dev.abhay.creational.factory;

import java.util.Map;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class NotificationHandlerFactory {

  private Map<NotificationType, NotificationHandler> notificationHandlerConfig;

  public NotificationHandler getNotificationHandler(NotificationType notificationType) {
    return notificationHandlerConfig.get(notificationType);
  }
}
