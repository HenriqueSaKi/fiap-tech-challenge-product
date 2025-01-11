package br.com.fiap.tech_challenge.product.core.application.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ErroAoCadastrarProdutoExceptionTest {

  @Test
  public void testException() {
    Exception exception = assertThrows(ErroAoCadastrarProdutoException.class,
        () -> { throw new ErroAoCadastrarProdutoException("Teste"); });

    assertInstanceOf(RuntimeException.class, exception);
    assertEquals("Teste", exception.getMessage());
  }

}
