package api;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class UsersApiTest extends BaseApiTest
{
    @Test
    public void testGetUser()
    {
        given() // 1. PREPARE: "I'm about to make a request"
                .when() // 2. ACTION: do it
                .get("/users/1") // send GET to /users/1
                .then() // 3. CHECK: verify the response
                .statusCode(200) // HTTP 200 = OK
                .body("id", equalTo(1)) // JSON field "id" should be 1
                .body("username", equalTo("Bret"))
                .body("email", equalTo("Sincere@april.biz"));
    }

    @Test
    public void testCreatePost()
    {
        String payload = "{\"title\":\"Goutham-SDET\",\"body\":\"Day19\",\"userId\":1}";

        given()
                .contentType(ContentType.JSON) // tell server: I'm sending JSON
                .body(payload) // the data
                .when()
                .post("/posts") // POST creates
                .then()
                .statusCode(201) // 201 = Created (not 200)
                .body("title", equalTo("Goutham-SDET"))
                .body("id", notNullValue()); // server should return new id
    }

    @Test
    public void testGetPostsSchema()
    {
        given()
                .when()
                .get("/posts")
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0))  // the JSON array has >0 items
                .body("[0].userId", instanceOf(Integer.class));  // first item's userId is a number
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

