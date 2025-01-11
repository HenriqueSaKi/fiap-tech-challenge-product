package br.com.fiap.tech_challenge.product.adapters.controller.model.mock;

import br.com.fiap.tech_challenge.product.adapters.driver.controller.model.enums.CategoriaProduto;
import br.com.fiap.tech_challenge.product.adapters.driver.controller.model.request.AtualizarProdutoDTO;

import java.math.BigDecimal;

public class AtualizarProdutoDTOMock {

  public static AtualizarProdutoDTO getAtualizarProduto() {
    AtualizarProdutoDTO atualizarProdutoDTO = new AtualizarProdutoDTO();
    atualizarProdutoDTO.setProdutoId(1L);
    atualizarProdutoDTO.setCategoria(CategoriaProduto.LANCHE);
    atualizarProdutoDTO.setNome("Nome Teste");
    atualizarProdutoDTO.setDescricao("Descrição teste");
    atualizarProdutoDTO.setPreco(BigDecimal.valueOf(20.0));
    return atualizarProdutoDTO;
  }

}
