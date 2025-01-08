package br.com.fiap.tech_challenge.product.adapters.driven.infrastructure.gateway;

import br.com.fiap.tech_challenge.product.adapters.driven.infrastructure.repository.ProdutoRepository;
import br.com.fiap.tech_challenge.product.adapters.driven.infrastructure.repository.entity.ProdutoEntity;
import br.com.fiap.tech_challenge.product.core.application.mapper.ProdutoMapper;
import br.com.fiap.tech_challenge.product.core.application.mapper.ProdutoMapperImpl;
import br.com.fiap.tech_challenge.product.core.application.ports.gateway.ProdutoGatewayPort;
import br.com.fiap.tech_challenge.product.core.domain.model.Produto;
import br.com.fiap.tech_challenge.product.core.domain.model.enums.CategoriaProduto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ProdutoGateway implements ProdutoGatewayPort {

  private final ProdutoRepository repository;

  public ProdutoGateway(ProdutoRepository repository) {
    this.repository = repository;
  }

  @Override
  public void deleteById(Long id) {
    repository.deleteById(id);
  }

  @Override
  public Long save(Produto produto) {
    ProdutoMapper produtoMapper = new ProdutoMapperImpl();

    ProdutoEntity entity = produtoMapper.toEntity(produto);
    return repository.save(entity).getProdutoId();
  }

  @Override
  public Produto findById(Long produtoId) {
    Optional<ProdutoEntity> produtoEntity = repository.findById(produtoId);

    ProdutoMapper produtoMapper = new ProdutoMapperImpl();
    return produtoEntity.map(produtoMapper::toDTO).orElse(null);
  }

  @Override
  public List<Produto> findProdutosByCategoria(CategoriaProduto categoriaProduto) {
    List<ProdutoEntity> produtoEntities = repository.findAllByCategoriaProduto(categoriaProduto);

    ProdutoMapper produtoMapper = new ProdutoMapperImpl();
    return produtoEntities.stream()
        .map(produtoMapper::toDTO)
        .collect(Collectors.toList());
  }
}
