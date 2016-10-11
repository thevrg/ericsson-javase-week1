package hu.dpc.edu;

import java.util.Date;

/**
 * Created by vrg on 11/10/16.
 */
public class NonExistingUser extends User {
    @Override
    public String getUsername() {
        return "Non existing";
    }

    @Override
    public String getLastName() {
        return "Non existing";
    }

    @Override
    public String getFirstName() {
        return "Non existing";
    }

    @Override
    public Date getBirthDate() {
        return null;
    }
}
