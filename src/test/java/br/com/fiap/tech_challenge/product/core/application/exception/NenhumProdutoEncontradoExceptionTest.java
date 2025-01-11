package br.com.fiap.tech_challenge.product.core.application.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NenhumProdutoEncontradoExceptionTest {

  @Test
  public void testException() {
    Exception exception = assertThrows(NenhumProdutoEncontradoException.class,
        () -> { throw new NenhumProdutoEncontradoException("Teste"); });

    assertInstanceOf(RuntimeException.class, exception);
    assertEquals("Teste", exception.getMessage());
  }

}
