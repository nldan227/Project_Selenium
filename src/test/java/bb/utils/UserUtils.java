package bb.utils;

import bb.api.dataobjects.enumdata.Role;
import bb.api.dataobjects.model.User;

public class UserUtils {

    public static User randomValidUser() {
        String name = StringUtils.generateFirstName();
        String email = StringUtils.generateEmailAddress();
        String role = Role.ADMIN.getValue();
        String password = StringUtils.generateRandomNumeric(9);
        Integer agencyId = 1;
        User user = new User(name, role, agencyId, email, password, password);

        return user;
    }
}
