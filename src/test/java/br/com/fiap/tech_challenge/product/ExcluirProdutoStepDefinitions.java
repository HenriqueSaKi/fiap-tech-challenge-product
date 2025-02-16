package br.com.fiap.tech_challenge.product;

import br.com.fiap.tech_challenge.product.client.CucumberClient;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExcluirProdutoStepDefinitions {

  @Autowired private CucumberClient cucumberClient;
  private ResponseEntity<String> response;

  @When("I send a DELETE request to \\/api\\/v1\\/produtos\\/id with id value {int}")
  public void i_send_a_delete_request_to_api_v1_produtos_id_with_id_value(Integer id) {
    response = cucumberClient.excluirProduto(Long.valueOf(id));
  }
  @Then("I should receive {int} http status \\(OK)")
  public void i_should_receive_http_status_ok(Integer httpStatusCode) {
    assertEquals(HttpStatusCode.valueOf(httpStatusCode), response.getStatusCode());
  }
  @And("{string} response message")
  public void response_message(String expectedMessage) {
    assertEquals(expectedMessage, response.getBody());
  }

}
