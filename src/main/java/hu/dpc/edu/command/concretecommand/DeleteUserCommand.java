package hu.dpc.edu.command.concretecommand;

import hu.dpc.edu.command.common.Command;
import hu.dpc.edu.command.common.ExecutionContext;

/**
 * Created by vrg on 11/10/16.
 */
public class DeleteUserCommand extends Command {

    private String username;

    public DeleteUserCommand(String username) {
        this.username = username;
    }

    @Override
    public void execute(ExecutionContext executionContext) {
        executionContext
                .getUserStore()
                .deleteByName(username);
    }
    @Override
    public String toString() {
        return "Delete User " + username;
    }

}
