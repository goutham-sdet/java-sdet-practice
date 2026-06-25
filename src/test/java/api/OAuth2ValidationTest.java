package api;

import api.base.BaseApiTest;
import api.utils.JWTUtils;
import api.utils.TokenManager;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.notNullValue;

@Epic("API Security")
@Feature("Day 26 - OAuth2 & Contract")
public class OAuth2ValidationTest extends BaseApiTest
{

    @Test
    @Story("Validate JWT structure and payload")
    @Severity(SeverityLevel.CRITICAL)
    public void testJwtTokenValidation()
    {
        String token = TokenManager.getToken();

        org.testng.Assert.assertNotNull(token, "Token is null");
        org.testng.Assert.assertFalse(token.isEmpty(), "Token is empty");
        org.testng.Assert.assertTrue(JWTUtils.isJwtFormat(token), "Token is not JWT format");
        org.testng.Assert.assertTrue(JWTUtils.getPayload(token).contains("username"), "Payload doesn't contain username");
    }

    @Test
    @Story("Validate API contract with JSON Schema")
    @Severity(SeverityLevel.BLOCKER)
    public void testUserSchemaValidation()
    {
        given()
                .when()
                .get("/users/1")
                .then()
                .statusCode(200)
                .body("id", notNullValue())
                .body(matchesJsonSchemaInClasspath("schemas/user-schema.json"));
    }

    @Test
    @Story("Negative test - invalid token rejected")
    @Severity(SeverityLevel.NORMAL)
    public void testInvalidTokenRejected()
    {
        given()
                .header("Authorization", "Bearer invalid_token_123")
                .when()
                .get("/auth/me")
                .then()
                .statusCode(401);
    }
}
