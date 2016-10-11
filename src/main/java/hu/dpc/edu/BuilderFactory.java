package hu.dpc.edu;

/**
 * Created by vrg on 11/10/16.
 */
public class BuilderFactory {

    private static final BuilderFactory INSTANCE = new BuilderFactory();

    private BuilderFactory() {
    }

    public static BuilderFactory getInstance() {
        return INSTANCE;
    }

    public UserBuilder createUserBuilder() {
        return new User.UserBuilderImpl();
    }
}
