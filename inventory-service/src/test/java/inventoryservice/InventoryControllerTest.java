package inventoryservice;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class InventoryControllerTest {
    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        RestAssured.port = port;
    }

    @Test
    void getInventory_ValidProduct_ReturnsInventory() {
        given()
                .pathParam("productId", "1")
                .when()
                .get("/api/inventory/{productId}")
                .then()
                .statusCode(200)
                .body("productId", equalTo("1"))
                .body("quantity", equalTo(100));
    }
}