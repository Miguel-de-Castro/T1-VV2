package com.bcopstein.Aplicacao.servicos;

import com.bcopstein.Negocio.servicos.IRestricaoHorarioVenda;
import com.bcopstein.Negocio.entidades.Venda;

public class HorarioFechado implements IRestricaoHorarioVenda {

  @Override
  public boolean vendaIsValida(Venda venda) {
    return false;
  }
}


