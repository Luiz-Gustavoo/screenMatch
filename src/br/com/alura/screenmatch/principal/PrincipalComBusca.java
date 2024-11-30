package br.com.alura.screenmatch.principal;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner teclado = new Scanner(System.in);
        System.out.println("Qual filme quer buscar?: ");
        String filme = teclado.nextLine(); // usar o replace para trocar espaçosvazios por + e passar na url
        filme = filme.replaceAll("\\s", "+");
        System.out.println(filme);

        String endereco = ("https://omdbapi.com/?t="+filme+"&apikey=7589c63");

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();

        HttpResponse response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
    }
}
