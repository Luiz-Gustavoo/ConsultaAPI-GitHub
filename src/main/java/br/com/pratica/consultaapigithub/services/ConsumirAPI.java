package br.com.pratica.consultaapigithub.services;

import br.com.pratica.consultaapigithub.excecoes.UsuarioNaoEncontradoException;

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
            if(response.statusCode() == 404) {
                throw new UsuarioNaoEncontradoException("Usuário não encontrado");
            }

        }  catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (UsuarioNaoEncontradoException e) {
            System.out.println(e.getMessage());
        }
        String json = response.body();
        return json;
    }
}
