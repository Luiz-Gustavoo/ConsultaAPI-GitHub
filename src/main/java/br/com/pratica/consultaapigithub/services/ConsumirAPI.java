package br.com.pratica.consultaapigithub.services;

import br.com.pratica.consultaapigithub.ResultadoRequisicao;
import br.com.pratica.consultaapigithub.excecoes.UsuarioNaoEncontradoException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumirAPI {
    HttpClient client = HttpClient.newHttpClient();
    HttpResponse<String> response;

    public ResultadoRequisicao consumirAPI(String endereco) {
        String json = null;
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereco))
                    .build();

            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if(response.statusCode() == 404) {
                json = response.body();
                throw new UsuarioNaoEncontradoException("Usuário não encontrado");
            }
        }  catch (IOException | InterruptedException e) {
            System.out.println("Aconteceu um erro inesperado");
        } catch (UsuarioNaoEncontradoException e) {
            System.out.println(e.getMessage());
            return new ResultadoRequisicao("usuário não encontrado", false, json);
        }
        json = response.body();
        return new ResultadoRequisicao("usuário encontrado", true, json);
    }
}
