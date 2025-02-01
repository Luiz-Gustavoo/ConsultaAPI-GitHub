package br.com.pratica.consultaapigithub.services;

import java.io.File;
import java.util.Scanner;

public class LerArquivo {

    public void lerArquivo() {
        System.out.println("Listagem de usuários: ");
        File arquivoLeitura = new File("Usuarios.txt");
        try {
            Scanner leitor = new Scanner(arquivoLeitura);
            while(leitor.hasNextLine()) {
                String texto = leitor.nextLine();
                System.out.println(texto);
            }
            leitor.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
