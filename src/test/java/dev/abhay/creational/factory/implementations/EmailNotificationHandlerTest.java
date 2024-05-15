package dev.abhay.creational.factory.implementations;

import dev.abhay.creational.factory.User;
import dev.abhay.creational.factory.externalservices.EmailService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class EmailNotificationHandlerTest {

  EmailService mockEmailService;
  private User mockUser;
  private EmailNotificationHandler emailNotificationHandlerUnderTest;
  private final String MOCK_EMAIL = "mockEmail@mock.com";
  private final String MOCK_NAME = "mockName";
  private final String MOCK_DEVICE = "mockDevice";
  private final String MOCK_PHONE = "mockPhone";

  @BeforeEach
  public void setup() {
    mockEmailService = Mockito.mock(EmailService.class);
    emailNotificationHandlerUnderTest = new EmailNotificationHandler(mockEmailService);
    mockUser = User.builder()
        .email(MOCK_EMAIL)
        .device(MOCK_DEVICE)
        .name(MOCK_NAME)
        .phoneNumber(MOCK_PHONE)
        .build();
  }

  @Test
  @DisplayName("Test if the email notification gets sent")
  void handleEmailNotification() {
    String mockMessage = "Mock email message";
    emailNotificationHandlerUnderTest.handleNotification(mockUser, mockMessage);

    Mockito.verify(mockEmailService).sendEmail(mockUser.getEmail(), mockMessage);
  }
}