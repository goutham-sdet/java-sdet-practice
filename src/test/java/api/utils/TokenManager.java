package api.utils;

import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;

public class TokenManager
{
    private static String token;

    public static String getToken()
    {
        if (token == null)
        {
            token = given()
                    .contentType(ContentType.JSON)
                    .body("{\"username\":\"" + ConfigManager.get("username") +
                            "\",\"password\":\"" + ConfigManager.get("password") + "\"}")
                    .when()
                    .post(ConfigManager.get("base.url") + "/auth/login")
                    .then()
                    .statusCode(200)
                    .extract()
                    .path("accessToken");
        }
        return token;
    }
}
