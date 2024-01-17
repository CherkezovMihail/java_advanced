package org.example.listyIterator;

import java.util.Iterator;
import java.util.List;

public class ListyIterator implements Iterable<String> {
    private List<String> collection;

    private int currentIndex;

    public ListyIterator(String... collection) {
        this.collection = List.of(collection);
        currentIndex = 0;
    }

    public boolean hasNext() {
        return currentIndex < collection.size() -1;
    }

    public boolean move() {
        if (hasNext()) {
            currentIndex++;
            return true;
        } else {
            return false;
        }
    }

    public void print() {
        if (collection.isEmpty()) {
            throw new IllegalStateException("Invalid Operation!");
        }

        System.out.println(collection.get(currentIndex));
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {

            int internalIndex;
            @Override
            public boolean hasNext() {
                return internalIndex < collection.size();
            }

            @Override
            public String next() {
                String element = collection.get(internalIndex);
                internalIndex++;
                return element;
            }
        };
    }

    public void printAll() {
        System.out.println(String.join(" ", collection));
    }
}
