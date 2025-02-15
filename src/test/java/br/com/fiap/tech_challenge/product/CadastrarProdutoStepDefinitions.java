package br.com.fiap.tech_challenge.product;

import br.com.fiap.tech_challenge.product.adapters.controller.model.mock.CadastrarProdutoDTOMock;
import br.com.fiap.tech_challenge.product.adapters.driver.controller.model.request.CadastrarProdutoDTO;
import br.com.fiap.tech_challenge.product.client.CucumberClient;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CadastrarProdutoStepDefinitions {

  @Autowired private CucumberClient cucumberClient;
  private ResponseEntity<String> response;
  private CadastrarProdutoDTO cadastrarProdutoDTO;

  @Given("that I want to register a product")
  public void that_i_want_to_register_a_product() {
    cadastrarProdutoDTO = CadastrarProdutoDTOMock.getCadastrarProduto();
  }
  @When("I send a POST request to \\/api\\/v1\\/produtos")
  public void i_send_a_post_request_to_api_v1_produtos() {
    response = cucumberClient.cadastrarProduto(cadastrarProdutoDTO);
  }
  @Then("should receive Http Status {int} and a string body")
  public void should_receive_http_status_and_a_string_body(Integer httpStatusCode) {
    assertEquals(HttpStatusCode.valueOf(httpStatusCode), response.getStatusCode());
  }

}
