package dev.abhay.designprinciples.favourcomposition.transportexample.engine;

import lombok.extern.java.Log;

/**
 * Implements the Engine interface to provide a specific mechanism for electric engines.
 */
@Log
public class ElectricEngine implements Engine {

  @Override
  public void turnOn() {
    log.info("Electric Engine turned on.");
  }

  @Override
  public void turnOff() {
    log.info("Electric Engine turned off.");
  }
}
