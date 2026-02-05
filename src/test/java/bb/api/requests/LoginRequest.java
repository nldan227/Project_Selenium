package bb.api.requests;
import lombok.Data;

@Data
public class LoginRequest {
    private String phone;
    private String password;

    public LoginRequest(String email, String password) {
        this.phone = email;
        this.password = password;
    }
}
