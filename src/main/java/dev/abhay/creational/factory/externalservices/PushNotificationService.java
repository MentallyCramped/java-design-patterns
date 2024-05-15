package dev.abhay.creational.factory.externalservices;

public interface PushNotificationService {

  void sendPushNotification(String userDeviceId, String message);
}
