/*
Marcus Harrington API Assignment
this file reads information from a website and parses JSON into useable data
Last Date Modified 9/13/22
I have adherred to the UNCG Academic policy
 */
package apiassignmentmarcusharrington;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.*;
import java.net.http.HttpResponse;
import java.net.http.HttpClient;
import java.net.URI;
import java.net.URISyntaxException;
import org.json.JSONObject;

public class APIAssignmentMarcusHarrington {

    public static void main(String[] args) {
        try {
            String webLink = "https://en.wikipedia.org/w/api.php?action=query&prop=extracts&exsentences=10&exlimit=1&titles=API&explaintext=1&formatversion=2&format=json";
            HttpRequest quest = HttpRequest.newBuilder(new URI(webLink)).GET().build();
            HttpClient client = HttpClient.newBuilder().build();
            HttpResponse<String> response = client.send(quest, BodyHandlers.ofString());
            JSONObject textTemp = new JSONObject(response.body());
            String pageText = textTemp.getJSONObject("query").getJSONArray("pages").getJSONObject(0).getString("extract");
            System.out.println(pageText);
        } catch (IOException | InterruptedException | URISyntaxException e) {
        }
    }
}

