package api;

import api.base.BaseApiTest;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class UsersApiTest extends BaseApiTest
{
    @Test
    public void testGetAllUsers() {
        given()
                .when()
                .get("/users")
                .then()
                .statusCode(200)
                .body("users.size()", greaterThan(0));
    }

    @Test
    public void testGetSingleUser() {
        given()
                .when()
                .get("/users/1")
                .then()
                .statusCode(200)
                .body("id", equalTo(1))
                .body("firstName", notNullValue());
    }

    @Test
    public void testCreateUser() {
        String body = """
                {"firstName":"Test",
                "lastName":"User",
                "age":30}
                """;

        given()
                .body(body)
                .when()
                .post("/users/add")
                .then()
                .statusCode(201)
                .body("firstName", equalTo("Test"));
    }

    @Test
    public void testUserNotFound()
    {
        given()
                .when()
                .get("/users/9999")
                .then()
                .statusCode(404);
    }
}

