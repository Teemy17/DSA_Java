package solutions.pack9_Heap;

public class MyMinHeap {
    int MAX_SIZE = 6;
    int heap[] = new int[MAX_SIZE];
    int size = 0;

    public void insert(int d) {
        int p = size++;
        heap[p] = d;
        int parent = (p - 1) / 2;
        while (p > 0 && heap[p] < heap[parent]) { //check if the parent is greater than the child
            swap(p, parent);
            p = parent;
            parent = (p - 1) / 2;
        }
    }

    private void swap(int a, int b) {
        int temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }

    public int remove() {
        int d = heap[0];
        heap[0] = heap[--size];
        heap[size] = d; // keep root value at the unused space
        int p = 0;
        while (true) {
            int left = 2 * p + 1; // find index of left child
            if (left >= size) break; // no child
            int right = 2 * p + 2; // find index of right child
            if (right == size) { // one child
                if (heap[p] > heap[left])
                    swap(p, left);
                break; // no more child
            } else {
                int q = heap[left] < heap[right] ? left : right;
                if (heap[p] > heap[q]) swap(p, q);
                else break;
                p = q;
            }
        }
        return d;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(heap[i]).append(" ");
        }
        return sb.toString();
    }
}
