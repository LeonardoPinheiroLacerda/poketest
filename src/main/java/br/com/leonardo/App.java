package br.com.leonardo;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        String pokemon = "charmander";
        String url = "https://pokeapi.co/api/v2/pokemon/" + pokemon;

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .timeout(Duration.ofSeconds(10))
                .uri(URI.create(url))
                .GET()
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("Status code: " + response.statusCode());
            System.out.println("Response body:\n" + response.body());

        } catch (IOException | InterruptedException e) {
            System.err.println("Request failed: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
