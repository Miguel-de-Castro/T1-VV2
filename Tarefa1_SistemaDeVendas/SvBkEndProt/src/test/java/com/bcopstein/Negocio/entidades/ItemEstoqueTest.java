package com.bcopstein.Negocio.entidades;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import static org.junit.jupiter.api.Assertions.*;

public class ItemEstoqueTest {

    @InjectMocks
    private ItemEstoque itemEstoque;

    private Produto produto;

    @BeforeEach
    public void setup() {
        produto = new Produto(1, "Produto 1", 45.0);
    }

    @Test
    public void constructorWithParameters() {
        itemEstoque = new ItemEstoque(1, produto, 5);

        assertEquals(1, itemEstoque.getCodEstoque());
        assertEquals(produto, itemEstoque.getProduto());
        assertEquals(5, itemEstoque.getQuantidade());
    }

    @Test
        public void constructorWithoutParameters(){
            itemEstoque = new ItemEstoque();

            itemEstoque.setCodEstoque(1);
            assertEquals(1, itemEstoque.getCodEstoque());
            itemEstoque.setProduto(produto);
            assertEquals(produto, itemEstoque.getProduto());
            itemEstoque.setQuantidade(5);
            assertEquals(5, itemEstoque.getQuantidade());

    }
}        
        
        
        
        
    
