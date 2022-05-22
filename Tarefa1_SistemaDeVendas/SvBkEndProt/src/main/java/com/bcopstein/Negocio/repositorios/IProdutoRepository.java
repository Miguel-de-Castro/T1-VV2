package com.bcopstein.Negocio.repositorios;

import java.util.List;

import com.bcopstein.Negocio.entidades.Produto;

public interface IProdutoRepository {
    List<Produto> todos();

    void criarProdutos();
}