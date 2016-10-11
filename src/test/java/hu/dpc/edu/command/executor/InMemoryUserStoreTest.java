package hu.dpc.edu.command.executor;

import hu.dpc.edu.User;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by vrg on 11/10/16.
 */
public class InMemoryUserStoreTest {

    @Test
    public void storeShouldPutTheUserIntoTheUserMapWithUsernameAsTheKey() throws Exception {
        //Given
        Map<String,User>userMap = mock(Map.class);
        final InMemoryUserStore sut = new InMemoryUserStore(userMap);

        User user = mock(User.class);
        when(user.getUsername()).thenReturn("user1");

        //When
        sut.store(user);


        //Then
        verify(user).getUsername();
        verify(userMap).put("user1",user);

    }

}