package br.com.fiap.tech_challenge.product.adapters.driven.infrastructure.repository.entity.mock;

import br.com.fiap.tech_challenge.product.adapters.driven.infrastructure.repository.entity.ProdutoEntity;
import br.com.fiap.tech_challenge.product.core.domain.model.enums.CategoriaProduto;

import java.math.BigDecimal;

public class ProdutoEntityMock {

  public static ProdutoEntity getProdutoEntity() {
    ProdutoEntity produtoEntity = new ProdutoEntity();
    produtoEntity.setProdutoId(1L);
    produtoEntity.setCategoriaProduto(CategoriaProduto.LANCHE);
    produtoEntity.setNome("Nome Teste");
    produtoEntity.setDescricao("Descrição teste");
    produtoEntity.setPreco(BigDecimal.valueOf(20.0));
    return produtoEntity;
  }

}
