package api;

import com.github.tomakehurst.wiremock.WireMockServer;
import io.qameta.allure.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@Epic("API Framework")
@Feature("Day 25 - WireMock")
public class WireMockTest
{
    private WireMockServer wireMock;

    @BeforeClass
    public void setupMock()
    {
        wireMock = new WireMockServer(8089);
        wireMock.start();
        configureFor("localhost", 8089);

        // Mock GET /users/1
        stubFor(get(urlEqualTo("/users/1"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"id\":1,\"firstName\":\"Mocked\",\"lastName\":\"User\",\"age\":30}")));

        // Mock POST /users/add
        stubFor(post(urlEqualTo("/users/add"))
                .willReturn(aResponse()
                        .withStatus(201)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"id\":999,\"firstName\":\"Created\"}")));
    }

    @Test
    @Story("Test against mocked GET")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Validates framework works when real API is down")
    public void testMockedGet()
    {
        given()
                .baseUri("http://localhost:8089")
                .when()
                .get("/users/1")
                .then()
                .statusCode(200)
                .body("firstName", equalTo("Mocked"));
    }

    @Test
    @Story("Test against mocked POST")
    public void testMockedPost()
    {
        given()
                .baseUri("http://localhost:8089")
                .contentType("application/json")
                .body("{\"firstName\":\"Test\"}")
                .when()
                .post("/users/add")
                .then()
                .statusCode(201)
                .body("id", equalTo(999));
    }

    @AfterClass
    public void tearDown()
    {
        wireMock.stop();
    }
}
