package com.bcopstein.Adaptadores.repositorios;

import java.util.List;

import com.bcopstein.Negocio.entidades.Produto;
import org.springframework.data.repository.CrudRepository;

public interface IProdutoCrud extends CrudRepository<Produto, Integer>  {
    public List<Produto> findAll();
}