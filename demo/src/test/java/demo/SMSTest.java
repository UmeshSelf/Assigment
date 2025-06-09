package demo;


   import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

    public class SMSTest {

        // Plivo authentication credentials
        private static final String AUTH_ID = "your_auth_id";
        private static final String AUTH_TOKEN = "your_auth_token";
        private static final String SEND_MESSAGE_URL = "https://api.plivo.com/v1/Account/%s/Message/";

        private HttpClient httpClient;

        @Before
        public void setUp() {
            httpClient = HttpClients.createDefault();
            // Additional setup if needed
        }

        @After
        public void tearDown() {
            // Cleanup resources if needed
            httpClient.getConnectionManager().shutdown();
        }

        private void sendMessage(String source, String destination, String message) throws IOException {
            HttpPost post = new HttpPost(String.format(SEND_MESSAGE_URL, AUTH_ID));
            post.setHeader("Authorization", "Basic " + java.util.Base64.getEncoder().encodeToString((AUTH_ID + ":" + AUTH_TOKEN).getBytes()));

            StringEntity entity = new StringEntity(String.format("{\"src\":\"%s\",\"dst\":\"%s\",\"text\":\"%s\"}", source, destination, message));
            entity.setContentType("application/json");
            post.setEntity(entity);

            HttpResponse response = httpClient.execute(post);
            assertEquals(202, response.getStatusLine().getStatusCode());  // Assuming Plivo returns 202 for success
            EntityUtils.consume(response.getEntity());
        }

        private List<String[]> readCustomerData(String csvFile) throws IOException {
            List<String[]> customerData = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
                String line;
                while ((line = br.readLine()) != null) {
                    customerData.add(line.split(","));
                }
            }
            return customerData;
        }

        @Test
        public void testSendSMS() throws IOException {
            List<String[]> customerData = readCustomerData("customer_message.csv");
            int customerId = 1;  // Adjust as per your test data
            String source = customerData.get(customerId)[1];
            String destination = customerData.get(customerId)[2];
            String message = String.format("Sending the SMS to customer id %s, src=%s and dst=%s", customerId, source, destination);

            sendMessage(source, destination, message);
        }

        // Additional test cases can be added for different scenarios
    }


