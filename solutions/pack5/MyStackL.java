package solutions.pack5;

public class MyStackL {
    public class Node {
        String value;
        Node next;

        public Node(String d) {
            value = d;
            next = null;
        }
    }

    private Node top;
    public MyStackL() {
        top = null;
    }

    public void push(String d) {
        Node n = new Node(d);
        n.next = top;
        top = n;
    }

    public String pop() {
        if (top == null) {
            throw new IllegalStateException("pop: stack is empty");
        }
        else {
            String d = top.value;
            top = top.next;
            return d;
        }
    }

    public String peek() {
        if (top == null) {
            throw new IllegalStateException("peek: stack is empty");
        }
        else {
            return top.value;
        }
    }

    public boolean isFull() {
        return false;
    }

    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new
                StringBuilder();
        sb.append("Top->");
        Node temp = top;
        while (temp != null) {
            sb.append(temp.value).append("->");
            temp = temp.next;
        }
        sb.append("Bottom");
        return sb.toString();
    }
}

