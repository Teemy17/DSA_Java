package solutions.pack3;

public class MyArrayBasic {
    protected int MAX_SIZE = 5;
    protected int[] data = new int[MAX_SIZE];
    protected int size = 0;

    public MyArrayBasic(int... d) {
        if (d != null && d.length > 5) {
            MAX_SIZE = d.length;
            data = new int[MAX_SIZE];
        }
        if (d != null) {
            for (int element : d) {
                data[size] = element;
                size++;
            }
        }
    }

    public void add(int d) {
        if (size < MAX_SIZE) {
            data[size] = d;
            size++;
        }
        else {
            System.out.println("Array is full");
        }
    }

    public void insert(int d, int index) {
        if (size < MAX_SIZE && index >= 0 && index <= size) {
            for (int i = size; i > index; i--) {
                data[i] = data[i - 1];
            }
            data[index] = d;
            size++;
        }
    }

    public int find(int d) {
        for (int i = 0; i < size; i++) {
            if (data[i] == d) {
                return i;
            }
        }
        return -1;
    }

    public int binary_Search(int d) {
        int left = 0;
        int right = size - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (data[mid] == d) {
                return mid;
            } else if (data[mid] < d) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public void delete(int index) {
        if (index >= 0 && index < size) {
            for (int i = index; i < size - 1; i++) {
                data[i] = data[i + 1];
            }
            size--;
        }
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


