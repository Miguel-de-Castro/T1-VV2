package com.bcopstein.Aplicacao.casosDeUso;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.bcopstein.Negocio.entidades.ItemCarrinho;
import com.bcopstein.Negocio.entidades.ItemEstoque;
import com.bcopstein.Negocio.entidades.Produto;
import com.bcopstein.Negocio.entidades.Venda;
import com.bcopstein.Negocio.servicos.ProdutoService;
import com.bcopstein.Negocio.servicos.EstoqueService;
import com.bcopstein.Negocio.servicos.VendaService;
import com.bcopstein.Adaptadores.repositorios.EstoqueRepository;
import com.bcopstein.Aplicacao.dtos.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CadastraProdutos {
  private ProdutoService servicoProduto;
  private EstoqueService servicoEstoque;

  @Autowired
  public CadastraProdutos(ProdutoService servicoProduto, EstoqueService servicoEstoque) {
    this.servicoProduto = servicoProduto;
    this.servicoEstoque = servicoEstoque;
  }

  public boolean executar() {
        servicoProduto.criar();
        List<Produto> list = servicoProduto.todos();

        for (Produto produto : list) {
            servicoEstoque.atualizaProduto(new ItemEstoque(produto.getCodigo(),produto,10));
        }
        
        return true;
  }
}
