
package connecttoapi2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.*;
/**
 *
 * @author diego
 */
public class ConnectToAPI2 {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) {
        String baseUrl = "https://developers.zomato.com/api";
        String version = "/v2.1";
        String getRequest = "/geocode";
        final String lat = "lat=36.066984";
        final String lon = "lon=-79.800178";
        String apiKey = "680201a1d38ff559b9c8b20ffde6db61";
        String urlString = baseUrl + version + getRequest + "?" + lat + "&" + lon;
        
        URL url;
        System.out.println("Marker 1");
        try {
        System.out.println("Marker 2");
            url = new URL(urlString);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestProperty("Accept", "application/json" );
            con.setRequestProperty("user-key", "0a71dc953812d0958a14168a49b5acfd" );
            con.setRequestMethod("GET");
        System.out.println("Marker 3");

            int status = con.getResponseCode();
            
            System.out.println("Response Code: " + status);
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            con.disconnect();
            System.out.println("Output: " + content.toString());
            JSONObject obj = new JSONObject(content.toString());
            String movieName = obj.getString("popularity");
            System.out.println("Top Cuisines: " + movieName);
        } catch (Exception ex) {
            Logger.getLogger(ConnectToAPI2.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
    }
    
}
