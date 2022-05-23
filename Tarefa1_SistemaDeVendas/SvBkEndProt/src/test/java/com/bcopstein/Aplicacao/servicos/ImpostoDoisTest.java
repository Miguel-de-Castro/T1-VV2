package com.bcopstein.Aplicacao.servicos;

import com.bcopstein.Negocio.entidades.ItemCarrinho;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ImpostoDoisTest {
    @InjectMocks
    private ImpostoDois impostoDois;

    @Test
    public void calculaImpostoMenos8000(){
        impostoDois = new ImpostoDois();
        ItemCarrinho itemCarrinho1 = new ItemCarrinho(1,10,1);
        ItemCarrinho itemCarrinho2 = new ItemCarrinho(1,10,1);
        List<ItemCarrinho> itensCarrinho1 = Arrays.asList(itemCarrinho1,itemCarrinho2);
        int imposto = 20 * 15 / 100;

        assertEquals(imposto, impostoDois.calculaImposto(itensCarrinho1));
    }

    @Test
    public void calculaImpostoMais8000(){
        impostoDois = new ImpostoDois();
        ItemCarrinho itemCarrinho1 = new ItemCarrinho(1,5000,1);
        ItemCarrinho itemCarrinho2 = new ItemCarrinho(1,5000,1);
        List<ItemCarrinho> itensCarrinho1 = Arrays.asList(itemCarrinho1,itemCarrinho2);
        int porcentagemImposto = 15;
        int valorTotalCompra = 0;
        int valorMin = 8000;
        for (ItemCarrinho produto : itensCarrinho1) {
            valorTotalCompra += produto.getPrecoProd() * produto.getQuantidade();
        }

        int imposto = 0;
        if (valorTotalCompra > valorMin) {

            int valorRestante = valorTotalCompra - valorMin;
            int valorParcial = valorMin * porcentagemImposto / 100;

            porcentagemImposto = 20;
            valorRestante = valorRestante * porcentagemImposto / 100;

            imposto = valorParcial + valorRestante;
        }

        assertEquals(imposto, impostoDois.calculaImposto(itensCarrinho1));
    }
}