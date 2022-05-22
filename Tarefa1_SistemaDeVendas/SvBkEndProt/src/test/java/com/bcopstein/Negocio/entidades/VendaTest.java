package com.bcopstein.Negocio.entidades;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class VendaTest {

    @InjectMocks
    private Venda venda;

    private List<ItemCarrinho> itensCarrinho;

    @BeforeEach
    public void setup(){
        ItemCarrinho itemCarrinho1 = new ItemCarrinho(1,10,5);
        ItemCarrinho itemCarrinho2 = new ItemCarrinho(2,10,5);
        itensCarrinho = Arrays.asList(itemCarrinho1,itemCarrinho2);
    }

    @Test
    public void constructorWithAllParameters() {
        venda = new Venda(1, 100, 5, 95, itensCarrinho);

        assertEquals(1, venda.getCodVenda());
        assertEquals(100, venda.getSubtotal());
        assertEquals(5, venda.getImpostos());
        assertEquals(95, venda.getTotal());
        assertEquals(itensCarrinho, venda.getItensCarrinho());
    }

    @Test
    public void constructorWithoutCodVendaParameters() {
        venda = new Venda(100, 5, 95, itensCarrinho);

        assertEquals(100, venda.getSubtotal());
        assertEquals(5, venda.getImpostos());
        assertEquals(95, venda.getTotal());
        assertEquals(itensCarrinho, venda.getItensCarrinho());
    }

    @Test
    public void constructorWithoutParameters() {
        venda = new Venda();

        venda.setCodVenda(1);
        assertEquals(1, venda.getCodVenda());
        venda.setSubtotal(100);
        assertEquals(100, venda.getSubtotal());
        venda.setImpostos(5);
        assertEquals(5, venda.getImpostos());
        venda.setTotal(95);
        assertEquals(95, venda.getTotal());
        venda.setItensCarrinho(itensCarrinho);
        assertEquals(itensCarrinho, venda.getItensCarrinho());
    }

}