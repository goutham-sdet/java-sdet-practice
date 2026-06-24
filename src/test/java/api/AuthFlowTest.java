package api;

import api.base.BaseApiTest;
import api.utils.TokenManager;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

@Epic("API Framework")
@Feature("Day 24 - Config & Auth")
public class AuthFlowTest extends BaseApiTest
{
    @Test
    @Story("Get token and call protected endpoint")
    @Severity(SeverityLevel.BLOCKER)
    public void testAuthFlow()
    {
        String token = TokenManager.getToken();

        given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get("/auth/me")
                .then()
                .statusCode(200)
                .body("username", notNullValue());
    }
}
