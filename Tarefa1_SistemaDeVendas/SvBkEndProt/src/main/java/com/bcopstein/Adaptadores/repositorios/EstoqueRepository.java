package com.bcopstein.Adaptadores.repositorios;

import com.bcopstein.Negocio.entidades.ItemEstoque;
import com.bcopstein.Negocio.repositorios.IEstoqueRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EstoqueRepository implements IEstoqueRepository {

  private IEstoqueRepositoryCrud estoqueRepository;

  @Autowired
  public EstoqueRepository(IEstoqueRepositoryCrud estoqueRepository) {
    this.estoqueRepository = estoqueRepository;
  }

  @Override
  public ItemEstoque getProduto(int codigo) {
    return estoqueRepository.findByProdutoCodigo(codigo);
  }

  @Override
  public void atualizaProduto(ItemEstoque itemEstoque) {
    estoqueRepository.save(itemEstoque);
  }

}
