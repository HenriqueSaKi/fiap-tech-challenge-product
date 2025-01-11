package br.com.fiap.tech_challenge.product.core.domain.model.mock;

import br.com.fiap.tech_challenge.product.core.domain.model.Produto;
import br.com.fiap.tech_challenge.product.core.domain.model.enums.CategoriaProduto;

import java.math.BigDecimal;

public class ProdutoMock {

  public static Produto getProduto() {
    Produto produto = new Produto();
    produto.setProdutoId(1L);
    produto.setCategoria(CategoriaProduto.LANCHE);
    produto.setNome("Nome Teste");
    produto.setDescricao("Descrição teste");
    produto.setPreco(BigDecimal.valueOf(20.0));
    return produto;
  }

}
