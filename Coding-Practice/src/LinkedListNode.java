import java.util.LinkedList;
import java.util.Queue;

public class LinkedListNode {
    int val;
    LinkedListNode left, right;
    LinkedListNode next;

    public LinkedListNode(int value) {
        this.val = value;
        left = null;
        right = null;
    }

    public void insert(int value) {
        if (value <= val) {
            if (left == null) {
                left = new LinkedListNode(value);
            } else {
                left.insert(value);
            }
        } else {
            if (right == null) {
                right = new LinkedListNode(value);
            } else {
                right.insert(value);
            }
        }
    }

    public boolean contains(int val) {
        if (this.val == val) {
            return true;
        }
        if (val <= this.val) {
            if (left == null) {
                return false;
            }
            return left.contains(val);
        } else {
            if (right == null) return false;
            return right.contains(val);
        }
    }

    public void inOrder() {
        if (left != null) {
            left.inOrder();
        }
        System.out.println(val);
        if (right != null) {
            right.inOrder();
        }
    }


    public static void main(String[] args) {
        LinkedListNode one = new LinkedListNode(1);
        one.left = new LinkedListNode(1);

        LinkedListNode second = new LinkedListNode(1);
        second.right = new LinkedListNode(1);

        Queue<Integer> queue = new LinkedList<>();

    }

    private boolean hasCircle (LinkedListNode head) {
        if (head == null) { return false;}
        LinkedListNode slow = head;
        LinkedListNode fast = head.next;

        while (fast != null && fast.next.next != null) {
            if (fast == slow) {
                return true;
            }

            fast = fast.next.next;
            slow = slow.next;
        }

        return false;
    }


}

