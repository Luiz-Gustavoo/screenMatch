package br.com.alura.screenmatch.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ConverteDados {
    Gson gson = new GsonBuilder().create();

    public <T> T converteDados(String json, Class<T> classe) {
        try {
            return gson.fromJson(json, classe);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
