package utils;

import com.github.javafaker.Faker;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class TestDataFactory
{
    private static final Faker faker = new Faker();

    // for UsersApiTest - create user
    public static Map<String, Object> randomUserForCreate()
    {
        return Map.of(
                "firstName", faker.name().firstName(),
                "lastName", faker.name().lastName(),
                "age", faker.number().numberBetween(18, 65)
        );
    }

    // for AuthTest - load from JSON
    public static List<Map<String, Object>> fromJson(String fileName)
    {
        try
        {
            ObjectMapper mapper = new ObjectMapper();
            InputStream is = TestDataFactory.class.getClassLoader()
                    .getResourceAsStream("testdata/" + fileName);
            return mapper.readValue(is, new TypeReference<>()
            {
            });
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
}
