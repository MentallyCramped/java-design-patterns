package dev.abhay.designprinciples.favourcomposition.transportexample.engine;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import dev.abhay.designprinciples.favourcomposition.transportexample.engine.implementations.ElectricEngine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Tests for the ElectricEngine class.
 */
class ElectricEngineTest {

  @Test
  @DisplayName("Test to ensure that the electric engine can turn on")
  void testTurnOn() {
    ElectricEngine engine = mock(ElectricEngine.class);
    doNothing().when(engine).turnOn();

    engine.turnOn();
    verify(engine, times(1)).turnOn();
  }

  @Test
  @DisplayName("Test to ensure that the electric engine can turn off")
  void testTurnOff() {
    ElectricEngine engine = mock(ElectricEngine.class);
    doNothing().when(engine).turnOff();

    engine.turnOff();
    verify(engine, times(1)).turnOff();
  }
}
