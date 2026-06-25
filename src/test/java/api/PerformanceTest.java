package api;

import api.base.BaseApiTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

@Epic("API Performance")
@Feature("Day 27 - SLA & Load")
public class PerformanceTest extends BaseApiTest
{
    @Test
    @Story("Response time under 2s SLA")
    public void testResponseTimeSLA()
    {
        given()
                .when()
                .get("/users/1")
                .then()
                .time(lessThan(2000L));
    }

    @Test
    @Story("Handle 10 concurrent users")
    public void testConcurrentLoad()
    {
        long start = System.currentTimeMillis();

        CompletableFuture<?>[] futures = IntStream.range(0, 10)
                .mapToObj(i -> CompletableFuture.runAsync(() ->
                        given().when().get("/users/1").then().statusCode(200)
                ))
                .toArray(CompletableFuture[]::new);

        CompletableFuture.allOf(futures).join();

        long duration = System.currentTimeMillis() - start;
        Allure.addAttachment("Load Test", "10 requests in " + duration + "ms");

        Assert.assertTrue(duration < 5000, "Load test exceeded 5s, took: " + duration);
    }
}
