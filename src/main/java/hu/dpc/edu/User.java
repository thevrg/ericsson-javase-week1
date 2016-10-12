package hu.dpc.edu;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by vrg on 10/10/16.
 */
public class User implements Cloneable {
    private String username;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private List<String> emails = new ArrayList<>();

    User() {
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public List<String>getEmails() {
        return new ArrayList<>(emails);
    }

    protected void validate() {
        if (firstName == null || firstName.trim().isEmpty()) {
            throw new IllegalStateException("firstName is mandatory");
        }
    }

    public User clone() {
        try {
            User cloned = (User) super.clone();
            cloned.emails = new ArrayList<>(this.emails);
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Clone is not supported", e);
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", emails=" + emails +
                '}';
    }

    public static UserBuilder builder() {
        return new UserBuilderImpl();
    }

    public static class UserBuilderImpl implements UserBuilder {
        private User user = new User();

        @Override
        public UserBuilderImpl firstName(String firstName) {
            user.firstName = firstName;
            return this;
        }

        @Override
        public UserBuilderImpl lastName(String lastName) {
            user.lastName = lastName;
            return this;
        }

        @Override
        public UserBuilderImpl addEmail(String email) {
            user.emails.add(email);
            return this;
        }

        @Override
        public UserBuilderImpl username(String username) {
            user.username = username;
            return this;
        }

        public User buildNonExisting() {
            return new NonExistingUser();
        }

        @Override
        public User build() {
            user.validate();
            return user;
        }
    }
}
