package br.com.fiap.tech_challenge.product.adapters.controller.model.mock;

import br.com.fiap.tech_challenge.product.adapters.driver.controller.model.enums.CategoriaProduto;
import br.com.fiap.tech_challenge.product.adapters.driver.controller.model.request.CadastrarProdutoDTO;

import java.math.BigDecimal;

public class CadastrarProdutoDTOMock {

  public static CadastrarProdutoDTO getCadastrarProduto() {
    CadastrarProdutoDTO cadastrarProdutoDTO = new CadastrarProdutoDTO();
    cadastrarProdutoDTO.setCategoria(CategoriaProduto.LANCHE);
    cadastrarProdutoDTO.setNome("Nome Teste");
    cadastrarProdutoDTO.setDescricao("Descrição teste");
    cadastrarProdutoDTO.setPreco(BigDecimal.valueOf(20.0));
    return cadastrarProdutoDTO;
  }

}
