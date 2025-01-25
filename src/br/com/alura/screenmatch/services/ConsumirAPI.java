package br.com.alura.screenmatch.services;

import br.com.alura.screenmatch.excecao.ErroDeConversaoDeAnoException;
import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloOmdb;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumirAPI {
    private HttpClient httpClient = HttpClient.newHttpClient();
    private HttpResponse<String> response;


    public String consumirAPI(String endereco) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereco))
                    .build();

            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());


        } catch (NumberFormatException erro) {
            System.out.println("Erro na conversão de texto para número");

        } catch (IllegalArgumentException erro) {
            System.out.println("Erro de argumento na busca. Verifique o parâmetro que está sendo buscado");
        } catch (ErroDeConversaoDeAnoException erro) {
            System.out.println(erro.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("Fim da execução");
        }
        String  json = response.body();
        return json;
    }
}
