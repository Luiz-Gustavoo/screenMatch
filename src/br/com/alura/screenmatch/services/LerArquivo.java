package br.com.alura.screenmatch.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LerArquivo {
    ;


    public void lerArquivo(String arquivoLeitura) throws FileNotFoundException {
        try {
            File arquivo = new File(arquivoLeitura);
            Scanner leitor = new Scanner(arquivo);
            while(leitor.hasNextLine()) {
                String texto = leitor.nextLine();
                System.out.println(texto);
            }
            leitor.close();
        } catch (Exception e) {
            System.out.println("Aconteceu um erro inesperado");
        }
    }
}
