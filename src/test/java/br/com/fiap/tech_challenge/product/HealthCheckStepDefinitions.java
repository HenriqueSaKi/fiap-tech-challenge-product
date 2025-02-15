package br.com.fiap.tech_challenge.product;

import br.com.fiap.tech_challenge.product.client.CucumberClient;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class HealthCheckStepDefinitions {

  @Autowired private CucumberClient cucumberClient;
  private ResponseEntity<String> response;

  @When("I make a GET call on \\/api\\/v1\\/actuator\\/health")
  public void i_make_a_get_call_on_api_v1_actuator_health() {
    response = cucumberClient.healthCheck();
  }
  @Then("I should receive {int} response status code")
  public void i_should_receive_response_status_code(Integer status) {
    assertEquals(HttpStatusCode.valueOf(status), response.getStatusCode());
  }
  @Then("should receive a non-empty body")
  public void should_receive_a_non_empty_body() {
    assertNotNull(response.getBody());
  }

}
