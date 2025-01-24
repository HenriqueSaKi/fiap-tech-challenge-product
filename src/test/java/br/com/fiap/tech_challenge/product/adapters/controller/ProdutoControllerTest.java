package br.com.fiap.tech_challenge.product.adapters.controller;

import br.com.fiap.tech_challenge.product.adapters.controller.model.mock.AtualizarProdutoDTOMock;
import br.com.fiap.tech_challenge.product.adapters.controller.model.mock.CadastrarProdutoDTOMock;
import br.com.fiap.tech_challenge.product.adapters.driven.infrastructure.repository.ProdutoRepository;
import br.com.fiap.tech_challenge.product.adapters.driven.infrastructure.repository.entity.mock.ProdutoEntityMock;
import br.com.fiap.tech_challenge.product.adapters.driver.controller.ProdutoController;
import br.com.fiap.tech_challenge.product.core.domain.model.enums.CategoriaProduto;
import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class ProdutoControllerTest {

  @InjectMocks private ProdutoController controller;
  @Mock private ProdutoRepository repository;
  private MockMvc mockMvc;

  @BeforeEach
  public void setUp() {
    mockMvc = MockMvcBuilders.standaloneSetup(controller)
        .alwaysDo(print())
        .build();
  }

  @Test
  public void testCadastrarProduto() throws Exception {
    when(repository.save(any())).thenReturn(ProdutoEntityMock.getProdutoEntity());
    mockMvc.perform(post("/produtos")
            .contentType("application/json")
            .content(new Gson().toJson(CadastrarProdutoDTOMock.getCadastrarProduto())))
        .andExpect(status().isCreated());
  }

  @Test
  public void testConsultaPorId() throws Exception {
    when(repository.findById(any())).thenReturn(Optional.of(ProdutoEntityMock.getProdutoEntity()));
    mockMvc.perform(get("/produtos/{id}", 1L)
            .contentType("application/json"))
        .andExpect(status().isOk());
  }

  @Test
  public void testConsultaPorCategoria() throws Exception {
    when(repository.findAllByCategoriaProduto(any())).thenReturn(List.of(ProdutoEntityMock.getProdutoEntity()));
    mockMvc.perform(get("/produtos/categoria/{categoria}", CategoriaProduto.LANCHE)
            .contentType("application/json"))
        .andExpect(status().isOk());
  }

  @Test
  public void testAtualizarInformacoesProduto() throws Exception {
    when(repository.findById(any())).thenReturn(Optional.of(ProdutoEntityMock.getProdutoEntity()));
    when(repository.save(any())).thenReturn(ProdutoEntityMock.getProdutoEntity());
    mockMvc.perform(put("/produtos")
            .contentType("application/json")
            .content(new Gson().toJson(AtualizarProdutoDTOMock.getAtualizarProduto())))
        .andExpect(status().isAccepted());
  }

  @Test
  public void testExcluirProduto() throws Exception {
    when(repository.findById(any())).thenReturn(Optional.of(ProdutoEntityMock.getProdutoEntity()));
    mockMvc.perform(delete("/produtos/id/{id}", 1L)
            .contentType("application/json")
            .content(new Gson().toJson(AtualizarProdutoDTOMock.getAtualizarProduto())))
        .andExpect(status().isOk());

    verify(repository, times(1)).deleteById(any());
  }

}
