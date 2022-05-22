package com.bcopstein.Negocio.entidades;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import static org.junit.jupiter.api.Assertions.*;

public class ItemCarrinhoTest {

    @InjectMocks
    private ItemCarrinho itemCarrinho;

    @Test
    public void constructorWithParameters(){
        itemCarrinho = new ItemCarrinho(1,10,5);

        assertEquals(1, itemCarrinho.getCodProduto());
        assertEquals(10, itemCarrinho.getPrecoProd());
        assertEquals(5, itemCarrinho.getQuantidade());
    }

    @Test
    public void constructorWithoutParameters(){
        itemCarrinho = new ItemCarrinho();

        itemCarrinho.setCodProduto(1);
        assertEquals(1, itemCarrinho.getCodProduto());
        itemCarrinho.setPrecoProd(10);
        assertEquals(10, itemCarrinho.getPrecoProd());
        itemCarrinho.setQuantidade(5);
        assertEquals(5, itemCarrinho.getQuantidade());
    }

    @Test
    public void testToString() {
        itemCarrinho = new ItemCarrinho(1,10,5);
        assertEquals("ItemCarrinho [codProduto=1, codigo=null, precoProd=10, quantidade=5]", itemCarrinho.toString());
    }
}