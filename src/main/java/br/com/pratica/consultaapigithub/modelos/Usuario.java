package br.com.pratica.consultaapigithub.modelos;

import com.fasterxml.jackson.annotation.JsonAlias;

public record Usuario(@JsonAlias("Login") String nome,
                      @JsonAlias("id") int id,
                      @JsonAlias("html_url") String email) {
}
