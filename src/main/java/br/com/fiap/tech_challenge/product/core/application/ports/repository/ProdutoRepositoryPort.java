package br.com.fiap.tech_challenge.product.core.application.ports.repository;

import br.com.fiap.tech_challenge.product.adapters.driven.infrastructure.repository.entity.ProdutoEntity;
import br.com.fiap.tech_challenge.product.core.domain.model.enums.CategoriaProduto;

import java.util.List;
import java.util.Optional;

public interface ProdutoRepositoryPort {
    void deleteById(Long id);

    void save(ProdutoEntity produto);

    Optional<ProdutoEntity> findById(Long produtoId);

    List<ProdutoEntity> findProdutosByCategoria(CategoriaProduto categoriaProduto);
}
