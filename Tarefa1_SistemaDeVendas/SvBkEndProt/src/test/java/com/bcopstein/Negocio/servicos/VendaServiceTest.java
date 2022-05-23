package com.bcopstein.Negocio.servicos;

import com.bcopstein.Adaptadores.controllers.Controller;
import com.bcopstein.Adaptadores.repositorios.EstoqueRepository;
import com.bcopstein.Adaptadores.repositorios.IEstoqueRepositoryCrud;
import com.bcopstein.Aplicacao.casosDeUso.VerificaEstoqueProdutoUC;
import com.bcopstein.Aplicacao.servicos.HorarioNormal;
import com.bcopstein.Aplicacao.servicos.ImpostoUm;
import com.bcopstein.Aplicacao.servicos.RestricaoVendaFactory;
import com.bcopstein.Negocio.entidades.ItemCarrinho;
import com.bcopstein.Negocio.entidades.ItemEstoque;
import com.bcopstein.Negocio.entidades.Produto;
import com.bcopstein.Negocio.entidades.Venda;
import com.bcopstein.Negocio.repositorios.IVendaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

public class VendaServiceTest {

    @InjectMocks
    private VendaService vendaService;

    @Mock
    private IVendaRepository vendaRepository;

    @Mock
    private ICalculoImposto calculoImposto;

    @Mock
    private EstoqueService estoqueService;

    @Mock
    private ICalculoFrete calculoFrete;

    private List<Venda> vendas;

    private List<ItemCarrinho> itensCarrinho1;

    private ItemEstoque itemEstoque;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        Produto produto = new Produto(1, "Produto 1", 45.0);
        itemEstoque = new ItemEstoque(1, produto, 11);

        ItemCarrinho itemCarrinho1 = new ItemCarrinho(1,10,1);
        ItemCarrinho itemCarrinho2 = new ItemCarrinho(1,10,1);
        itensCarrinho1 = Arrays.asList(itemCarrinho1,itemCarrinho2);

        Venda venda1 = new Venda(1, 100, 5, 95, itensCarrinho1);
        Venda venda2 = new Venda(2, 80, 5, 75, itensCarrinho1);
        vendas = Arrays.asList(venda1,venda2);
    }

    @Test
    public void returnAllValuesOfVenda() throws URISyntaxException, IOException, InterruptedException {
        // GIVEN
        String endereco = "canoas";
        Integer[] values = new Integer[4];
        int subtotal = 20;
        int imposto = subtotal * 12 / 100;
        int frete = 17;
        values[0] = subtotal;
        values[1] = imposto;
        values[2] = subtotal + imposto + frete;
        values[3] = frete;

        // WHEN
        when(calculoImposto.calculaImposto(itensCarrinho1)).thenReturn(imposto);
        when(calculoFrete.calculaFrete("portoalegre", endereco)).thenReturn((double) frete);

        // THEN
        Integer[] response  = vendaService.consultaVenda(itensCarrinho1, endereco);
        assertEquals(values[0], response[0]);
        assertEquals(values[1], response[1]);
        assertEquals(values[2], response[2]);
        assertEquals(values[3], response[3]);
    }

    @Test
    public void returnAllValuesOfVendaWithoutAddress() throws URISyntaxException, IOException, InterruptedException {
        // GIVEN
        String endereco = "";
        Integer[] values = new Integer[4];
        int subtotal = 20;
        int imposto = subtotal * 12 / 100;
        int frete = 0;
        values[0] = subtotal;
        values[1] = imposto;
        values[2] = subtotal + imposto + frete;
        values[3] = frete;

        // WHEN
        when(calculoImposto.calculaImposto(itensCarrinho1)).thenReturn(imposto);
        when(calculoFrete.calculaFrete("portoalegre", endereco)).thenReturn((double) frete);

        // THEN
        Integer[] response  = vendaService.consultaVenda(itensCarrinho1, endereco);
        assertEquals(values[0], response[0]);
        assertEquals(values[1], response[1]);
        assertEquals(values[2], response[2]);
        assertEquals(values[3], response[3]);
    }

    //TODO: Fazer
    @Test
    public void returnAllValuesOfVendaWithWrongAddress() throws URISyntaxException, IOException, InterruptedException {
        // GIVEN
        String endereco = "trabass";
        Integer[] values = new Integer[4];
        int subtotal = 20;
        int imposto = subtotal * 12 / 100;
        int frete = 0;
        values[0] = subtotal;
        values[1] = imposto;
        values[2] = subtotal + imposto + frete;
        values[3] = frete;

        // WHEN
        when(calculoImposto.calculaImposto(itensCarrinho1)).thenReturn(imposto);
        when(calculoFrete.calculaFrete("portoalegre", endereco)).thenReturn((double) frete);

        // THEN
        Integer[] response  = vendaService.consultaVenda(itensCarrinho1, endereco);
        assertEquals(values[0], response[0]);
        assertEquals(values[1], response[1]);
        assertEquals(values[2], response[2]);
        assertEquals(values[3], response[3]);
    }

    @Test
    public void notReturnAllValuesOfVendaWithItemCarrinhoNull(){
        // GIVEN
        List<ItemCarrinho> itensCarrinhoNull = Arrays.asList(null,null);

        // THEN
        assertThrows(IllegalArgumentException.class, () -> {vendaService.consultaVenda(itensCarrinhoNull, "canoas");});
    }

    @Test
    public void returnAllVenda(){
        // WHEN
        when(vendaRepository.todos()).thenReturn(vendas);

        // THEN
        assertEquals(vendas, vendaService.todos());
    }




    // TODO: fazer o "RestricaoVendaFactory" funcionar com o mockStatic
//    @Test
//    public void canAddVenda(){
//        // GIVEN
////        try (MockedStatic<RestricaoVendaFactory> theMock = Mockito.mockStatic(RestricaoVendaFactory.class)) {
////            theMock.when(() -> RestricaoVendaFactory.getInstance(LocalTime.now()))
////                    .thenReturn(HorarioNormal.class);
////        }
//
////        RestricaoVendaFactory restricaoVendaFactory = new RestricaoVendaFactory();
////        given(RestricaoVendaFactory.getInstance(LocalTime.now())).willReturn(HorarioNormal.class);
//
//        // WHEN
//        for (ItemCarrinho produto : itensCarrinho1) {
//            when(estoqueService.podeVender(produto.getCodProduto(), produto.getQuantidade())).thenReturn(true);
//        }
//
//        for (ItemCarrinho produto : itensCarrinho1) {
//            when(estoqueService.getProduto(produto.getCodProduto())).thenReturn(itemEstoque);
//        }
//
//        // THEN
//        assertEquals(0, vendaService.cadastraVenda(vendas.get(0)));
//    }
//
//    // TODO: fazer o "RestricaoVendaFactory" funcionar com o mockStatic
//    @Test
//    public void canNotAddVendaWithInvalidTime(){
//        // GIVEN
//
//        // WHEN
//
//        // THEN
////        assertEquals(1, vendaService.cadastraVenda(vendas.get(0)));
//    }
//
//    // TODO: fazer o "RestricaoVendaFactory" funcionar com o mockStatic
//    @Test
//    public void canNotAddVendaWithLargerQuantity(){
//        // GIVEN
//
//        // WHEN
//        for (ItemCarrinho produto : itensCarrinho1) {
//            when(estoqueService.podeVender(produto.getCodProduto(), produto.getQuantidade())).thenReturn(false);
//        }
//
//        // THEN
//        assertEquals(2, vendaService.cadastraVenda(vendas.get(0)));
//    }
}