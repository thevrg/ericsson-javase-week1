package hu.dpc.edu.command.common;

/**
 * Created by vrg on 11/10/16.
 */
public interface ExecutionContext {
    public UserStore getUserStore();

    public Object getState();
    public void setState(Object state);
}
