Feature: Consultar produto por id

  Scenario: Consultar produto por id
    Given that I want to consult a product by its id value
    When I send a GET request to /api/v1/produtos sending id as path variable
    Then should receive Http Status 200 and a non-empty body