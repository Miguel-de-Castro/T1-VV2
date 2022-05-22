package com.bcopstein.Aplicacao.casosDeUso;


import java.util.List;

import com.bcopstein.Negocio.servicos.VendaService;
import com.bcopstein.Negocio.entidades.Venda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConsultaVendasUC {
  private VendaService servicoVenda;

  @Autowired
  public ConsultaVendasUC(VendaService servicoVenda) {
    this.servicoVenda = servicoVenda;
  }

  public List<Venda> executar() {
    return servicoVenda.todos();
  }
}
