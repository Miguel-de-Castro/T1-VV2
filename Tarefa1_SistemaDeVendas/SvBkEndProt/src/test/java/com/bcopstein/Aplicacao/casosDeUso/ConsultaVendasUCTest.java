package com.bcopstein.Aplicacao.casosDeUso;

import com.bcopstein.Negocio.entidades.ItemCarrinho;
import com.bcopstein.Negocio.entidades.Produto;
import com.bcopstein.Negocio.entidades.Venda;
import com.bcopstein.Negocio.servicos.ProdutoService;
import com.bcopstein.Negocio.servicos.VendaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class ConsultaVendasUCTest {
    @InjectMocks
    private ConsultaVendasUC consultaVendasUC;

    @Mock
    private VendaService servicoVenda;

    private List<Venda> vendas;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
        ItemCarrinho itemCarrinho1 = new ItemCarrinho(1,10,1);
        ItemCarrinho itemCarrinho2 = new ItemCarrinho(1,10,1);
        List<ItemCarrinho> itensCarrinho1 = Arrays.asList(itemCarrinho1,itemCarrinho2);

        Venda venda1 = new Venda(1, 100, 5, 95, itensCarrinho1);
        Venda venda2 = new Venda(2, 80, 5, 75, itensCarrinho1);
        vendas = Arrays.asList(venda1,venda2);
    }

    @Test
    public void mustReturnAllProdutos(){
        // WHEN
        when(servicoVenda.todos()).thenReturn(vendas);

        // THEN
        assertEquals(vendas, consultaVendasUC.executar());
    }
}