package com.blit;

import java.net.http.*;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.temporal.ChronoUnit;

// import javax.json;
// import org.glassfish.json;
// import javax.json.Json;
// import org.glassfish.json.*;
// import javax.json.JsonReader;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;

public class AlpacaCryptoBot {
        
	String apiKey = "PKQAD7Z6M8ORAHZO36F3";
    String apiSecret = "xzvxQcLOZ7nWpeXUiDjar9WVje8QuBHDfnrvDNJH";
    String apiEndpointType = "paper"; // || live.
    String apiDataType = "iex"; // must be either "iex" or "sip".
    String endpoint = "https://paper-api.alpaca.markets/v2";
    String endpointLive = "https://api.alpaca.markets/v2";

    public AlpacaCryptoBot () {
        System.out.println("Alpaca Crypto Bot v1.0.0");
        System.out.println("------------------------");

        try {
            this.printURIInfo(endpoint+"/account");
            
            HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(endpoint+"/account"))
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
            System.out.println("Status Code: " + resp.statusCode());
            String jsonText = resp.body().toString();
            //System.out.println(jsonText);
            this.parseResp(jsonText);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void parseResp (String resp) {
        // JSONObject reader = new JSONObject();
        // Json json = new Json();
        // JsonReader reader = new JsonReader();
        String fname = "/home/danny/binarylogic/AlpacaCryptoBot/output.json";
        try {
            InputStream fis = new FileInputStream(fname);
            JsonReader jsonReader = Json.createReader(fis);
        } catch (Exception e) {
            System.out.println("Cannot open file: "+fname);
            e.printStackTrace();
        }
    }

    private void printURIInfo (String uriText) {
        try {
            URI uri = new URI(uriText);
            System.out.println("Host: " + uri.getHost());
            System.out.println("Port: " + uri.getPort());
            System.out.println("Query: " + uri.getQuery());
            System.out.println("Path: " + uri.getPath());
            System.out.println("Raw Path: " + uri.getRawPath());
            System.out.println("Scheme: " + uri.getScheme());
            System.out.println("Resolve: " + uri.resolve(uri));
        } catch (Exception e) {
            System.out.println("Cannot create URI: "+uriText);
        }
    }
}