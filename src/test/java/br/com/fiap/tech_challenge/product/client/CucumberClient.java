package br.com.fiap.tech_challenge.product.client;


import br.com.fiap.tech_challenge.product.adapters.driver.controller.model.request.AtualizarProdutoDTO;
import br.com.fiap.tech_challenge.product.adapters.driver.controller.model.request.CadastrarProdutoDTO;
import br.com.fiap.tech_challenge.product.core.domain.model.Produto;
import br.com.fiap.tech_challenge.product.core.domain.model.enums.CategoriaProduto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(
    name = "cucumber",
    url = "${server.host}" + ":${server.port}"
)
public interface CucumberClient {
  
  @GetMapping("/api/v1/actuator/health")
  ResponseEntity<String> healthCheck();

  @PostMapping("/api/v1/produtos")
  ResponseEntity<String> cadastrarProduto(
      @RequestBody CadastrarProdutoDTO cadastrarProdutoDTO);

  @GetMapping("/api/v1/produtos/{id}")
  ResponseEntity<Produto> consultarProdutoPorId(
      @PathVariable("id") Long id);

  @GetMapping("/api/v1/produtos/categoria/{categoria}")
  ResponseEntity<Object> consultaPorCategoria(
      @PathVariable("categoria") CategoriaProduto categoria);

  @PutMapping("/api/v1/produtos")
  ResponseEntity<String> atualizaInformacoesProduto(
      @RequestBody AtualizarProdutoDTO atualizar);

  @DeleteMapping("/api/v1/produtos/id/{id}")
  ResponseEntity<String> excluirProduto(
      @PathVariable Long id);

}
