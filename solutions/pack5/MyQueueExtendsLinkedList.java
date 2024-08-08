package solutions.pack5;

import java.util.LinkedList;

public class MyQueueExtendsLinkedList<T> extends LinkedList<T> {
    public void enqueue(T d) {
        this.add(d);
    }

    public T dequeue() {
        return this.poll();
    }

    public T top() {
        return this.peek();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean isFull() {
        return false;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("front->");
        for (T t : this) {
            sb.append("[");
            sb.append(t);
            sb.append("]->");
        }
        sb.append("rear");
        return new String(sb);
    }
}
