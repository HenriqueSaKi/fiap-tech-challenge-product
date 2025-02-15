Feature: Consultar produto por categoria

  Scenario: Consultar produto por categoria
    Given that I want to consult a product by its category
    When I send a GET request to /api/v1/produtos/categoria sending categoria as path variable
    Then should receive Http Status 200 and a non-empty body and return at least 1 product