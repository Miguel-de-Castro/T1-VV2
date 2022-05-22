package com.bcopstein.Adaptadores.repositorios;

import java.util.List;

import com.bcopstein.Negocio.entidades.Produto;
import com.bcopstein.Negocio.repositorios.IProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProdutoRepository implements IProdutoRepository {
    
    private IProdutoCrud produtoCrud;

    @Autowired
    public ProdutoRepository(IProdutoCrud produtoCrud) {
      this.produtoCrud = produtoCrud;
    }
  
    @Override
    public List<Produto> todos() {
      return produtoCrud.findAll();
    }

    @Override
    public void criarProdutos() {
        //Integer codigo, String descricao, Double preco
        produtoCrud.save(new Produto(1,"Produto 1", 45.0));
        produtoCrud.save(new Produto(2,"Produto 2", 5.0));
        produtoCrud.save(new Produto(3,"Produto 3", 50.0));
    }
}
