package br.com.pratica.consultaapigithub;

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
		System.out.println("teste");

		try{
			HttpClient httpClient = HttpClient.newHttpClient();
			HttpRequest httpRequest = HttpRequest.newBuilder()
					.uri(URI.create("https://api.github.com/users/Luiz-Gustavoo"))
					.build();

			HttpResponse httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

			System.out.println(httpResponse.body());

		} catch(Exception e) {

		}
	}


}
