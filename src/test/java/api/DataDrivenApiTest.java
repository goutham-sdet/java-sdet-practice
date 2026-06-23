package api;

import api.base.BaseApiTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class DataDrivenApiTest extends BaseApiTest
{
    @DataProvider(name = "userData")
    public Object [][] getData()
    {
        return new Object [][] {
                {"alice", 22},
                {"bob", 30},
                {"carol", 28}
        };
    }

    @Test(dataProvider = "userData")
    public void testCreateUserWithData(String name, int age)
    {
        String body = String.format("{\"firstName\":\"%s\",\"age\":%d}", name, age);
        given()
                .body(body)
                .when()
                .post("/users/add")
                .then()
                .statusCode(201)
                .body("firstName", equalTo(name));
    }
}
