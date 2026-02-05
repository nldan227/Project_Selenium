package bb.api.dataobjects.model;

import bb.api.dataobjects.enumdata.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String name;
    private String role;
    private Integer agencyId;
    private String email;
    private String password;
    private String passwordConfirmation;

}
