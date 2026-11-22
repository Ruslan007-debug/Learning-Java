package org.example;

public final class TestWordAutomaton {
    public enum State {
        START("S"), T("1"), TE("2"), TES("3"), FOUND("F");

        private final String label;

        State(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }
    }

    private TestWordAutomaton() {
    }

    public static State recognize(String input) {
        State state = State.START;
        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);
            if (symbol == 'T') {
                if (state == State.TES) {
                    return State.FOUND;
                }
                state = State.T;
            } else if (state == State.T && symbol == 'E') {
                state = State.TE;
            } else if (state == State.TE && symbol == 'S') {
                state = State.TES;
            } else {
                state = State.START;
            }
        }
        return state;
    }
}
