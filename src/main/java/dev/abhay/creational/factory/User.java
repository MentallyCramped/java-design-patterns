package dev.abhay.creational.factory;

import lombok.Builder;
import lombok.Getter;

/**
 * A generic user class.
 */
@Getter
@Builder
public class User {

  private String name;
  private String email;
  private String device;
  private String phoneNumber;
}
