package com.bcopstein.Aplicacao.servicos;

import com.bcopstein.Negocio.servicos.IRestricaoHorarioVenda;
import com.bcopstein.Negocio.entidades.Venda;

public class HorarioNormal implements IRestricaoHorarioVenda {
  private static final int LIMITE_ITENS_VENDA = 10;
  private static final int LIMITE_QUANTIDADE_ITEM = 5;
  private static final int LIMITE_VALOR_TOTAL_VENDA = 25000;

  @Override
  public boolean vendaIsValida(Venda venda) {
    if (venda.getTotal() > LIMITE_VALOR_TOTAL_VENDA) {
      return false;
    }

    if (venda.getItensCarrinho().size() > LIMITE_ITENS_VENDA) {
      return false;
    }

    for (int i = 0; i < venda.getItensCarrinho().size(); i++) {
      if (venda.getItensCarrinho().get(i).getQuantidade() > LIMITE_QUANTIDADE_ITEM) {
        return false;
      }
    }

    return true;
  }

}
