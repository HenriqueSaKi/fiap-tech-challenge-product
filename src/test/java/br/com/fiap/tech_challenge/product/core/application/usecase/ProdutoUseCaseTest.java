package br.com.fiap.tech_challenge.product.core.application.usecase;

import br.com.fiap.tech_challenge.product.adapters.controller.model.mock.AtualizarProdutoDTOMock;
import br.com.fiap.tech_challenge.product.adapters.controller.model.mock.CadastrarProdutoDTOMock;
import br.com.fiap.tech_challenge.product.core.application.exception.*;
import br.com.fiap.tech_challenge.product.core.application.ports.gateway.ProdutoGatewayPort;
import br.com.fiap.tech_challenge.product.core.application.usecase.impl.ProdutoUseCaseImpl;
import br.com.fiap.tech_challenge.product.core.domain.model.Produto;
import br.com.fiap.tech_challenge.product.core.domain.model.enums.CategoriaProduto;
import br.com.fiap.tech_challenge.product.core.domain.model.mock.ProdutoMock;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProdutoUseCaseTest {

  @InjectMocks private ProdutoUseCaseImpl useCase;
  @Mock private ProdutoGatewayPort gatewayPort;

  @Test
  public void testCadastrarProduto() {
    when(gatewayPort.save(any())).thenReturn(1L);
    Long produtoId = useCase.cadastrarProduto(CadastrarProdutoDTOMock.getCadastrarProduto());
    assertNotNull(produtoId);
    assertEquals(1L, produtoId);
  }

  @Test
  public void testCadastrarProduto_whenProdutoIsNull() {
    doThrow(RuntimeException.class).when(gatewayPort).save(any());
    assertThrows(ErroAoCadastrarProdutoException.class, () ->
        useCase.cadastrarProduto(null));

  }

  @Test
  public void testBuscarProdutosPorCategoria() {
    when(gatewayPort.findProdutosByCategoria(any())).thenReturn(List.of(ProdutoMock.getProduto()));
    List<Produto> produtos = useCase.buscarProdutosPorCategoria(CategoriaProduto.LANCHE);

    assertNotNull(produtos);
    assertEquals(CategoriaProduto.LANCHE, produtos.get(0).getCategoria());
  }

  @Test
  public void testBuscarProdutosPorCategoria_whenProdutosIsEmpty() {
    when(gatewayPort.findProdutosByCategoria(any())).thenReturn(new ArrayList<>());
    assertThrows(NenhumProdutoEncontradoException.class,
        () -> useCase.buscarProdutosPorCategoria(CategoriaProduto.LANCHE));
  }

  @Test
  public void testBuscarProdutosPorCategoria_whenGatewayMethodThrowException() {
    when(gatewayPort.findProdutosByCategoria(any())).thenThrow(RuntimeException.class);
    assertThrows(ErroAoConsultarProdutosPorCategoriaException.class,
        () -> useCase.buscarProdutosPorCategoria(CategoriaProduto.LANCHE));
  }

  @Test
  public void testAtualizarProduto() {
    when(gatewayPort.findById(any())).thenReturn(ProdutoMock.getProduto());
    when(gatewayPort.save(any())).thenReturn(1L);
    Long produtoId = useCase.atualizarProduto(AtualizarProdutoDTOMock.getAtualizarProduto());

    assertNotNull(produtoId);
    assertEquals(1L, produtoId);
  }

  @Test
  public void testAtualizarProduto_whenProdutoNaoEncontrado() {
    when(gatewayPort.findById(any())).thenReturn(null);
    assertThrows(ProdutoNaoEncontradoException.class,
        () -> useCase.atualizarProduto(AtualizarProdutoDTOMock.getAtualizarProduto()));
  }

  @Test
  public void testAtualizarProduto_whenSaveMethodThrowException() {
    when(gatewayPort.findById(any())).thenReturn(ProdutoMock.getProduto());
    when(gatewayPort.save(any())).thenThrow(RuntimeException.class);
    assertThrows(ErroAoAtualizarProdutoException.class,
        () -> useCase.atualizarProduto(AtualizarProdutoDTOMock.getAtualizarProduto()));
  }

  @Test
  public void testExcluirProduto() {
    when(gatewayPort.findById(any())).thenReturn(ProdutoMock.getProduto());
    useCase.excluirProduto(1L);
  }

  @Test
  public void testExcluirProduto_whenProdutoNaoEncontrado() {
    when(gatewayPort.findById(any())).thenReturn(null);
    assertThrows(ProdutoNaoEncontradoException.class,
        () -> useCase.excluirProduto(1L));
  }

  @Test
  public void testExcluirProduto_whenDeleteByIdMethodThrowException() {
    when(gatewayPort.findById(any())).thenReturn(ProdutoMock.getProduto());
    doThrow(RuntimeException.class).when(gatewayPort).deleteById(any());
    assertThrows(ErroAoExcluirProdutoException.class,
        () -> useCase.excluirProduto(1L));
  }

}
