package br.com.fiap.tech_challenge.product.core.application.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProdutoNaoEncontradoExceptionTest {

  @Test
  public void testException() {
    Exception exception = assertThrows(ProdutoNaoEncontradoException.class,
        () -> { throw new ProdutoNaoEncontradoException("Teste"); });

    assertInstanceOf(RuntimeException.class, exception);
    assertEquals("Teste", exception.getMessage());
  }

}
