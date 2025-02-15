package br.com.fiap.tech_challenge.product;

import br.com.fiap.tech_challenge.product.adapters.controller.model.mock.AtualizarProdutoDTOMock;
import br.com.fiap.tech_challenge.product.adapters.driver.controller.model.request.AtualizarProdutoDTO;
import br.com.fiap.tech_challenge.product.client.CucumberClient;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AtualizarProdutoStepDefinitions {

  @Autowired private CucumberClient cucumberClient;
  private ResponseEntity<String> response;
  private AtualizarProdutoDTO atualizarProdutoDTO;

  @Given("that I want to update a product")
  public void that_i_want_to_update_a_product() {
    atualizarProdutoDTO = AtualizarProdutoDTOMock.getAtualizarProduto();
  }
  @When("I send a PUT request to \\/api\\/v1\\/produtos")
  public void i_send_a_put_request_to_api_v1_produtos() {
    response = cucumberClient.atualizaInformacoesProduto(atualizarProdutoDTO);
  }
  @Then("I should receive {int} http status \\(Accepted)")
  public void i_should_receive_http_status_accepted(Integer httpStatusCode) {
    assertEquals(HttpStatusCode.valueOf(httpStatusCode), response.getStatusCode());
  }
  @And("{string} message")
  public void message(String expectedMessage) {
    assertEquals(expectedMessage, response.getBody());
  }


}
