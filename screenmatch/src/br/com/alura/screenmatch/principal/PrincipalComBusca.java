package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.excecao.ErroDeConvesaoDeAnoExeption;
import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leitura = new Scanner(System.in);
        var buscaString ="";
        List<Titulo> titulos = new ArrayList<>();

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        while (!buscaString.equalsIgnoreCase("sair")) {

            System.out.println("Digite um filme para a busca: ");
            buscaString = leitura.nextLine();

            if(buscaString.equalsIgnoreCase("sair")){
                break;
            }

            String endereco = "https://www.omdbapi.com/?t=" + buscaString.replace(" ", "+") + "&apikey=aaac4859";
            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(endereco))
                        .build();
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();
                System.out.println(json);

                TituloOmdb meuTituloOmdb = gson.fromJson(json, TituloOmdb.class);
                System.out.println(meuTituloOmdb);

                Titulo meuTitulo = new Titulo(meuTituloOmdb);
                System.out.println("Titulo já convertido!");
                System.out.println(meuTitulo);

                titulos.add(meuTitulo);
            } catch (NumberFormatException e) {
                System.out.println("Aconteceu um erro de NumberFormat: \n" + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Aconteceu um erro de Argumento: \n" + e.getMessage());
            } catch (ErroDeConvesaoDeAnoExeption e) {
                System.out.println("Aconteceu um erro ErroDeConvesaoDeAnoExeption: \n" + e.getMessage());
            }
        }
        System.out.println("lista"+titulos);

        FileWriter escrita = new FileWriter("fimes.json");
        escrita.write(gson.toJson(titulos));
        escrita.close();

        System.out.println("Finalizou!");

    }
}
