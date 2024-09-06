package solutions.pack9_Heap;

public class MyPriorityQueue implements MyQueueInterface {
    MyMinHeap heap = new MyMinHeap();

    @Override
    public void enqueue(int d) {
        if (!isFull()) {
            heap.insert(d);
        } else {
            System.out.println("Queue is full");
        }
    }

    @Override
    public int dequeue() {
        if (!isEmpty()) {
            return heap.remove();
        } else {
            System.out.println("Queue is empty");
            return -1;
        }
    }

    @Override
    public int front() {
        return heap.heap[0];
    }

    @Override
    public boolean isEmpty() {
        return heap.size == 0;
    }

    @Override
    public boolean isFull() {
        return heap.size == heap.MAX_SIZE;
    }

    @Override
    public String toString() {
        return heap.toString();
    }
}
