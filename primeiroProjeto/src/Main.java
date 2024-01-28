//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Esse é o screen match");
        System.out.println("Filme: Top Gum:Marevic");

        int anoDeLancamento = 2022;
        System.out.println("ano de lançamento: "+anoDeLancamento);
        boolean incluidoNoPlano = true;
        double notaDoFilme = 3.2;

        //media calculada
        double media = (9.8+6.3+8.99)/3;

        //aspas simples não posso pular linha, mas com aspas triplas eu posso
        String sinopse = """
                Filme Top Gum
                Filme dos anos 80
                Muito bom!
                Ano de lançamento
                """ + anoDeLancamento;
        System.out.println(sinopse);

        //forçando o java a converter o resultado em inteiro;
        int classificacao = (int)(media/2);
        System.out.println(classificacao);

    }
}