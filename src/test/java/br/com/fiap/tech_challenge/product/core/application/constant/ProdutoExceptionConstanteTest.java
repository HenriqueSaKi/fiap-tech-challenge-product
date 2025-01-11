package br.com.fiap.tech_challenge.product.core.application.constant;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProdutoExceptionConstanteTest {

  @Test
  public void testProdutoNaoEncontradoException() {
    assertEquals("Não foi encontrado nenhum resultado para essa pesquisa.",
        ProdutoExceptionConstante.PRODUTO_NAO_ENCONTRADO_EXCEPTION);
  }

  @Test
  public void testErroAoConsultarPorCategoriaException() {
    assertEquals("Ocorreu um erro inesperado ao consultar os produtos dessa categoria.",
        ProdutoExceptionConstante.ERRO_AO_CONSULTAR_POR_CATEGORIA_EXCEPTION);
  }

  @Test
  public void testErroAoConsultarProdutoPorIdException() {
    assertEquals("Não foram encontrados resultados para a consulta. Produto Id:",
        ProdutoExceptionConstante.ERRO_AO_CONSULTAR_PRODUTO_POR_ID_EXCEPTION);
  }

  @Test
  public void testErroAoCadastrarProdutoException() {
    assertEquals("Ocorreu um erro inesperado na hora de cadastrar o produto.",
        ProdutoExceptionConstante.ERRO_AO_CADASTRAR_PRODUTO_EXCEPTION);
  }

  @Test
  public void testErroAoAtualizarProdutoException() {
    assertEquals("Erro ao atualizar as informações do produto.",
        ProdutoExceptionConstante.ERRO_AO_ATUALIZAR_PRODUTO_EXCEPTION);
  }

  @Test
  public void testErroAoExcluirProdutoException() {
    assertEquals("Ocorreu um erro inesperado durante a exclusão do produto.",
        ProdutoExceptionConstante.ERRO_AO_EXCLUIR_PRODUTO_EXCEPTION);
  }

}
