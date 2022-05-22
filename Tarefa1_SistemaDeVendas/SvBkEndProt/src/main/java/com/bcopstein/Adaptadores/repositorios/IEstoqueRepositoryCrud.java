package com.bcopstein.Adaptadores.repositorios;

import com.bcopstein.Negocio.entidades.ItemEstoque;

import org.springframework.data.repository.CrudRepository;

public interface IEstoqueRepositoryCrud extends CrudRepository<ItemEstoque, Integer> {
  ItemEstoque findByProdutoCodigo(Integer codProduto);
}
