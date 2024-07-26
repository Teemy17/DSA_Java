package solutions.pack4;

public class MyLinkedList_661111 {
    public class Node {
        int data;
        Node next;
        public Node(int d) {
            data = d;
        }
        @Override
        public String toString() {
            return String.valueOf(data);
        }
    }
    Node head = null;

    public void add(int d) {
        Node n = new Node(d);
        n.next = head;
        head = n;
    }

    public void insert(int d) {
        Node newNode = new Node(d);
        if (head == null || head.data >= d) {
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null && current.next.data < d) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    public void delete(int d) {
        Node t = new Node(0);
        t.next = head;
        Node p = t;
        while( (p.next!=null) && (p.next.data!=d) ) {
            p = p.next;
        }
        if(p.next!=null) {
            p.next = p.next.next;
        }
        head = t.next;
    }

    public int find(int d) {
        Node p = head;
        int pos = 0;
        while (p != null) {
            if (p.data == d) return pos;
            p = p.next;
            pos++;
        }
        return -1;
    }

    public int size() {
        Node p = head;
        int count = 0;
        while (p != null) {
            count++;
            p = p.next;
        }
        return count;
    }

    public void add(int[] d) {
        for (int i = d.length - 1; i >= 0; i--) {
            add(d[i]);
        }
    }

    public void insert(int[] d) {
        for (int v : d) {
            insert(v);
        }
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("head ");
        Node p = head;
        while(p!=null) {
            sb.append("--> [");
            sb.append(p.data);
            sb.append("] ");
            p = p.next;
        }
        sb.append("-> null");
        return new String(sb);
    }
}
