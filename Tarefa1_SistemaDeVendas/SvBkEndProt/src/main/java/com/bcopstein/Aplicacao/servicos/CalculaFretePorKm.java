package com.bcopstein.Aplicacao.servicos;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import org.json.JSONObject;

import com.bcopstein.Negocio.servicos.ICalculoFrete;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

/**
 * CalculaFretePorKm
 */
@Component
public class CalculaFretePorKm implements ICalculoFrete{

	@Override
	public Double calculaFrete(String origem, String destino) throws URISyntaxException, IOException, InterruptedException {
        //TODO: fazer o tratamento das strings - Não pode ter espaço caso seja nome composto
        if(destino.equalsIgnoreCase("")){
            destino = "erro";
        }
        try {

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
            .uri(new URI("http://dev.virtualearth.net/REST/V1/Routes?wp.0=" + origem + "&wp.1=" + destino + "&key=ArvBR0I2N1OZmbFVFHSLRkGIDTO09euklXKE-AR74bIFgAV5ytVBnUxZurUacBhV"))
            .GET()
            .build();
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString()); 
//            System.out.println(response.body());

            JSONObject json = new JSONObject(response.body());
            double distance = json.getJSONArray("resourceSets").getJSONObject(0).getJSONArray("resources").getJSONObject(0).getDouble("travelDistance");
            //System.out.println(distance);
            return distance;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println("aaaaaaaa" + e.getMessage());
            return 0.0;
        }
        
	}

    
}