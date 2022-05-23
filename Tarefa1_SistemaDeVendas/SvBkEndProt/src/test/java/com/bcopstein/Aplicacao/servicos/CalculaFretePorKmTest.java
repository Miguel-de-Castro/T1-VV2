package com.bcopstein.Aplicacao.servicos;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.net.URISyntaxException;


import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CalculaFretePorKmTest {

    @InjectMocks
    private CalculaFretePorKm calculaFretePorKm;

    @Test
    public void mustCalculaFretePorKmTest() throws URISyntaxException, IOException, InterruptedException {
        double response = calculaFretePorKm.calculaFrete("portoalegre", "canoas");
        assertEquals(17.0, response, 17.0);
    }

    @Test
    public void mustCalculaFretePorKmTestWrongDestination() throws URISyntaxException, IOException, InterruptedException {
        double response = calculaFretePorKm.calculaFrete("portoalegre", "canddoas");
        assertEquals(0, response, 0);
    }

    @Test
    public void mustCalculaFretePorKmTestWithoutDestination() throws URISyntaxException, IOException, InterruptedException {
        double response = calculaFretePorKm.calculaFrete("portoalegre", "");
        assertEquals(0, response, 0);
    }
}