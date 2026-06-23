package api;

import api.base.BaseApiTest;
import api.pojo.User;
import org.testng.annotations.Test;

import static api.base.ApiSpecs.response200;
import static api.base.ApiSpecs.response201;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class SpecsDemoTest extends BaseApiTest
{
    @Test
    public void testGetUsesGlobalSpec()
    {
        // No given().contentType() needed - it's in the spec
        given()
                .when()
                .get("/users/1")
                .then()
                .spec(response200())
                .body("firstName", equalTo("Emily")); // 200 spec already applied
    }

    @Test
    public void testPostOverridesSpec()
    {
        User u = new User("Specs", "Demo", 30);

        given()
                .body(u)
                .when()
                .post("/users/add")
                .then()
                .spec(response201()) //
                .body("firstName", equalTo("Specs"));
    }

    @Test
    public void testWithCustomHeader()
    {
        // You can still add to the spec per test
        given()
                .header("X-Demo", "Day22")
                .when()
                .get("/users/2")
                .then()
                .statusCode(200);
    }
}
