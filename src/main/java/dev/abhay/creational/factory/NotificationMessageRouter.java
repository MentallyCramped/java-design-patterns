package dev.abhay.creational.factory;

public interface NotificationMessageRouter {

  void routeMessage(User user, String message, NotificationType notificationType)
      throws RuntimeException;
}
