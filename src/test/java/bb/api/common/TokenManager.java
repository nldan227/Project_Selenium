package bb.api.common;
import net.serenitybdd.core.Serenity;

public class TokenManager {

    private static final String ACCESS_TOKEN_KEY = "ACCESS_TOKEN";

    public static void saveAccessToken(String token) {
        Serenity.setSessionVariable(ACCESS_TOKEN_KEY).to(token);
    }

    public static String getAccessToken() {
        return Serenity.sessionVariableCalled(ACCESS_TOKEN_KEY);
    }

    public static void clear() {
        Serenity.clearSessionVariable(ACCESS_TOKEN_KEY);
    }
}
