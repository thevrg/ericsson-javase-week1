package hu.dpc.edu.command.common;

import hu.dpc.edu.User;

import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Created by vrg on 11/10/16.
 */
public interface UserStore {
    public void store(User user);
    public User findByName(String name);
    public void deleteByName(String name);

    public Object getState();
    public void setState(Object state);


    public Stream<User> getUserStream();
    public List<User> findUsers(Predicate<User>predicate);
}
