package com.bcopstein.Negocio.entidades;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import static org.junit.jupiter.api.Assertions.*;

public class ProdutoTest {

    @InjectMocks
    private Produto produto;

    @Test
    public void constructorWithParameters() {
        produto = new Produto(1, "Produto 1", 5.0);

        assertEquals(1, produto.getCodigo());
        assertEquals("Produto 1", produto.getDescricao());
        assertEquals(5.0, produto.getPreco());
    }

    @Test
    public void constructorWithoutParameters(){
        produto = new Produto();

        produto.setCodigo(1);
        assertEquals(1, produto.getCodigo());
        produto.setDescricao("Produto 1");
        assertEquals("Produto 1", produto.getDescricao());
        produto.setPreco(10.0);
        assertEquals(10.0, produto.getPreco());
    }

    @Test
    public void testToString() {
        produto = new Produto(1, "Produto 1", 5.0);

        assertEquals("Produto [codigo=1, descricao=Produto 1, preco=5.0]", produto.toString());
    }
}