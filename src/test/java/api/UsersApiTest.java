package api;

import api.base.BaseApiTest;
import org.testng.annotations.Test;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class UsersApiTest extends BaseApiTest
{
    @Test
    public void testGetAllUsers()
    {
        given()
                .when()
                .get("/users")
                .then()
                .statusCode(200)
                .body("users.size()", greaterThan(0));
    }

    @Test
    public void testGetSingleUser()
    {
        given()
                .when()
                .get("/users/1")
                .then()
                .statusCode(200)
                .body("id", equalTo(1))
                .body("firstName", notNullValue());
    }

    @Test
    public void testCreateUser()
    {
        Map<String, Object> user = utils.TestDataFactory.randomUserForCreate();

        given()
                .body(user)
                .when()
                .post("/users/add")
                .then()
                .statusCode(201)
                .body("firstName", equalTo(user.get("firstName")));

        System.out.println("Created user: " + user);
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

