package br.com.alura.screenmatch.excecao;

public class ErroDeConvesaoDeAnoExeption extends RuntimeException {
    private String mensagem;
    public ErroDeConvesaoDeAnoExeption(String s) {
        this.mensagem = mensagem;
    }

    @Override
    public String getMessage() {
        return this.mensagem;
    }
}
