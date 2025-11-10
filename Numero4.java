// Exercício 4: Lista Circular Duplamente Encadeada
class DNode {
    int data;
    DNode next;
    DNode prev;
    DNode(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
class Numero4 {
    DNode sentinel;
    public Numero4() {
        sentinel = new DNode(0);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }
    public boolean isEmpty() {
        return sentinel.next == sentinel;
    }
    //a
    public int count() {
        int count = 0;
        DNode current = sentinel.next;
        while (current != sentinel) {
            count++;
            current = current.next;
        }
        return count;
    }
    // b
    public void insertLeftOfHead(int data) {
        DNode newNode = new DNode(data);
        DNode last = sentinel.prev; 

        newNode.next = sentinel;  
        newNode.prev = last;      
        
        last.next = newNode;      
        sentinel.prev = newNode;  
    }
    
    public void insertRightOfHead(int data) {
        DNode newNode = new DNode(data);
        DNode first = sentinel.next; 
        
        newNode.next = first;
        newNode.prev = sentinel;
        
        sentinel.next = newNode;
        first.prev = newNode;
    }


    // c
    public static Numero4 concatenate(Numero4 list1, Numero4 list2) {
        if (list1.isEmpty()) return list2;
        if (list2.isEmpty()) return list1;

        DNode first1 = list1.sentinel.next;
        DNode last1 = list1.sentinel.prev;
        DNode first2 = list2.sentinel.next;
        DNode last2 = list2.sentinel.prev;

        last1.next = first2;
        first2.prev = last1;

        last2.next = list1.sentinel;
        list1.sentinel.prev = last2;
        
        list2.sentinel.next = list2.sentinel;
        list2.sentinel.prev = list2.sentinel;

        return list1; 
    }

    // d
    public static Numero4 mergeOrdered(Numero4 list1, Numero4 list2) {
        Numero4 mergedList = new Numero4();
        
        DNode c1 = list1.sentinel.next;
        DNode c2 = list2.sentinel.next;

        while (c1 != list1.sentinel && c2 != list2.sentinel) {
            if (c1.data <= c2.data) {
                mergedList.insertLeftOfHead(c1.data); 
                c1 = c1.next;
            } else {
                mergedList.insertLeftOfHead(c2.data); 
                c2 = c2.next;
            }
        }

        while (c1 != list1.sentinel) {
            mergedList.insertLeftOfHead(c1.data);
            c1 = c1.next;
        }
        
        while (c2 != list2.sentinel) {
            mergedList.insertLeftOfHead(c2.data);
            c2 = c2.next;
        }
        
        return mergedList;
    }

    // e
    public Numero4 copy() {
        Numero4 newList = new Numero4();
        DNode current = this.sentinel.next; 
        while (current != this.sentinel) {
            newList.insertLeftOfHead(current.data); 
            current = current.next;
        }
        return newList;
    }
}