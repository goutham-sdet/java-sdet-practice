package api;

import api.base.BaseApiTest;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class AuthTest extends BaseApiTest
{
    public static String token;

    @Test
    public void testLoginAndGetToken()
    {
        String body = """
                {"username":"emilys",
                "password":"emilyspass"}
                """;
        token = given()
                .body(body)
                .when()
                .post("/auth/login")
                .then()
                .statusCode(200)
                .extract()
                .path("accessToken");
        System.out.println("TOKEN = " + token);
    }

    @Test(dependsOnMethods = "testLoginAndGetToken")
    public void testGetMyProfileWithToken()
    {
        given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get("/auth/me")
                .then()
                .statusCode(200)
                .body("username", equalTo("emilys"));
    }
}
