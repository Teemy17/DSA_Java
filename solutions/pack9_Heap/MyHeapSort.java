package solutions.pack9_Heap;

public class MyHeapSort extends MyMinHeap {

    public String sort() {
        StringBuilder sb = new StringBuilder();
        int OriginalSize = size;

        for (int i = 0; i < OriginalSize; i++) {
            sb.append(remove()).append(" ");
        }
        return sb.toString();
    }
}
