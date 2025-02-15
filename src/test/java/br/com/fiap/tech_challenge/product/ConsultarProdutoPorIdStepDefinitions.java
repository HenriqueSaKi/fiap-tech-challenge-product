package br.com.fiap.tech_challenge.product;

import br.com.fiap.tech_challenge.product.client.CucumberClient;
import br.com.fiap.tech_challenge.product.core.domain.model.Produto;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ConsultarProdutoPorIdStepDefinitions {

  @Autowired private CucumberClient cucumberClient;
  private ResponseEntity<Produto> response;
  private Long id;

  @Given("that I want to consult a product by its id value")
  public void that_i_want_to_consult_a_product_by_its_id_value() {
    id = 1L;
  }
  @When("I send a GET request to \\/api\\/v1\\/produtos sending id as path variable")
  public void i_send_a_get_request_to_api_v1_produtos_sending_id() {
    response = cucumberClient.consultarProdutoPorId(id);
  }
  @Then("should receive Http Status {int} and a non-empty body")
  public void should_receive_http_status_and_a_non_empty_body(Integer httpStatusCode) {
    assertEquals(HttpStatusCode.valueOf(httpStatusCode), response.getStatusCode());
    assertNotNull(response.getBody());
  }


}
