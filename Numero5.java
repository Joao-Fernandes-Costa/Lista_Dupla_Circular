class Numero5 {
    class Node {
    String data;
    Node next;
    Node prev;
    public Node(String data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
    private Node head;
    public Numero5() {
        head = new Node(null);
        head.next = head;
        head.prev = head;
    }
    public boolean isEmpty() {
        return head.next == head;
    }
    public void insertAtBeginning(String data) {
        Node newNode = new Node(data);
        Node firstNode = head.next;
        newNode.next = firstNode;
        newNode.prev = head;
        
        head.next = newNode;
        firstNode.prev = newNode;
    }
    public void insertAtEnd(String data) {
        Node newNode = new Node(data);
        Node lastNode = head.prev;
        newNode.next = head;
        newNode.prev = lastNode;
        lastNode.next = newNode;
        head.prev = newNode;
    }
    public boolean remove(String data) {
        Node current = head.next;
        while (current != head) {
            if (current.data.equals(data)) {
                Node prevNode = current.prev;
                Node nextNode = current.next;
                prevNode.next = nextNode;
                nextNode.prev = prevNode;
                return true;
            }
            current = current.next;
        }
        return false;
    }
    public int count() {
        int count = 0;
        Node current = head.next;
        while (current != head) {
            count++;
            current = current.next;
        }
        return count;
    }
    public void display() {
        if (isEmpty()) {
            System.out.println("Lista Vazia.");
            return;
        }
        
        System.out.print("Lista (Início -> Fim): ");
        Node current = head.next;
        while (current != head) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("(Head)");
    }
    public void displayReverse() {
        if (isEmpty()) {
            System.out.println("Lista Vazia.");
            return;
        }
        System.out.print("Lista (Fim -> Início): ");
        Node current = head.prev;
        while (current != head) {
            System.out.print(current.data + " <-> ");
            current = current.prev;
        }
        System.out.println("(Head)");
    }
}

