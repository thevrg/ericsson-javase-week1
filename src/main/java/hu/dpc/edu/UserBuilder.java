package hu.dpc.edu;

/**
 * Created by vrg on 10/10/16.
 */
public interface UserBuilder {
    User.UserBuilderImpl firstName(String firstName);

    User.UserBuilderImpl lastName(String lastName);

    User.UserBuilderImpl addEmail(String email);
    User.UserBuilderImpl username(String username);

    User build();

    User buildNonExisting();
}
