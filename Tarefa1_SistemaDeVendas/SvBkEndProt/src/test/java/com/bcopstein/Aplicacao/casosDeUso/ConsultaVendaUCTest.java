package com.bcopstein.Aplicacao.casosDeUso;

import com.bcopstein.Aplicacao.dtos.ParamSubtotal_DTO;
import com.bcopstein.Negocio.entidades.ItemCarrinho;
import com.bcopstein.Negocio.entidades.Produto;
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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class ConsultaVendaUCTest {
    @InjectMocks
    private ConsultaVendaUC consultaVendaUC;

    @Mock
    private VendaService servicoVenda;

    @Mock
    private ProdutoService servicoProduto;

    private List<Produto> produtos;

    private ParamSubtotal_DTO paramSubtotal_dto;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
        Produto produto1 = new Produto(1, "Produto 1", 5.0);
        Produto produto2 = new Produto(2,"Produto 2", 5.0);
        Produto produto3 = new Produto(3,"Produto 3", 50.0);
        produtos = Arrays.asList(produto1, produto2, produto3);

        ItemCarrinho itemCarrinho1 = new ItemCarrinho(1,10,1);
        ItemCarrinho itemCarrinho2 = new ItemCarrinho(1,10,1);
        ItemCarrinho[] itensArray = {itemCarrinho1, itemCarrinho2};
        paramSubtotal_dto = new ParamSubtotal_DTO(itensArray, "canoas");
    }

    @Test
    public void mustReturnAllProdutos(){
        // GIVEN
        Integer[] values = new Integer[4];
        int subtotal = 20;
        int imposto = subtotal * 12 / 100;
        int frete = 17;
        values[0] = subtotal;
        values[1] = imposto;
        values[2] = subtotal + imposto + frete;
        values[3] = frete;

        // WHEN
        when(servicoProduto.todos()).thenReturn(produtos);
        when(servicoVenda.consultaVenda(any(List.class), any(String.class))).thenReturn(values);

        // THEN
        assertEquals(values, consultaVendaUC.executar(paramSubtotal_dto));
    }
}