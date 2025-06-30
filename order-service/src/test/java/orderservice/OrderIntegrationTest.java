package orderservice;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
class OrderIntegrationTest {
    @LocalServerPort
    private int port;

    @Container
    static GenericContainer<?> inventoryService =
            new GenericContainer<>("inventory-service:latest")
                    .withExposedPorts(8081);

    @DynamicPropertySource
    static void registerProperties(DynamicPropertyRegistry registry) {
        registry.add("inventory.service.url", () ->
                "http://" + inventoryService.getHost() + ":" + inventoryService.getMappedPort(8081));
    }

    @BeforeEach
    void setUp() {
        RestAssured.port = port;
    }

    @Test
    void createOrder_IntegrationWithInventoryService_ReturnsOrder() {
        given()
                .contentType("")
                .body("")
                .when()
                .post("")
                .then()
                .statusCode()
                .body("", equalTo(""))
                .body("", equalTo());
    }
}
