package services;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * Created by cristian on 12-04-16.
 */
public class ExampleMail {

        private final String USER_AGENT = "Mozilla/5.0";

//        public static void main(String[] args) throws Exception {
//
//            ExampleMail http = new ExampleMail();
//
//            System.out.println("Testing 1 - Send Http GET request");
//            http.sendGet("garzoncristianc@gmail.com", "Oye Papi Comooooo", "Todo bien cabron?");
//        }

        // HTTP GET request
        public void sendGet(String toEmail, String subject, String message) throws Exception {
            message = message.replace(" ","%20");
            subject = subject.replace(" ","%20");

            String url = "http://icom.marcosantoli.com/index.php?" +
                    "Security=d1452f3b107b8a279489103f269650c2&" +
                    "toemail=" + toEmail + "&" +
                    "subject=" + subject + "&" +
                    "message=" + message + "&" +
                    "fromemail=support_team@turn4u.com&" +
                    "fromname=Turn4u Support Team";

            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            // optional default is GET
            con.setRequestMethod("GET");

            //add request header
            con.setRequestProperty("User-Agent", USER_AGENT);

            int responseCode = con.getResponseCode();
            System.out.println("\nSending 'GET' request to URL : " + url);
            System.out.println("Response Code : " + responseCode);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            //print result
            System.out.println(response.toString());

        }
}
