package hu.dpc.edu;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by vrg on 10/10/16.
 */
public class UserBuilderTest {
    @Test
    public void testUserBuilder() {
        final User.UserBuilderImpl userBuilder = new User.UserBuilderImpl();
        final User user = userBuilder
                .firstName("Bela")
                .lastName("Kovacs")
                .build();

        assertEquals("Bela", user.getFirstName());
        assertEquals("Kovacs", user.getLastName());
    }

    @Test
    public void buildShouldThrowIllegalStateExceptionOnMissingFirstName() {
        final User.UserBuilderImpl userBuilder = new User.UserBuilderImpl();
        try {
            final User user = userBuilder.lastName("Kovacs")
                    .build();
            fail("IllegalStateException is expected at this point");
        } catch (IllegalStateException ex) {
            assertTrue("Exception message should contain the string 'firstName'",
                    ex.getMessage().contains("firstName"));
        }
    }
}