package com.bcopstein.Negocio.repositorios;

import com.bcopstein.Negocio.entidades.ItemEstoque;

public interface IEstoqueRepository {

  ItemEstoque getProduto(int codigo);

  void atualizaProduto(ItemEstoque itemEstoque);

}
