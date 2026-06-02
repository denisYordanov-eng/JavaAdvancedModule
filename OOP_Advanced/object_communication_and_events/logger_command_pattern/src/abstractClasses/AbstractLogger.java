package abstractClasses;

import interfaces.Handler;

public abstract class AbstractLogger implements Handler {
    private Handler successor;

    @Override
    public void setSuccessor(Handler successor) {
    this.successor = successor;
    }

    protected Handler getSuccessor() {
        return successor;
    }
}

