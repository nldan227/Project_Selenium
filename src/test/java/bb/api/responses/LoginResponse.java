package bb.api.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginResponse {

    private LoginData data;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class LoginData {

        private String token;
        private String refresh_token;
        private int expires_in;
        private String email;
        private String name;
        private int member_id;
    }
}
