package br.com.alura.screenmatch.modelos;

public class Filme extends Titulo{
    private String diretor;

    public Filme(String nome, int anoLancamento) {
        super(nome, anoLancamento);
    }

    @Override
    public String toString() {
        return "Filme: " + this.getNome() + "("+this.getAnoDeLancamento() + ")";
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

}
