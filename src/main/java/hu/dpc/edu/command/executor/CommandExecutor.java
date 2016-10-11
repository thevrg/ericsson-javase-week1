package hu.dpc.edu.command.executor;

import hu.dpc.edu.command.common.Command;
import hu.dpc.edu.command.common.ExecutionContext;

import java.util.ArrayDeque;

/**
 * Created by vrg on 11/10/16.
 */
public class CommandExecutor {

    private ExecutionContext context;
    private ArrayDeque<Command> commands = new ArrayDeque<>();

    public CommandExecutor(ExecutionContext context) {
        this.context = context;
    }

    public void execute(Command command) {
        System.out.println("Executing command: " + command);
        command.executeWithUndoCapability(context);
        commands.addLast(command);
    }

    public void undo() {
        if (!commands.isEmpty()) {
            final Command lastCommand = commands.removeLast();
            System.out.println("Undoing last command: " + lastCommand );
            lastCommand.undo(context);
        }
    }
}
