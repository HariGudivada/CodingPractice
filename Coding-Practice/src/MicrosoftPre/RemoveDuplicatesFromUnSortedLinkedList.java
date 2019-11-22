package MicrosoftPre;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesFromUnSortedLinkedList {
    private static class Node {
        int val;
        Node next;
        Node(int val) {
            this.val = val;
        }
    }
    public static void removeDuplicates(Node root) {
        if (root == null) {
            return;
        }

        Set<Integer> visited = new HashSet<>();
        visited.add(root.val);
        Node prev = root;
        Node temp = root.next;
        while (temp != null) {
            if (visited.contains(temp.val)) {
                prev.next = temp.next;
            } else {
                prev = prev.next;
                visited.add(temp.val);
            }
            temp = prev.next;
        }
    }

    public static void main(String[] args)
    {
        /* The constructed linked list is:
         10->12->11->11->12->11->10*/
        Node start = new Node(10);
        start.next = new Node(12);
        start.next.next = new Node(11);
        start.next.next.next = new Node(11);
        start.next.next.next.next = new Node(12);
        start.next.next.next.next.next = new Node(11);
        start.next.next.next.next.next.next = new Node(10);

        System.out.println("Linked list before removing duplicates :");
        printList(start);

        removeDuplicates(start);

        System.out.println("\nLinked list after removing duplicates :");
        printList(start);
    }

    static void printList(Node head)
    {
        while (head != null)
        {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
