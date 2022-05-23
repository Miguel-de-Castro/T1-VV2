package com.bcopstein.Aplicacao.casosDeUso;

import com.bcopstein.Negocio.entidades.Produto;
import com.bcopstein.Negocio.servicos.EstoqueService;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class VerificaEstoqueProdutoUCTest {

    @InjectMocks
    private VerificaEstoqueProdutoUC verificaEstoqueProdutoUC;

    @Mock
    private EstoqueService estoqueService;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void mustExecute(){
        // GIVEN
        int codProduto = 1;
        int quantidade = 5;

        // WHEN
        when(estoqueService.podeVender(codProduto, quantidade)).thenReturn(true);

        // THEN
        assertTrue(verificaEstoqueProdutoUC.executar(codProduto,quantidade));
    }

    @Test
    public void mustNotExecute(){
        // GIVEN

        int codProduto = 1;
        int quantidade = 13;

        // WHEN
        when(estoqueService.podeVender(codProduto, quantidade)).thenReturn(false);

        // THEN
        assertFalse(verificaEstoqueProdutoUC.executar(codProduto,quantidade));
    }
}