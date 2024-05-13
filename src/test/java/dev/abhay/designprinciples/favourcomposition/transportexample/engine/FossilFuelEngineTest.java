package dev.abhay.designprinciples.favourcomposition.transportexample.engine;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Tests for the FossilFuelEngine class.
 */
class FossilFuelEngineTest {

  @Test
  @DisplayName("Test to ensure that the fossil fuel engine can turn on")
  void testTurnOn() {
    FossilFuelEngine engine = mock(FossilFuelEngine.class);
    doNothing().when(engine).turnOn();

    engine.turnOn();
    verify(engine, times(1)).turnOn();
  }

  @Test
  @DisplayName("Test to ensure that the fossil fuel engine can turn off")
  void testTurnOff() {
    FossilFuelEngine engine = mock(FossilFuelEngine.class);
    doNothing().when(engine).turnOff();

    engine.turnOff();
    verify(engine, times(1)).turnOff();
  }
}
