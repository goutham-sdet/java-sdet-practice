package api.base;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import static api.base.ApiSpecs.*;

public class BaseApiTest
{
    @BeforeClass
    public void setup()
    {
        RestAssured.requestSpecification = requestSpec();
        // Now every test automatically gets baseURI, JSON header, and logging
    }
}
