package com.blit;

import java.net.http.*;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.temporal.ChronoUnit;

// import javax.json;
//import org.glassfish.json;
import org.glassfish.json.api.*;

public class AlpacaCryptoBot {
        
	String apiKey = "PKQAD7Z6M8ORAHZO36F3";
    String apiSecret = "xzvxQcLOZ7nWpeXUiDjar9WVje8QuBHDfnrvDNJH";
    String apiEndpointType = "paper"; // || live.
    String apiDataType = "iex"; // must be either "iex" or "sip".
    String endpoint = "https://paper-api.alpaca.markets/v2/account";
    String endpointLive = "https://api.alpaca.markets/v2/account";

    public AlpacaCryptoBot () {
        System.out.println("Alpaca Crypto Bot v1.0.0");
        System.out.println("------------------------");

        try {
            URI uri = new URI(endpoint);

            System.out.println("Host: " + uri.getHost());
            System.out.println("Port: " + uri.getPort());
            System.out.println("Query: " + uri.getQuery());
            System.out.println("Path: " + uri.getPath());
            System.out.println("Raw Path: " + uri.getRawPath());
            System.out.println("Scheme: " + uri.getScheme());
            System.out.println("Resolve: " + uri.resolve(uri));
            
            HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(endpoint))
                .version(HttpClient.Version.HTTP_2)
                .headers("APCA-API-KEY-ID", apiKey, 
                         "APCA-API-SECRET-KEY", apiSecret)
                .header("key", "value")
                .timeout(Duration.of((long)10, ChronoUnit.SECONDS))
                .GET()
                .build();
            
            HttpResponse resp = HttpClient.newBuilder()
                .build()
                .send(request, BodyHandlers.ofString());
            
            //System.out.println("Headers: " + resp.headers());
            System.out.println("Code: " + resp.statusCode());
            //System.out.println("Response: " + resp.body());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}