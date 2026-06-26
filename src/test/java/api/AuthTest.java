package api;

import api.base.BaseApiTest;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.DataProvider;
import java.util.List;
import java.util.Map;

public class AuthTest extends BaseApiTest
{
    public static String token;

    @DataProvider(name = "authData")
    public Object[][] authData()
    {
        List<Map<String, Object>> data = utils.TestDataFactory.fromJson("auth.json");
        return new Object[][] { {data.get(0)}, {data.get(1)} };
    }

    @Test(dataProvider = "authData")
    public void testLoginAndGetToken(Map<String, Object> data)
    {
        String username = (String) data.get("username");
        String password = (String) data.get("password");
        int expectedStatus = (int) data.get("expectedStatus");

        String body = String.format("{\"username\":\"%s\",\"password\":\"%s\"}", username, password);

        if (expectedStatus == 200)
        {
            token = given()
                    .body(body)
                    .when()
                    .post("/auth/login")
                    .then()
                    .statusCode(expectedStatus)
                    .extract().path("accessToken");

            System.out.println("LOGIN SUCCESS: " + username);
        }
        else
        {
            given()
                    .body(body)
                    .when()
                    .post("/auth/login")
                    .then()
                    .statusCode(expectedStatus);

            System.out.println("LOGIN FAILED as expected: " + username);
        }
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
