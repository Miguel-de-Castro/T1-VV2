package com.bcopstein.Negocio.servicos;

import java.io.IOException;
import java.net.URISyntaxException;

public interface ICalculoFrete {
    Double calculaFrete(String origem, String destino) throws URISyntaxException, IOException, InterruptedException;
}
