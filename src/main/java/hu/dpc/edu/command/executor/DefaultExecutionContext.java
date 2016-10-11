package hu.dpc.edu.command.executor;

import hu.dpc.edu.command.common.ExecutionContext;
import hu.dpc.edu.command.common.UserStore;

/**
 * Created by vrg on 11/10/16.
 */
public class DefaultExecutionContext implements ExecutionContext {

    private UserStore userStore;

    public DefaultExecutionContext(UserStore userStore) {
        this.userStore = userStore;
    }

    @Override
    public UserStore getUserStore() {
        return userStore;
    }

    private class ContextState {
        private Object userStoreState = userStore.getState();

        public void restore() {
            userStore.setState(userStoreState);
        }
    }

    @Override
    public Object getState() {
        return new ContextState();
    }

    @Override
    public void setState(Object state) {
        ContextState contextState = (ContextState) state;
        contextState.restore();
    }
}
