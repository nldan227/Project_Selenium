package bb.api.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateUserResponse {
    private LoginData data;
    private String message;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class LoginData {
        private String name;
        private String email;
        private String role;
        private String status;
    }
}