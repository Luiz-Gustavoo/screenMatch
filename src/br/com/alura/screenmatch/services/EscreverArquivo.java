package br.com.alura.screenmatch.services;

import br.com.alura.screenmatch.modelos.Titulo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class EscreverArquivo {
    File arquivo = new File("Filmes.txt");
    Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    public void escreverArquivo(List<Titulo> listaTitulos) {
        try {
            FileWriter escrever = new FileWriter(arquivo);
            escrever.write(gson.toJson(listaTitulos));
            escrever.close();

        } catch (FileNotFoundException e) {
            System.out.println("Não foi possível salvar o arquivo");
        } catch (IOException e) {
            System.out.println("Aconteceu um erro inesperado");
        }
    }
}
