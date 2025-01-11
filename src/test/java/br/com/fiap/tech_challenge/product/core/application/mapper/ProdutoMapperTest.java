package br.com.fiap.tech_challenge.product.core.application.mapper;

import br.com.fiap.tech_challenge.product.adapters.driven.infrastructure.repository.entity.ProdutoEntity;
import br.com.fiap.tech_challenge.product.adapters.driven.infrastructure.repository.entity.mock.ProdutoEntityMock;
import br.com.fiap.tech_challenge.product.core.domain.model.Produto;
import br.com.fiap.tech_challenge.product.core.domain.model.mock.ProdutoMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ProdutoMapperTest {

  private ProdutoMapper mapper;

  @BeforeEach
  public void setUp() {
    mapper = new ProdutoMapperImpl();
  }

  @Test
  public void testProdutoEntityToProdutoDto() {
    Produto produto = mapper.toDTO(ProdutoEntityMock.getProdutoEntity());
    assertNotNull(produto);
  }

  @Test
  public void testProdutoEntityToProdutoDto_whenProdutoEntityIsNull() {
    Produto produto = mapper.toDTO(null);
    assertNull(produto);
  }

  @Test
  public void testProdutoDtoToProdutoEntity() {
    ProdutoEntity produtoEntity = mapper.toEntity(ProdutoMock.getProduto());
    assertNotNull(produtoEntity);
  }

  @Test
  public void testProdutoDtoToProdutoEntity_whenProdutoDtoIsNull() {
    ProdutoEntity produtoEntity = mapper.toEntity(null);
    assertNull(produtoEntity);
  }

}
