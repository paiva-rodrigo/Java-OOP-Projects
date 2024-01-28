package br.com.alura.minhasmusicas.modelos;

public class MinhasPreferidas {
    public String getMenssagem() {
        return menssagem;
    }

    public void setMenssagem(String menssagem) {
        this.menssagem = menssagem;
    }

    private String menssagem = "";
    public void inclui(Audio audio){
        if(audio.getClassificacao() >= 9) {
            menssagem = audio.getTitulo() +" é considerado sucesso absoluto e preferido por todos!";
        }
        else {
            menssagem = audio.getTitulo() +" também é um dos que todo mundo está curtindo";
        }
    }
}
