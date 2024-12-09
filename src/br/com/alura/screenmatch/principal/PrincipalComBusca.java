package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
        String filme = teclado.nextLine();
        //filme = filme.replaceAll("\\s", "+");

        String endereco = ("https://omdbapi.com/?t="+filme+"&apikey=7589c63");
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereco))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();

            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();

            TituloOmdb TituloOmdb = gson.fromJson(json, TituloOmdb.class);

            //try {
            Titulo tituloConvertido = new Titulo(TituloOmdb);
            System.out.println("*****Título convertido*****");
            System.out.println(tituloConvertido);
        } catch (NumberFormatException erro) {
            System.out.println("Erro na conversão de texto para número");

        } catch (IllegalArgumentException erro) {
            System.out.println("Erro de argumento na busca. Verifique o parâmetro que está sendo buscado");
        } finally {
            System.out.println("Fim da execução");
        }
    }
}

