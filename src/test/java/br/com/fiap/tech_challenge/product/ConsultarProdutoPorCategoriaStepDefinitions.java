package br.com.fiap.tech_challenge.product;

import br.com.fiap.tech_challenge.product.client.CucumberClient;
import br.com.fiap.tech_challenge.product.core.domain.model.Produto;
import br.com.fiap.tech_challenge.product.core.domain.model.enums.CategoriaProduto;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ConsultarProdutoPorCategoriaStepDefinitions {

  @Autowired private CucumberClient cucumberClient;
  private ResponseEntity<Object> response;
  private CategoriaProduto categoriaProduto;

  @Given("that I want to consult a product by its category")
  public void that_i_want_to_consult_a_product_by_its_category() {
    categoriaProduto = CategoriaProduto.LANCHE;
  }
  @When("I send a GET request to \\/api\\/v1\\/produtos\\/categoria sending categoria as path variable")
  public void i_send_a_get_request_to_api_v1_produtos_categoria_sending_categoria_as_path_variable() {
    response = cucumberClient.consultaPorCategoria(categoriaProduto);
  }
  @Then("should receive Http Status {int} and a non-empty body and return at least {int} product")
  public void should_receive_http_status_and_a_non_empty_body_and_at_least_product(Integer httpStatusCode, Integer length) {
    assertEquals(HttpStatusCode.valueOf(httpStatusCode), response.getStatusCode());
    assertNotNull(response.getBody());

    List<Produto> produtos = (List<Produto>) response.getBody();
    assertTrue(produtos.size() >= length);

  }

}
