package br.com.fiap.tech_challenge.product.core.application.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ErroAoConsultarProdutosPorCategoriaExceptionTest {

  @Test
  public void testException() {
    Exception exception = assertThrows(ErroAoConsultarProdutosPorCategoriaException.class,
        () -> { throw new ErroAoConsultarProdutosPorCategoriaException("Teste"); });

    assertInstanceOf(RuntimeException.class, exception);
    assertEquals("Teste", exception.getMessage());
  }

}
