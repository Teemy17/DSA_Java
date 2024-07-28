package solutions.pack3;

public class MyArray_661111 extends MyArrayBasic {
    protected int MAX_SIZE = 100_000;

    public MyArray_661111(int size) {
        this.data = new int[size];
        this.MAX_SIZE = size;
    }

    public MyArray_661111() {
        this.data = new int[MAX_SIZE];
    }

    @Override
    public void add(int d) {
        if (isFull()) {
            expand();
        }
        data[size] = d;
        size++;
    }

    @Override
    public void insert(int d, int index) {
        if (isFull()) {
            expand();
        }
        if (index < 0 || index > size) {
            System.out.println("Invalid index");
            return;
        }
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = d;
        size++;
    }

    public boolean isFull() {
        return size >= data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }



    public int[] expandByK(int k) {
        int newMaxSize = data.length * k;
        int[] newData = new int[newMaxSize];
        if (size >= 0) System.arraycopy(data, 0, newData, 0, size);
        data = newData;
        MAX_SIZE = newMaxSize;
        return data;
    }

    public int[] expand() {
        return expandByK(2);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
