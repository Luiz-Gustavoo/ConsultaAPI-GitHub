package br.com.pratica.consultaapigithub.modelos;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Usuario(@JsonAlias("login") String nome,
                      @JsonAlias("id") int id,
                      @JsonAlias("html_url") String url_usuario) {
}
