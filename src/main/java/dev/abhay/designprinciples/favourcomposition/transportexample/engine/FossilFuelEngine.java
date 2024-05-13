package dev.abhay.designprinciples.favourcomposition.transportexample.engine;

import lombok.extern.java.Log;

/**
 * Implements the Engine interface to provide a specific mechanism for fossil fuel engines.
 */
@Log
public class FossilFuelEngine implements Engine {

  @Override
  public void turnOn() {
    log.info("Fossil Fuel Engine turned on.");
  }

  @Override
  public void turnOff() {
    log.info("Fossil Fuel Engine turned off.");
  }
}
