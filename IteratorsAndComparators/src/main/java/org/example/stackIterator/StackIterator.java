package org.example.stackIterator;

import com.sun.source.tree.BreakTree;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class StackIterator implements Iterable<Integer> {

    private class Iter implements Iterator<Integer> {

        private int index = elements.size() -1;
        @Override
        public boolean hasNext() {
            return index >= 0;
        }

        @Override
        public Integer next() {
            int element = elements.get(index);
            index--;
            return element;
        }
    }

    private List<Integer> elements;

    public StackIterator(List<Integer> elements) {
        this.elements = elements;
    }

    public List<Integer> getElements() {
        return elements;
    }

    public void pop() {
        int indexEl = elements.size() - 1;
        elements.remove(indexEl);
    }

    public Iterator<Integer> iterator() {
        return new Iter();
    }
}
