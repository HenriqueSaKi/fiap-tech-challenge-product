package br.com.fiap.tech_challenge.product.adapters.driven.infrastructure.gateway;

import br.com.fiap.tech_challenge.product.adapters.driven.infrastructure.repository.ProdutoRepository;
import br.com.fiap.tech_challenge.product.adapters.driven.infrastructure.repository.entity.mock.ProdutoEntityMock;
import br.com.fiap.tech_challenge.product.core.domain.model.Produto;
import br.com.fiap.tech_challenge.product.core.domain.model.enums.CategoriaProduto;
import br.com.fiap.tech_challenge.product.core.domain.model.mock.ProdutoMock;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProdutoGatewayTest {

  @Mock private ProdutoRepository repository;
  @InjectMocks private ProdutoGateway gateway;

  @Test
  public void testDeleteById() {
    gateway.deleteById(any());
    verify(repository, times(1)).deleteById(any());
  }

  @Test
  public void testSave() {
    Produto produto = ProdutoMock.getProduto();

    when(repository.save(any())).thenReturn(ProdutoEntityMock.getProdutoEntity());
    assertEquals(1L, gateway.save(produto));
    verify(repository, times(1)).save(any());
  }

  @Test
  public void testFindById() {
    when(repository.findById(any())).thenReturn(Optional.of(ProdutoEntityMock.getProdutoEntity()));
    Produto produto = gateway.findById(1L);
    assertNotNull(produto);
  }

  @Test
  public void testFindByIdWhenProductDoesntExists() {
    Produto produto = gateway.findById(1L);
    assertNull(produto);
  }

  @Test
  public void testFindProdutosByCategoria() {
    when(repository.findAllByCategoriaProduto(any())).thenReturn(List.of(ProdutoEntityMock.getProdutoEntity()));
    List<Produto> produtos = gateway.findProdutosByCategoria(CategoriaProduto.LANCHE);
    assertNotNull(produtos);
    assertEquals(1, produtos.size());
  }

  @Test
  public void testFindProdutosByCategoriaWhenItDoesntExists() {
    List<Produto> produtos = gateway.findProdutosByCategoria(CategoriaProduto.LANCHE);
    assertEquals(0, produtos.size());
  }

}
