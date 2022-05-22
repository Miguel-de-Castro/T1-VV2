package com.bcopstein.Negocio.servicos;

import com.bcopstein.Negocio.entidades.Venda;

public interface IRestricaoHorarioVenda {
  public boolean vendaIsValida(Venda venda);
}
