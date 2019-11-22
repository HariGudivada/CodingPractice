public class StackAndQueue {
    class Node {
        int data;
        Node next;

        Node(final int data) {
            this.data = data;
            next = null;
        }
    }

    class Stack {
        Node top;

        public int peek() {
            if (top == null) {
                throw new IllegalStateException("stack is empty");
            }

            return top.data;
        }

        public boolean isEmpty() {
            return top == null;
        }

        public void push(final int data) {
            final Node node = new Node(data);
            node.next = top;
            top = node;
        }

        public int pop () {
            if (top != null) {
                int data = top.data;
                top = top.next;

                return data;
            }

            throw new IllegalStateException("StackUsingArrayList is empty.");
        }
    }

    class Queue {
        Node head;
        Node tail;

        public boolean isEmpty (){
            return head == null;
        }

        public int peek () {
            if (head != null) {
                return head.data;
            }

            throw new IllegalStateException("Queue is empty.0");
        }

        public void add (int data) {
            Node node = new Node (data);
            if (tail != null) {
                tail.next = node;
            }

            tail = node;

            if (head == null) {
                head = node;
            }
        }

        public int remove () {
            if ( head != null) {
                int data = head.data;
                head = head.next;

                return data;
            }

            if (head == null) {
                tail = null;
            }

            throw new IllegalStateException("Queue is empty.");
        }
    }
}
