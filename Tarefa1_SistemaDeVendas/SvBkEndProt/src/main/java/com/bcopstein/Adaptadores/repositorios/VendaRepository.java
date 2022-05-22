package com.bcopstein.Adaptadores.repositorios;

import java.util.List;

import com.bcopstein.Negocio.entidades.Venda;
import com.bcopstein.Negocio.repositorios.IVendaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VendaRepository implements IVendaRepository {
    IVendaCrud vendaCRUD;

    @Autowired
    public VendaRepository(IVendaCrud vendaCRUD) {
        this.vendaCRUD = vendaCRUD;
    }

    @Override
    public List<Venda> todos() {
        return vendaCRUD.findAll();
    }

    @Override
    public boolean cadastra(Venda venda) {
        vendaCRUD.save(venda);
        return true;
    }

}
