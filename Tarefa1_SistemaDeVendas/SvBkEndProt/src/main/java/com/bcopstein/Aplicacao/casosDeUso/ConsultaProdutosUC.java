package com.bcopstein.Aplicacao.casosDeUso;

import java.util.List;

import com.bcopstein.Negocio.servicos.ProdutoService;
import com.bcopstein.Negocio.entidades.Produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConsultaProdutosUC {
  private ProdutoService servicoProduto;

  @Autowired
  public ConsultaProdutosUC(ProdutoService servicoProduto) {
    this.servicoProduto = servicoProduto;
  }

  public List<Produto> executar() {
    return servicoProduto.todos();
  }
}
