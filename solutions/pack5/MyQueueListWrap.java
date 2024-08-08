package solutions.pack5;

import java.util.Iterator;
import java.util.LinkedList;

public class MyQueueListWrap<T> implements Iterable<T> {
    private final LinkedList<T> list = new LinkedList<>();
    private int count = 0;

    public void add(T d) {
        list.add(d);
        count++;
    }

    public T get(int index) {
        return list.get(index);
    }

    public void enqueue(T d) {
        list.addLast(d);
        count++;
    }

    public T dequeue() {
        if (count == 0) {
            return null;
        }
        count--;
        return list.removeFirst();
    }

    public T top() {
        return list.getFirst();
    }

    public T getLast() {
        return list.getLast();
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return false;
    }

    public int size() {
        return count;
    }

    public String dumpToString() {
        StringBuilder sb = new StringBuilder();
        for (T t : list) {
            sb.append(t).append(" ");
        }
        return sb.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new AnyItemsIterator(this);
    }

    @Override
    public String toString() {
        return dumpToString();
    }

    private class AnyItemsIterator
            implements Iterator<T> {
        private final MyQueueListWrap<T> lis;
        private int idx;

        public AnyItemsIterator(MyQueueListWrap<T> arg) {
            this.lis = arg;
        }

        @Override
        public boolean hasNext() {
            return (idx < lis.count);
        }

        @Override
        public T next() {
            return lis.list.get(idx++);
        }
    }
}
