package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.excecao.ErroDeConversaoDeAnoException;
import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloOmdb;
import br.com.alura.screenmatch.services.ConsumirAPI;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        Scanner teclado = new Scanner(System.in);

        String busca = "";
        List<Titulo> titulos = new ArrayList<>();

        while (!busca.equalsIgnoreCase("sair")) {

            System.out.println("Qual filme quer buscar?: ");
            busca = teclado.nextLine();

            if (busca.equalsIgnoreCase("sair")) {
                break;
            }

            busca = busca.replaceAll("\\s", "+");

            String endereco = ("https://omdbapi.com/?t=" + busca + "&apikey=7589c63");
            ConsumirAPI consumirAPI = new ConsumirAPI();
            String retornoAPI = consumirAPI.consumirAPI(endereco);
            System.out.println(retornoAPI);
        }

        FileWriter escrita = new FileWriter("Filmes.txt");
        escrita.write(gson.toJson(titulos));
        escrita.close();

        try {
            File arquivo = new File("Filmes.txt");
            Scanner leitura = new Scanner(arquivo);

            while (leitura.hasNextLine()) {
                String texto = leitura.nextLine();
                System.out.println(texto);
            }
            leitura.close();
        } catch (FileNotFoundException e) {
            System.out.println("Não foi possível encontrar o arquivo. Verifique se ele existe e  se o nome está correto");
        }

        System.out.println("Programa finalizado");
    }
}

