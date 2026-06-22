/*package api;

import api.BaseApiTest;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ChainingTest extends BaseApiTest
{
    static int userId;

    @Test
    public void test1_CreateUser()
    {
        String body = """
                {"firstName":"Goutham",
                "lastName":"SDET",
                "age":25}
                """;
        userId = given()
                .body(body)
                .when()
                .post("/users/add")
                .then()
                .statusCode(201)
                .extract()
                .path("id");
        System.out.println("Created ID = " + userId);
    }

    @Test(dependsOnMethods = "test1_CreateUser")
    public void test2_GetUser()
    {
        given()
                .when()
                .get("/users/" + userId)
                .then()
                .statusCode(200)
                .body("id", equalTo(userId));
    }

    @Test(dependsOnMethods = "test2_GetUser")
    public void test3_DeleteUser()
    {
        given()
                .when()
                .delete("/users/" + userId)
                .then()
                .statusCode(200)
                .body("isDeleted", equalTo(true));
    }
}
*/