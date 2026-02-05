package bb.api.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginAiruResponse {
    private LoginData data;
    private String message;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class LoginData {
        private String access_token;
        private String refresh_token;
        private int expires_in;
        private String token_type;
    }
}
