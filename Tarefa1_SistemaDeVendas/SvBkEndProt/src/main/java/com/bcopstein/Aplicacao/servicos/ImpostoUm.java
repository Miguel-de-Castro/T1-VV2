package com.bcopstein.Aplicacao.servicos;

import java.util.List;

import com.bcopstein.Negocio.entidades.ItemCarrinho;
import com.bcopstein.Negocio.servicos.ICalculoImposto;

public class ImpostoUm implements ICalculoImposto {

  private static final Integer PORCENTAGEM_IMPOSTO = 12;

  @Override
  public Integer calculaImposto(List<ItemCarrinho> produtos) {
    Integer valorTotalCompra = 0;

    for (ItemCarrinho produto : produtos) {
      valorTotalCompra += produto.getPrecoProd() * produto.getQuantidade();
    }

    return valorTotalCompra * PORCENTAGEM_IMPOSTO / 100;
  }

}
