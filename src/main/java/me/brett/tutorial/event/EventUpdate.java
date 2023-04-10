package me.brett.tutorial.event;

public class EventUpdate {

    State state;

    public EventUpdate(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public enum State {
        PRE, POST
    }

}
