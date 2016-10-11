package hu.dpc.edu.command.concretecommand;

import hu.dpc.edu.User;
import hu.dpc.edu.command.common.Command;
import hu.dpc.edu.command.common.ExecutionContext;

/**
 * Created by vrg on 11/10/16.
 */
public class FindUserByNameCommand extends Command {

    private String username;
    private User user;

    public FindUserByNameCommand(String username) {
        this.username = username;
    }

    @Override
    public void execute(ExecutionContext context) {
        user = context.getUserStore().findByName(username);
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "Find user with name: " + username;
    }
}
