package hu.dpc.edu.command.client;

import hu.dpc.edu.User;
import hu.dpc.edu.command.concretecommand.CreateUserCommand;
import hu.dpc.edu.command.concretecommand.FindUserByNameCommand;
import hu.dpc.edu.command.executor.CommandExecutor;
import hu.dpc.edu.command.executor.DefaultExecutionContext;
import hu.dpc.edu.command.executor.InMemoryUserStore;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by vrg on 11/10/16.
 */
public class CommandClient {

    private static void print(Stream<User> userStream) {
        System.out.println(
                userStream.map(user -> user.getLastName() + " " + user.getFirstName())
                        .collect(Collectors.joining(", ", "[", "]")));
    }

    public static void main(String[] args) {
        final InMemoryUserStore userStore = new InMemoryUserStore();
        CommandExecutor executor = new CommandExecutor(new DefaultExecutionContext(userStore));


        final User user1 = User.builder().firstName("Bela").lastName("Kovacs").username("user1").build();
        final User user2 = User.builder().firstName("Bela2").lastName("Kovacs2").username("user2").build();
        final CreateUserCommand createUser1 = new CreateUserCommand(user1);
        final CreateUserCommand createUser2 = new CreateUserCommand(user2);
        final FindUserByNameCommand findUser1 = new FindUserByNameCommand("user1");


        print(userStore.getUserStream());
        executor.execute(createUser1);
        print(userStore.getUserStream());
        executor.execute(createUser2);
        print(userStore.getUserStream());
//        executor.execute(findUser1);
//        System.out.println(userStore.getUsers());


//        final User firstUser = findUser1.getUser();
//        System.out.println(userStore.getUsers());
        executor.undo();
        print(userStore.getUserStream());
        executor.undo();
        print(userStore.getUserStream());
        executor.undo();
        print(userStore.getUserStream());

    }
}
