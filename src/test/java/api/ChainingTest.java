package api;

import api.BaseApiTest;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ChainingTest extends BaseApiTest
{
    static int userId;

    // Since we are using mock api , we are not using POST method as it doesn't store any new data.

    @Test
    public void test1_GetExistingUser()
    {
        // Step 1: GET an existing user and EXTRACT the id (chaining starts here)
        userId = given()
                .when()
                .get("/users/1")
                .then()
                .statusCode(200)
                .extract()
                .path("id");

        System.out.println("Using existing ID = " + userId);
    }

    @Test(dependsOnMethods = "test1_GetExistingUser")
    public void test2_UpdateUser()
    {
        // Step 2: Use the extracted id to UPDATE
        String updateBody = """
                {"firstName":"GouthamUpdated"}
                """;

        given()
                .body(updateBody)
                .when()
                .put("/users/" + userId)
                .then()
                .statusCode(200)
                .body("firstName", equalTo("GouthamUpdated"))
                .body("id", equalTo(userId));
    }

    @Test(dependsOnMethods = "test2_UpdateUser")
    public void test3_DeleteUser()
    {
        // Step 3: Use same id to DELETE
        given()
                .when()
                .delete("/users/" + userId)
                .then()
                .statusCode(200)
                .body("id", equalTo(userId))
                .body("isDeleted", equalTo(true));
    }
}
