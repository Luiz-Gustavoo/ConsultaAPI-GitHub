package br.com.pratica.consultaapigithub.services;

import java.io.FileWriter;
import java.io.IOException;

public class GravarEmArquivo {

    public void gravarEmArquivo(String dados, String arquivo) {
        try {
            FileWriter arquivoUsuario = new FileWriter(arquivo);
            arquivoUsuario.write(dados);
            arquivoUsuario.close();
            System.out.println("Informações salvas no arquivo");
        } catch(IOException e ) {
            System.out.println(e.getMessage());
        }
    }
}
