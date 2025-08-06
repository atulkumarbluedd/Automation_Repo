package kafka.tests;
import kafka.Utils.KafkaConsumerUtils;
import kafka.Utils.KafkaProducerUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;
import java.util.List;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.given;
import static kafka.Utils.KafkaConsumerUtils.consumeMessages;

import com.google.gson.*;
public class KafkaMessageValidationTest {
    @Test
    public void validateKafkaMessageAfterApiTrigger() {
        // Step 1: API trigger using Rest Assured
        given()
                .contentType("application/json")
                .body("{ \"orderId\": 1234 }")
                .when()
                .post("http://localhost:8080/api/order")
                .then()
                .statusCode(200);

        // Step 2: Consume Kafka messages
        List<String> kafkaMessages = consumeMessages(10);

        // Step 3: Assert expected message is present
        boolean found = kafkaMessages.stream().anyMatch(msg -> msg.contains("\"orderId\":1234"));
        Assert.assertTrue(found, "Expected Kafka message not found!");
    }

    @Test(description = "validate json response from Kafka message")
    public void testKafkaMessageWithRestAssuredJsonPath() {
        String jsonMessage = "{\"type\":\"payment\",\"status\":\"success\"}";

        JsonPath jp = new JsonPath(jsonMessage);
        String status = jp.getString("status");

        Assert.assertEquals(status, "success", "Kafka message status mismatch");
    }
    @Test(description = "validate json response from Kafka message using Jackson")
    public void testKafkaMessageWithJackson() throws Exception {
        String jsonMessage = "{\"type\":\"payment\",\"status\":\"success\"}";

        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map = mapper.readValue(jsonMessage, Map.class);

        Assert.assertEquals(map.get("status"), "success");
    }

    @Test(description = "validate json response from Kafka message using Gson")
    public void testKafkaMessageWithGson() {

        String kafkaMessage = "{\"type\":\"payment\",\"status\":\"success\"}";
        KafkaProducerUtils.sendMessage("my-topic", kafkaMessage);

        // Step 2: Consume message from Kafka
        List<String> messages = consumeMessages( 1);
        Assert.assertFalse(messages.isEmpty(), "No message received from Kafka");
        String jsonMessage = "{\"type\":\"payment\",\"status\":\"success\"}";

        JsonObject json = JsonParser.parseString(jsonMessage).getAsJsonObject();
        String status = json.get("status").getAsString();

        Assert.assertEquals(status, "success");
    }
}

