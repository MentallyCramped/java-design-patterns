package dev.abhay.creational.factory.externalservices;

public interface SMSService {

  void sendSMS(String userPhone, String message);
}
