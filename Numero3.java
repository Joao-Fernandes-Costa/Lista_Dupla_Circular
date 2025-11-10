// Exercício 3: Lista Encadeada Circular Simples

class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Numero3 {
    Node tail;

    public Numero3() {
        this.tail = null;
    }

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (tail == null) {
            tail = newNode;
            tail.next = tail;
        } else {
            newNode.next = tail.next;
            tail.next = newNode;
            tail = newNode;
        }
    }

    // a
    public int count() {
        if (tail == null) {
            return 0;
        }

        int count = 0;
        Node start = tail.next;
        Node current = start;
        do {
            count++;
            current = current.next;
        } while (current != start);

        return count;
    }

    // b
    public void insertLeftOfHead(int data) {
        Node newNode = new Node(data);
        if (tail == null) {
            tail = newNode;
            tail.next = tail;
        } else {
            newNode.next = tail.next;
            tail.next = newNode;
            tail = newNode;
        }
    }

    // c
    public static Numero3 concatenate(Numero3 list1, Numero3 list2) {
        if (list1.tail == null) {
            return list2;
        }
        if (list2.tail == null) {
            return list1;
        }

        Node head1 = list1.tail.next;
        Node head2 = list2.tail.next;

        list1.tail.next = head2; 
        list2.tail.next = head1; 

        Numero3 newList = new Numero3();
        newList.tail = list2.tail; 

        list1.tail = null; 
        list2.tail = null;

        return newList;
    }

    // d
    public static Numero3 mergeOrdered(Numero3 list1, Numero3 list2) {
        if (list1.tail == null) return list2;
        if (list2.tail == null) return list1;

        Node h1 = list1.tail.next;
        Node h2 = list2.tail.next;
        list1.tail.next = null; 
        list2.tail.next = null;

        Node mergedHead = null;
        Node mergedTail = null;

        if (h1.data <= h2.data) {
            mergedHead = h1;
            h1 = h1.next;
        } else {
            mergedHead = h2;
            h2 = h2.next;
        }
        mergedTail = mergedHead;

        while (h1 != null && h2 != null) {
            if (h1.data <= h2.data) {
                mergedTail.next = h1;
                h1 = h1.next;
            } else {
                mergedTail.next = h2;
                h2 = h2.next;
            }
            mergedTail = mergedTail.next;
        }

        if (h1 != null) {
            mergedTail.next = h1;
        }
        if (h2 != null) {
            mergedTail.next = h2;
        }

        while (mergedTail.next != null) {
            mergedTail = mergedTail.next;
        }

        mergedTail.next = mergedHead;

        Numero3 mergedList = new Numero3();
        mergedList.tail = mergedTail;
        return mergedList;
    }

    // e
    public Numero3 copy() {
        Numero3 newList = new Numero3();
        if (tail == null) {
            return newList;
        }

        Node current = tail.next; 
        do {
            newList.insertAtEnd(current.data); 
            current = current.next;
        } while (current != tail.next);

        return newList;
    }
}
