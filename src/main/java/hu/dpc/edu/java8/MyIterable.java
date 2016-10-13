package hu.dpc.edu.java8;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by vrg on 13/10/16.
 */
public class MyIterable implements Iterable<String> {

    private String[] elements;

    public MyIterable(String... elements) {
        this.elements = elements;
    }

    private class MyIterator implements Iterator<String> {

        private int nextIndex = 0;

        @Override
        public boolean hasNext() {
            return elements.length > nextIndex;
        }

        @Override
        public String next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No such element");
            }
            String next = elements[nextIndex++];
            return next;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Remove not supported");
        }
    }

    @Override
    public Iterator<String> iterator() {
        return new MyIterator();
    }

}
