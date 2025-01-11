package br.com.fiap.tech_challenge.product.adapters.controller.mapper;

import br.com.fiap.tech_challenge.product.adapters.controller.model.mock.AtualizarProdutoDTOMock;
import br.com.fiap.tech_challenge.product.adapters.controller.model.mock.CadastrarProdutoDTOMock;
import br.com.fiap.tech_challenge.product.adapters.driver.controller.mapper.ProdutoDTOMapper;
import br.com.fiap.tech_challenge.product.adapters.driver.controller.mapper.ProdutoDTOMapperImpl;
import br.com.fiap.tech_challenge.product.adapters.driver.controller.model.enums.CategoriaProduto;
import br.com.fiap.tech_challenge.product.adapters.driver.controller.model.request.CadastrarProdutoDTO;
import br.com.fiap.tech_challenge.product.core.domain.model.Produto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ProdutoDTOMapperTest {

  private ProdutoDTOMapper mapper;

  @BeforeEach
  public void setUp() {
    mapper = new ProdutoDTOMapperImpl();
  }

  @Test
  public void testCadastrarDtoToProduto() {
    Produto produto = mapper.cadastrarDtoToProduto(CadastrarProdutoDTOMock.getCadastrarProduto());
    assertNotNull(produto);
    assertNull(produto.getProdutoId());
  }

  @Test
  public void testCadastrarDtoToProduto_whenCadatrarProdutoDtoIsNull() {
    Produto produto = mapper.cadastrarDtoToProduto(null);
    assertNull(produto);
  }

  @Test
  public void testCadastrarDtoToProduto_whenCategoriaIsNull() {
    CadastrarProdutoDTO cadastrarProdutoDTO = CadastrarProdutoDTOMock.getCadastrarProduto();
    cadastrarProdutoDTO.setCategoria(null);
    Produto produto = mapper.cadastrarDtoToProduto(cadastrarProdutoDTO);

    assertNotNull(produto);
    assertNull(produto.getCategoria());
  }

  @Test
  public void testCadastrarDtoToProduto_whenCategoriaIsAcompanhamento() {
    CadastrarProdutoDTO cadastrarProdutoDTO = CadastrarProdutoDTOMock.getCadastrarProduto();
    cadastrarProdutoDTO.setCategoria(CategoriaProduto.ACOMPANHAMENTO);
    Produto produto = mapper.cadastrarDtoToProduto(cadastrarProdutoDTO);

    assertNotNull(produto);
    assertNotNull(produto.getCategoria());
  }

  @Test
  public void testCadastrarDtoToProduto_whenCategoriaIsBebida() {
    CadastrarProdutoDTO cadastrarProdutoDTO = CadastrarProdutoDTOMock.getCadastrarProduto();
    cadastrarProdutoDTO.setCategoria(CategoriaProduto.BEBIDA);
    Produto produto = mapper.cadastrarDtoToProduto(cadastrarProdutoDTO);

    assertNotNull(produto);
    assertNotNull(produto.getCategoria());
  }

  @Test
  public void testCadastrarDtoToProduto_whenCategoriaIsSobremesa() {
    CadastrarProdutoDTO cadastrarProdutoDTO = CadastrarProdutoDTOMock.getCadastrarProduto();
    cadastrarProdutoDTO.setCategoria(CategoriaProduto.SOBREMESA);
    Produto produto = mapper.cadastrarDtoToProduto(cadastrarProdutoDTO);

    assertNotNull(produto);
    assertNotNull(produto.getCategoria());
  }

  @Test
  public void testAtualizarProdutoDtoToProduto() {
    Produto produto = mapper.atualizarProdutoDtoToProduto(AtualizarProdutoDTOMock.getAtualizarProduto());
    assertNotNull(produto);
    assertNotNull(produto.getProdutoId());
  }

  @Test
  public void testAtualizarProdutoDtoToProduto_whenAtualizarProdutoDtoIsNull() {
    Produto produto = mapper.atualizarProdutoDtoToProduto(null);
    assertNull(produto);
  }

}
