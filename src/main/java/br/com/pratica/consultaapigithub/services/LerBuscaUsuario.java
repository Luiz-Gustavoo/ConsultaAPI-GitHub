package br.com.pratica.consultaapigithub.services;

import java.util.Scanner;

public class LerBuscaUsuario {
    private Scanner scanner = new Scanner(System.in);

    public String lerBuscaUsuario() {
        System.out.println("\nDigite o usuário que deseja buscar: ");
        return scanner.nextLine();
    }
}
