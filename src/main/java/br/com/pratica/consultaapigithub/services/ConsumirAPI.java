package br.com.pratica.consultaapigithub.services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumirAPI {
    HttpClient client = HttpClient.newHttpClient();
    HttpResponse<String> response;

    public String consumirAPI(String endereco) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereco))
                    .build();

            response = client.send(request, HttpResponse.BodyHandlers.ofString());

        }  catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String json = response.body();
        return json;
    }
}
