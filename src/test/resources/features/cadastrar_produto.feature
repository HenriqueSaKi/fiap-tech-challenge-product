Feature: Cadastrar produto

  Scenario: Cadastrar produto
    Given that I want to register a product
    When I send a POST request to /api/v1/produtos
    Then should receive Http Status 201 and a string body