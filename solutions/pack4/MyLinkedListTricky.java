package solutions.pack4;

public class MyLinkedListTricky extends MyLinkedList_661111 {
    public void q1_rotate_counter_clockwise(int k) {
        if (head == null) return;
        Node p = head;
        int len = 1;
        while (p.next != null) {
            p = p.next;
            len++;
        }
        p.next = head;
        k = k % len;
        k = len - k;
        while (k-- > 0) {
            p = p.next;
        }
        head = p.next;
        p.next = null;

    }

    public void q2_reverse() {
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    public void q3_remove_dup() {
        Node p = head;
        while (p != null) {
            Node q = p;
            while (q.next != null) {
                if (q.next.data == p.data) {
                    q.next = q.next.next;
                } else {
                    q = q.next;
                }
            }
            p = p.next;
        }
    }

    public void q4_add_one() {
        Node p = head;
        Node prev = null;
        Node temp = null;
        while (p != null) {
            if (p.data != 9) {
                prev = p;
            }
            p = p.next;
        }
        if (prev == null) {
            temp = new Node(1);
            temp.next = head;
            head = temp;
        } else {
            prev.data++;
            prev = prev.next;
            while (prev != null) {
                prev.data = 0;
                prev = prev.next;
            }
        }
    }

    public boolean q5_isPalindrome() {
        Node p = head;
        Node q = head;
        Node prev = new Node(0);
        prev.next = head;
        while (q != null && q.next != null) {
            prev = prev.next;
            p = p.next;
            q = q.next.next;
        }
        Node mid = p;
        Node midNext = p.next;
        mid.next = null;
        Node prev2 = null;
        Node current = midNext;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev2;
            prev2 = current;
            current = next;
        }
        Node p1 = head;
        Node p2 = prev2;
        while (p1 != null && p2 != null) {
            if (p1.data != p2.data) {
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }

}
