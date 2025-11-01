package br.com.leonardo;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.*;
import java.net.*;
import java.time.Duration;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        System.setProperty("java.net.preferIPv6Addresses", "false");
        System.setProperty("java.net.preferIPv4Stack", "true");

        System.setProperty("sun.net.spi.nameservice.provider.1", "dns,sun");
        System.setProperty("sun.net.spi.nameservice.nameservers", "1.1.1.1");

        try (Socket s = new Socket()) {
            s.connect(new InetSocketAddress("pokeapi.co", 443), 5000);
            System.out.println("✅ Conexão TCP direta com pokeapi.co funcionou");
        } catch (Exception e) {
            e.printStackTrace();
        }

        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(Duration.ofSeconds(15))
                .readTimeout(Duration.ofSeconds(20))
                .retryOnConnectionFailure(true)
                .build();

        Request request = new Request.Builder()
//                .url("https://104.21.0.186/api/v2/pokemon/pikachu")
                .url("https://pokeapi.co/api/v2/pokemon/pikachu")
                .header("Host", "pokeapi.co")
                .build();

        try (Response response = client.newCall(request).execute()) {
            System.out.println(response.body().string().substring(0, 200));
        }

    }
}
