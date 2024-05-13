package dev.abhay.designprinciples.favourcomposition.transportexample;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import dev.abhay.designprinciples.favourcomposition.transportexample.engine.Engine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Tests for the Transport class to verify its interaction with the Engine.
 */
class TransportTest {

  @Test
  @DisplayName("Test to verify that the transport can start using its engine")
  void testStart() {
    Engine engine = mock(Engine.class);
    Transport transport = new Transport(engine);

    doNothing().when(engine).turnOn();
    transport.start();
    verify(engine, times(1)).turnOn();
  }

  @Test
  @DisplayName("Test to verify that the transport can stop using its engine")
  void testStop() {
    Engine engine = mock(Engine.class);
    Transport transport = new Transport(engine);

    doNothing().when(engine).turnOff();
    transport.stop();
    verify(engine, times(1)).turnOff();
  }
}
