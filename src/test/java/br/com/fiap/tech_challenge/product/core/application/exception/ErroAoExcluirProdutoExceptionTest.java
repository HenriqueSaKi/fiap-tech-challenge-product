package br.com.fiap.tech_challenge.product.core.application.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ErroAoExcluirProdutoExceptionTest {

  @Test
  public void testException() {
    Exception exception = assertThrows(ErroAoExcluirProdutoException.class,
        () -> { throw new ErroAoExcluirProdutoException("Teste"); });

    assertInstanceOf(RuntimeException.class, exception);
    assertEquals("Teste", exception.getMessage());
  }

}
