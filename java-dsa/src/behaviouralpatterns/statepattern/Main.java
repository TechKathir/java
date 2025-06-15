package behaviouralpatterns.statepattern;

public class Main {
    public static void main(String[] args) {
        StateContext stateContext = new StateContext(new DraftStatus());
        stateContext.applyState();
        stateContext.applyState();
        stateContext.applyState();
        stateContext.applyState();
        stateContext.applyState();
    }
}

interface State {
    void nextState(StateContext stateContext);
}

class StateContext {
    private State currentState;

    public StateContext(State currentState) {
        this.currentState = currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    public void applyState() {
        currentState.nextState(this);
    }
}

class DraftStatus implements State {

    @Override
    public void nextState(StateContext stateContext) {
        System.out.println("Draft Status Done");
        stateContext.setCurrentState(new PostStatus());
    }

}

class PostStatus implements State {
    @Override
    public void nextState(StateContext stateContext) {
        System.out.println("Post Status Done");
        stateContext.setCurrentState(new PaidStatus());
    }
}

class PaidStatus implements State {
    @Override
    public void nextState(StateContext stateContext) {
        System.out.println("Paid Status Done");
        stateContext.setCurrentState(new DraftStatus());
    }
}