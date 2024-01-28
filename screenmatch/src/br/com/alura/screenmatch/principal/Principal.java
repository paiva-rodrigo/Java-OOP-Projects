package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.calculos.CalculadoraDeTempo;
import br.com.alura.screenmatch.calculos.FiltroRecomendacao;
import br.com.alura.screenmatch.modelos.Episodio;
import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        Filme meuFilme = new Filme("Lost",2000);
        //meuFilme.setNome("Lost");
        //meuFilme.setAnoDeLancamento(2000);
        meuFilme.setDuracaoEmMinutos(180);
        System.out.println("Duração doo filme: "+ meuFilme.getDuracaoEmMinutos());

        meuFilme.exibeFichaTecnicaa();
        meuFilme.avalia(8);
        meuFilme.avalia(5);
        meuFilme.avalia(10);
        System.out.println("média: "+meuFilme.pegaMedia());

        meuFilme.setSomaDasAvaliacoes(10);
        meuFilme.setTotalDeAvaliacoes(1);
        System.out.println("média: "+meuFilme.pegaMedia());

        Serie lost = new Serie("Lost",2000);
        //lost.setNome("Lost");
        //lost.setAnoDeLancamento(2000);
        lost.exibeFichaTecnicaa();
        lost.setTemporadas(10);
        lost.setEpisodiosPorTemporada(10);
        lost.setMinutosPorEpisodio(50);
        System.out.println("Duracao para maratonar Lost: "+lost.getDuracaoEmMinutos());

        Filme outroFilme = new Filme("Avatar",2023);
        //outroFilme.setNome("Avatar");
        //outroFilme.setAnoDeLancamento(2023);
        outroFilme.setDuracaoEmMinutos(200);

        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.inclui(meuFilme);
        calculadora.inclui(outroFilme);
        calculadora.inclui(lost);
        System.out.println("Duracao: " + calculadora.getTempoTotal());

        FiltroRecomendacao filtro = new FiltroRecomendacao();
        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setSerie(lost);
        episodio.setTotalVisualizacoes(300);
        filtro.filtra(episodio);

        Filme filmeDoPaulo = new Filme("Dogville",2003);
        filmeDoPaulo.setDuracaoEmMinutos(200);
        //filmeDoPaulo.setNome("DogVille");
        //filmeDoPaulo.setAnoDeLancamento(2003);
        filmeDoPaulo.avalia(10);

        ArrayList<Filme> listaDeFilmes = new ArrayList<>();
        listaDeFilmes.add(filmeDoPaulo);
        listaDeFilmes.add(meuFilme);
        listaDeFilmes.add(outroFilme);
        System.out.println("Tamanho da lista: "+listaDeFilmes.size());
        System.out.println("Primeiro Filme: "+listaDeFilmes.get(0).getNome());
        System.out.println(listaDeFilmes);
        System.out.println("toString Primeiro Filme: "+listaDeFilmes.get(0).toString());



    }
}