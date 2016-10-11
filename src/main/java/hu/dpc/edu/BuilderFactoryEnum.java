package hu.dpc.edu;

/**
 * Created by vrg on 11/10/16.
 */
public enum BuilderFactoryEnum {

    INSTANCE;

    public UserBuilder createUserBuilder() {

        return new User.UserBuilderImpl();
    }
}
