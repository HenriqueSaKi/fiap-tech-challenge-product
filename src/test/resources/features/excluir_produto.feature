Feature: Excluir produto

  Scenario: Excluir produto
    When I send a DELETE request to /api/v1/produtos/id with id value 200
    Then I should receive 200 http status (OK)
    And "Produto excluido com sucesso!" response message