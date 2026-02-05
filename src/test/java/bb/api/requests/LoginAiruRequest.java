package bb.api.requests;
import lombok.Data;

@Data
public class LoginAiruRequest {
    private String username;
    private String password;

    public LoginAiruRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
