package api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;

public class BaseApiTest
{
    @BeforeClass
    public void setup()
    {
        RestAssured.baseURI = "https://dummyjson.com";
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .build();
    }
}
