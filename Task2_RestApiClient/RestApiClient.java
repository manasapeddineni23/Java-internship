import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/*
 * Task 2: REST API Client
 * This program consumes a public REST API and
 * displays structured weather data.
 */

public class RestApiClient {

    public static void main(String[] args) {

        try {
            String city = "London";
            String apiKey = "YOUR_API_KEY"; // Replace with your API key

            String apiUrl = "https://api.openweathermap.org/data/2.5/weather?q="
                    + city + "&appid=" + apiKey + "&units=metric";

            // Create URL and connection
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Read API response
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));

            String line;
            StringBuilder response = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // Display response
            System.out.println("Weather API Response:");
            System.out.println(response.toString());

        } catch (Exception e) {
            System.out.println("Error while calling REST API");
            e.printStackTrace();
        }
    }
}
