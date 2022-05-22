package com.bcopstein.Negocio.servicos;

import com.bcopstein.Negocio.entidades.ItemEstoque;
import com.bcopstein.Negocio.repositorios.IEstoqueRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EstoqueService {

  private IEstoqueRepository estoqueRepository;

  @Autowired
  public EstoqueService(IEstoqueRepository estoqueRepository) {
    this.estoqueRepository = estoqueRepository;
  }

  public boolean podeVender(int codProduto, int quantidade) {

    boolean disponivel = false;
    ItemEstoque produtoEncontrado = estoqueRepository.getProduto(codProduto);
    disponivel = produtoEncontrado.getQuantidade() >= quantidade;

    return disponivel;
  }

  public void atualizaProduto(ItemEstoque itemEstoque) {
    estoqueRepository.atualizaProduto(itemEstoque);
  }

  public ItemEstoque getProduto(int codProduto) {
    return estoqueRepository.getProduto(codProduto);
  }
}
