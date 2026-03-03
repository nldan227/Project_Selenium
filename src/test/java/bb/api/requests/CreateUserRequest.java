package bb.api.requests;

import lombok.Data;

@Data
public class CreateUserRequest {
    private String name;
    private String role;
    private Integer agency_id;
    private String email;
    private String password;
    private String password_confirmation;

    public CreateUserRequest(String name, String role, Integer agency_id, String email, String password, String password_confirmation) {
        this.name = name;
        this.role = role;
        this.agency_id = agency_id;
        this.email = email;
        this.password = password;
        this.password_confirmation = password_confirmation;
    }
}
