package br.com.alura.screenmatch.calculo;

public class FiltroRecomendacao {
    private String recomendacao;

    public void filtra(Classificavel classificavel) {
        if (classificavel.getClassificacao() >= 4) {
            System.out.println("Um dos preferidos do momento");
        } else if(classificavel.getClassificacao() >=2) {
            System.out.println("Muito bem avaliado no momento");
        } else {
            System.out.println("Adicione para assistir depois");
        }

    }
}
