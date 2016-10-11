package hu.dpc.edu.command.common;

import hu.dpc.edu.command.common.ExecutionContext;

/**
 * Created by vrg on 11/10/16.
 */
public abstract class Command {

    private Object previousState;

    public final void executeWithUndoCapability(ExecutionContext context) {
        this.previousState = context.getState();
        execute(context);
    }

    protected abstract void execute(ExecutionContext context);

    public void undo(ExecutionContext context) {
        context.setState(previousState);
    }
}
