package org.assignment.carassignment.controller;

import com.google.gson.Gson;
import org.assignment.carassignment.model.Car;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class APIServiceController {

    private static final String API_BASE_URL = "https://cars-by-api-ninjas.p.rapidapi.com/v1/cars";
    private static final String API_KEY = "9c8331f91cmshc0a14a305cef8d7p1c970ejsnce521a754374";

    public static Car[] fetchData(String model, String manufacturer) {
        try {
            // Build the query parameters based on selected options
            StringBuilder queryBuilder = new StringBuilder();
            if (model != null && !model.isEmpty()) {
                queryBuilder.append("model=").append(model);
            }
            if (manufacturer != null && !manufacturer.isEmpty()) {
                if (queryBuilder.length() > 0) {
                    queryBuilder.append("&");
                }
                queryBuilder.append("make=").append(manufacturer);
            }
            // Construct the full API URL
            String apiUrl = API_BASE_URL + "?" + queryBuilder.toString();

            // Make the HTTP request
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(apiUrl))
                    .header("X-RapidAPI-Key", API_KEY)
                    .header("X-RapidAPI-Host", "cars-by-api-ninjas.p.rapidapi.com")
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();

            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Parse the JSON response into Car objects
            Gson gson = new Gson();
            return gson.fromJson(response.body(), Car[].class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
