/*package api;

import api.BaseApiTest;
import api.pojo.User;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class PojoTest extends BaseApiTest
{
    @Test
    public void testPostWithPojo()
    {
        User u = new User("Goutham","SDET",25);
        int id = given()
                .body(u)
                .when()
                .post("/users/add")
                .then()
                .statusCode(201)
                .extract()
                .path("id");
        System.out.println("POJO id: " + id);
    }

    @Test
    public void testGetWithPojo()
    {
        User u = given()
                .when()
                .get("/users/1")
                .then()
                .statusCode(200)
                .extract()
                .as(User.class);
        System.out.println("User: " + u.getFirstName() + " age " + u.getAge());
    }
}
*/