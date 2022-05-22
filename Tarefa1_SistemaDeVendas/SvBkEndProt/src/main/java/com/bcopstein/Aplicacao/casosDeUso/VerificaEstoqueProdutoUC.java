package com.bcopstein.Aplicacao.casosDeUso;

import com.bcopstein.Negocio.servicos.EstoqueService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VerificaEstoqueProdutoUC {
  private EstoqueService servicoEstoque;

  @Autowired
  public VerificaEstoqueProdutoUC(EstoqueService servicoEstoque) {
    this.servicoEstoque = servicoEstoque;
  }

  public boolean executar(int codProduto, int quantidade) {
    return servicoEstoque.podeVender(codProduto, quantidade);
  }
}
