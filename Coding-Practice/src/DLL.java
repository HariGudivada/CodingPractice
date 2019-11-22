public class DLL<T> {
    public DLL(){

    }
    private Node head;
    private Node tail;

    public void insertAtBegin(final T value) {
        if (head == null) {
            head = new Node(value);
            tail = head;
        }else {
            head.prev = new Node(value);
            head.prev.next = head;
            head = head.prev;
        }
    }

    public void insertAtEnd(final T value) {
        if (head == null) {
            head = new Node(value);

            tail = head;
        }else {
            tail.next = new Node(value);
            tail.next.prev = tail;
            tail = tail.next;
        }
    }

    public void print() {
        Node<T> curr = head;
        while(curr != null) {
            System.out.println(curr.value);
            curr = curr.next;
        }
    }

    public class Node<T> {
        T value;
        Node<T> next;
        Node<T> prev;

        public Node(T value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        DLL dll = new DLL();
        dll.insertAtEnd(1);
        dll.insertAtEnd(2);
        dll.insertAtBegin(3);
        dll.insertAtEnd(4);
        dll.insertAtEnd(5);
        dll.insertAtEnd(6);
//        dll.print();
        System.out.println("18/10:" + 18/10);
        System.out.println("18%10:"+ 18%10 );
    }
}
