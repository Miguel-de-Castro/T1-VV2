package com.bcopstein.Adaptadores.repositorios;

import java.util.List;

import com.bcopstein.Negocio.entidades.Venda;
import org.springframework.data.repository.CrudRepository;

public interface IVendaCrud extends CrudRepository<Venda, Integer> {
    public List<Venda> findAll();
}
