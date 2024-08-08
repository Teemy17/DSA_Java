package solutions.pack5;

public class MyQueueL<T> extends MyQueueListWrap<T> {
    public void enqueue(T d) {
        this.add(d);
    }

    public T dequeue() {
        return this.dequeue();
    }

    public T Top() {
        return this.get(0);
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
