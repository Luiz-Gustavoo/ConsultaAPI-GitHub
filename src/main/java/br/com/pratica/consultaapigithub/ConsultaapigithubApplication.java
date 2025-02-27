package br.com.pratica.consultaapigithub;

import br.com.pratica.consultaapigithub.modelos.Usuario;
import br.com.pratica.consultaapigithub.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ConsultaapigithubApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ConsultaapigithubApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Usuario> listaUsuarios = new ArrayList<>();
		ConsumirAPI consumirAPI = new ConsumirAPI();
		ConverteDados converteDados = new ConverteDados();
		LerBuscaUsuario lerBuscaUsuario = new LerBuscaUsuario();
		String buscaUsuario = "";

		while(!buscaUsuario.equalsIgnoreCase("sair")) {
			buscaUsuario = lerBuscaUsuario.lerBuscaUsuario();
			if(buscaUsuario.equalsIgnoreCase("sair")) {
				break;
			}
			//tchurusbangu
			ResultadoRequisicao respostaAPI = consumirAPI.consumirAPI("https://api.github.com/users/"+buscaUsuario);
			if (!respostaAPI.isResultado()) {
				System.out.printf("Não foi possível localizar o usuário '%s'", buscaUsuario);
			} else {
				System.out.println("Dados do usuário buscado: ");
				Usuario usuarioConvertido = converteDados.converteDados(respostaAPI.getJsonResultado(), Usuario.class);
				listaUsuarios.add(usuarioConvertido);
				System.out.println(usuarioConvertido);
			}
		}
		System.out.println("Programa finalizado");

		GravarEmArquivo gravarEmArquivo = new GravarEmArquivo();
		gravarEmArquivo.gravarEmArquivo(listaUsuarios.toString(), "Usuarios.txt");

		LerArquivo lerArquivo = new LerArquivo();
		lerArquivo.lerArquivo();
	}
}
