package hu.dpc.edu.command.executor;

import hu.dpc.edu.User;
import hu.dpc.edu.command.common.UserStore;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by vrg on 11/10/16.
 */
public class InMemoryUserStore implements UserStore {

    private Map<String,User>users;

    public InMemoryUserStore() {
        users = new HashMap<>();
    }

    InMemoryUserStore(Map<String, User> users) {
        this.users = users;
    }

    @Override
    public void store(User user) {
        users.put(user.getUsername(), user);
    }

    @Override
    public User findByName(String name) {
        User user = users.get(name);
        if (user == null) {
            user = User.builder().buildNonExisting();
        }
        return user;
    }

    @Override
    public void deleteByName(String name) {
        users.remove(name);
    }

    @Override
    public Object getState() {
        return new HashMap<>(users);
    }

    @Override
    public void setState(Object state) {
        this.users = new HashMap<>((HashMap<String,User>)state);
    }

    @Override
    public Stream<User> getUserStream() {
        return users.values().stream();
    }

    @Override
    public List<User> findUsers(Predicate<User>predicate) {
        return users.values()
                .stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }


}
