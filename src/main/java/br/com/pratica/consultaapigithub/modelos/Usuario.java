package br.com.pratica.consultaapigithub.modelos;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Usuario(@JsonAlias("login") String nome,
                      @JsonAlias("id") int id,
                      @JsonAlias("html_url") String url_usuario) {

    @Override
    public String toString() {
        return
                "Nome: " + nome + '\n' +
                "Id: " + id + '\n' +
                "URL do usuário: " + url_usuario + '\n';
    }
}
