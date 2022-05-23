package com.bcopstein.Aplicacao.servicos;

import com.bcopstein.Negocio.entidades.ItemCarrinho;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ImpostoUmTest {
    @InjectMocks
    private ImpostoUm impostoUm;

    @Test
    public void calculaImposto(){
        impostoUm = new ImpostoUm();
        ItemCarrinho itemCarrinho1 = new ItemCarrinho(1,10,1);
        ItemCarrinho itemCarrinho2 = new ItemCarrinho(1,10,1);
        List<ItemCarrinho> itensCarrinho1 = Arrays.asList(itemCarrinho1,itemCarrinho2);
        int imposto = 20 * 12 / 100;

        assertEquals(imposto, impostoUm.calculaImposto(itensCarrinho1));
    }
}