package com.bcopstein.Negocio.servicos;

import com.bcopstein.Negocio.entidades.Produto;
import com.bcopstein.Negocio.repositorios.IProdutoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

//https://stackoverflow.com/questions/2457239/injecting-mockito-mocks-into-a-spring-bean

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class ProdutoServiceTest {

    @InjectMocks
    private ProdutoService produtoService;

    @Mock
    private IProdutoRepository repo;

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
    public void mustReturnAllProduto(){
        // WHEN
        when(repo.todos()).thenReturn(produtos);

        //THEN
        assertEquals(produtos, produtoService.todos());

        // TODO: VER
        produtoService.criar();
    }
}