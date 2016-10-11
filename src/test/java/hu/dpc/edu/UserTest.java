package hu.dpc.edu;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by vrg on 11/10/16.
 */
public class UserTest {

    @Test
    public void testCloneWorks() {
        //Given
        final User user = User.builder()
                .firstName("Bela")
                .lastName("Kovacs")
                .addEmail("bela@acme.com")
                .addEmail("bela2@acme.com")
                .build();
        //When
        final User cloned = user.clone();
        //Then
        assertEquals(user.getFirstName(), cloned.getFirstName());
        assertEquals(user.getLastName(), cloned.getLastName());
        assertEquals(user.getEmails(), cloned.getEmails());

    }

    @Test
    public void testDeepCloneWorks() {
        //Given
        final User user = User.builder()
                .firstName("Bela")
                .lastName("Kovacs")
                .addEmail("bela@acme.com")
                .addEmail("bela2@acme.com")
                .build();
        //When
        final User cloned = user.clone();
        //Then
        assertEquals(user.getFirstName(), cloned.getFirstName());
        assertEquals(user.getLastName(), cloned.getLastName());
        assertEquals(user.getEmails(), cloned.getEmails());
        assertNotSame(user.getEmails(), cloned.getEmails());
//
//        cloned.getEmails().add("bela3@acme.com");
//
//        assertEquals(2, user.getEmails().size());
    }
}