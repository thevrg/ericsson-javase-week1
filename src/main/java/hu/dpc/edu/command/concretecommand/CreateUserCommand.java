package hu.dpc.edu.command.concretecommand;

import hu.dpc.edu.User;
import hu.dpc.edu.command.common.Command;
import hu.dpc.edu.command.common.ExecutionContext;

/**
 * Created by vrg on 11/10/16.
 */
public class CreateUserCommand extends Command {

    private User user;

    public CreateUserCommand(User user) {
        this.user = user;
    }

    @Override
    public void execute(ExecutionContext executionContext) {
        executionContext
                .getUserStore()
                .store(user);
    }

    @Override
    public String toString() {
        return "Create " + user;
    }
}
