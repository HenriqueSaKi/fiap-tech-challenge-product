package br.com.fiap.tech_challenge.product.adapters.controller.exception;

import br.com.fiap.tech_challenge.product.adapters.driver.controller.exception.ProdutoControllerExceptionHandler;
import br.com.fiap.tech_challenge.product.core.application.exception.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ProdutoControllerExceptionHandlerTest {

  private ProdutoControllerExceptionHandler exceptionHandler;

  @BeforeEach
  public void setUp() {
    exceptionHandler = new ProdutoControllerExceptionHandler();
  }

  @Test
  public void testProdutoJaCadastradoException() {
    final String mensagem = "Produto já cadastrado exception";
    ResponseEntity<String> response = exceptionHandler.produtoJaCadastradoException(
        new ProdutoJaCadastradoException(mensagem));

    assertNotNull(mensagem);
    assertEquals(mensagem, response.getBody());
    assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());

  }

  @Test
  public void testErroAoCadastrarProdutoException() {
    final String mensagem = "Erro ao cadastrar produto exception";
    ResponseEntity<String> response = exceptionHandler.erroAoCadastrarProdutoException(
        new ErroAoCadastrarProdutoException(mensagem));

    assertNotNull(mensagem);
    assertEquals(mensagem, response.getBody());
    assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());

  }

  @Test
  public void testNenhumProdutoEncontradoException() {
    final String mensagem = "Nenhum produto encontrado exception";
    ResponseEntity<String> response = exceptionHandler.nenhumProdutoEncontradoException(
        new NenhumProdutoEncontradoException(mensagem));

    assertNotNull(mensagem);
    assertEquals(mensagem, response.getBody());
    assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());

  }

  @Test
  public void testProdutoNaoEncontradoException() {
    final String mensagem = "Produto não encontrado exception";
    ResponseEntity<String> response = exceptionHandler.produtoNaoEncontradoException(
        new ProdutoNaoEncontradoException(mensagem));

    assertNotNull(mensagem);
    assertEquals(mensagem, response.getBody());
    assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());

  }

  @Test
  public void testErroAoAtualizarProdutoException() {
    final String mensagem = "Erro ao atualizar produto exception";
    ResponseEntity<String> response = exceptionHandler.erroAoAtualizarProdutoException(
        new ErroAoAtualizarProdutoException(mensagem));

    assertNotNull(mensagem);
    assertEquals(mensagem, response.getBody());
    assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());

  }

  @Test
  public void testErroAoExcluirProdutoException() {
    final String mensagem = "Erro ao excluir produto exception";
    ResponseEntity<String> response = exceptionHandler.erroAoExcluirProdutoException(
        new ErroAoExcluirProdutoException(mensagem));

    assertNotNull(mensagem);
    assertEquals(mensagem, response.getBody());
    assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());

  }

}
