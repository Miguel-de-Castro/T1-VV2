package com.bcopstein.Negocio.repositorios;

import java.util.List;

import com.bcopstein.Negocio.entidades.Venda;

public interface IVendaRepository {
    List<Venda> todos();

    boolean cadastra(Venda venda);
}
