package dev.abhay.designprinciples.favourcomposition.transportexample;

import dev.abhay.designprinciples.favourcomposition.transportexample.engine.Engine;
import lombok.AllArgsConstructor;

/**
 * Represents a transport mechanism that utilizes an engine.
 * This class demonstrates the use of composition over inheritance by incorporating an Engine object.
 */
@AllArgsConstructor
public class Transport {

  private Engine engine;

  public void start() {
    engine.turnOn();
  }

  public void stop() {
    engine.turnOff();
  }
}
