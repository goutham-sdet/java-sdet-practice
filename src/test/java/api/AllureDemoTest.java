package api;

import api.base.BaseApiTest;
import api.pojo.User;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import static api.base.ApiSpecs.response200;
import static api.base.ApiSpecs.response201;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@Epic("API Automation Framework")
@Feature("Day 23 - Reporting")
public class AllureDemoTest extends BaseApiTest
{
    @Test
    @Story("GET user with Allure steps")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Validate GET /users/1 returns correct data and attaches request to report")
    public void testGetWithAllure()
    {
        given()
                .when()
                .get("/users/1")
                .then()
                .spec(response200())
                .body("id", equalTo(1));
    }

    @Test
    @Story("POST user with attachments")
    @Severity(SeverityLevel.NORMAL)
    public void testPostWithAllure()
    {
        User u = new User("Allure", "Report", 28);

        Allure.step("Create user payload");

        given()
                .body(u)
                .when()
                .post("/users/add")
                .then()
                .spec(response201())
                .body("firstName", equalTo("Allure"));
    }
}
