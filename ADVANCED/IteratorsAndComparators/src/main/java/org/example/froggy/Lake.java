package org.example.froggy;

import java.util.Iterator;
import java.util.List;

public class Lake implements Iterable<Integer> {
    private class Froggy implements Iterator<Integer> {

        private int index = 0;
        private boolean firstRoundEnd = false;
        @Override
        public boolean hasNext() {
            return index < numbers.size();
        }

        @Override
        public Integer next() {
            int num = numbers.get(index);
            index += 2;
            if (index >= numbers.size() && !firstRoundEnd) {
                index = 1;
                firstRoundEnd = true;
            }
            return num;
        }
    }
    private List<Integer> numbers;
    public Lake(Integer... numbers) {
        this.numbers = List.of(numbers);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Froggy();
    }
}
