package GrokkingCodingInterview;

class RearrangeList {

    public static void reorder(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next.next != null) {
            fast = fast.next.next;
        }
        ListNode second = reverse(slow);
        ListNode first = head;

        while (first != null && second !=null) {
            ListNode temp = first.next;
            first.next = second;
            first = temp;

            temp = second.next;
            second.next = first;
            second = temp;
        }

        if (first != null)
            first.next = null;
    }

    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next = new ListNode(12);
        RearrangeList.reorder(head);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}