package ru.job4j.queue;

import java.util.Deque;

public class ReconstructPhrase {

    private final Deque<Character> descendingElements;

    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder res = new StringBuilder();
        int length = evenElements.size();
        for (int i = 0; i < length / 2; i++) {
            res.append(evenElements.poll());
            evenElements.poll();
        }
        return res.toString();
    }

    private String getDescendingElements() {
        StringBuilder res = new StringBuilder();
        int length = descendingElements.size();
        for (int i = 0; i < length; i++) {
            res.append(descendingElements.pollLast());
        }
        return res.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}
