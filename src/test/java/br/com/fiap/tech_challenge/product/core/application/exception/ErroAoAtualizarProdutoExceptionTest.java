package br.com.fiap.tech_challenge.product.core.application.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ErroAoAtualizarProdutoExceptionTest {

  @Test
  public void testException() {
    Exception exception = assertThrows(ErroAoAtualizarProdutoException.class,
        () -> { throw new ErroAoAtualizarProdutoException("Teste"); });

    assertInstanceOf(RuntimeException.class, exception);
    assertEquals("Teste", exception.getMessage());
  }

}
