package api.utils;

import java.util.Base64;

public class JWTUtils
{
    public static boolean isJwtFormat(String token)
    {
        return token!= null && token.split("\\.").length == 3;
    }

    public static String getPayload(String token)
    {
        try
        {
            String payload = token.split("\\.")[1];
            return new String(Base64.getUrlDecoder().decode(payload));
        }
        catch (Exception e)
        {
            return "";
        }
    }
}
