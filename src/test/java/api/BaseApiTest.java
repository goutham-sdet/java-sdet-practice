package api;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class BaseApiTest
{
    @BeforeClass
    public void SetUp()
    {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }
}
