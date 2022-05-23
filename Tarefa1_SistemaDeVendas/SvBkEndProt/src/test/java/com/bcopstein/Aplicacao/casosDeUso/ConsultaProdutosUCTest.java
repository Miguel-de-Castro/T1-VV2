package com.bcopstein.Aplicacao.casosDeUso;

import com.bcopstein.Negocio.entidades.Produto;
import com.bcopstein.Negocio.servicos.ProdutoService;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class ConsultaProdutosUCTest {

    @InjectMocks
    private ConsultaProdutosUC consultaProdutosUC;

    @Mock
    private ProdutoService produtoService;

    private List<Produto> produtos;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
        Produto produto1 = new Produto(1, "Produto 1", 5.0);
        Produto produto2 = new Produto(2,"Produto 2", 5.0);
        Produto produto3 = new Produto(3,"Produto 3", 50.0);
        produtos = Arrays.asList(produto1, produto2, produto3);
    }

    @Test
    public void mustReturnAllProdutos(){
        // WHEN
        when(produtoService.todos()).thenReturn(produtos);

        // THEN
        assertEquals(produtos, consultaProdutosUC.executar());
    }
}