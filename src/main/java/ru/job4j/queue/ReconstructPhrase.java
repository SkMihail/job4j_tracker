package ru.job4j.queue;

import java.util.Deque;
import java.util.Iterator;

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
        for (int i = 0; i < length; i++) {
            if (i % 2 == 0) {
                res.append(evenElements.poll());
            } else {
                evenElements.poll();
            }
        }
        return res.toString();
    }

    private String getDescendingElements() {
        StringBuilder res = new StringBuilder();
        Iterator<Character> desIterator = descendingElements.descendingIterator();
        while (desIterator.hasNext()) {
            res.append(desIterator.next());
        }
        return res.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}
