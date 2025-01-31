package br.com.pratica.consultaapigithub;

import br.com.pratica.consultaapigithub.modelos.Usuario;
import br.com.pratica.consultaapigithub.services.ConsumirAPI;
import br.com.pratica.consultaapigithub.services.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@SpringBootApplication
public class ConsultaapigithubApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ConsultaapigithubApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ConsumirAPI consumirAPI = new ConsumirAPI();
		ConverteDados converteDados = new ConverteDados();

		//tchurusbangu
		ResultadoRequisicao respostaAPI = consumirAPI.consumirAPI("https://api.github.com/users/Luiz-Gustavoo");
		if (!respostaAPI.isResultado()) {
			System.out.println("Não foi possível localizar o usuário buscado");
		} else {
			System.out.println("Dados do usuário buscado: ");
			Usuario usuarioConvertido = converteDados.converteDados(respostaAPI.getJsonResultado(), Usuario.class);
			System.out.println(usuarioConvertido);
		}
	}
}
