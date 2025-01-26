package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloOmdb;
import br.com.alura.screenmatch.services.ConsumirAPI;
import br.com.alura.screenmatch.services.ConverteDados;
import br.com.alura.screenmatch.services.EscreverArquivo;
import br.com.alura.screenmatch.services.LerArquivo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {

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

            ConverteDados converteDados = new ConverteDados();
            TituloOmdb tituloOmdb = converteDados.converteDados(retornoAPI, TituloOmdb.class);
            Titulo tituloConvertido = new Titulo(tituloOmdb);
            titulos.add(tituloConvertido);

        }
        EscreverArquivo salvarTitulo = new EscreverArquivo();
        salvarTitulo.escreverArquivo(titulos);

        LerArquivo lerTitulo = new LerArquivo();
        lerTitulo.lerArquivo();


        System.out.println("Programa finalizado");
    }
}

