package MicrosoftPre;
 class ListNode {
    int val;
    ListNode next;
    public ListNode(int val) {
        this.val = val;
    }
}

public class AddTwoNumbers {
    public static ListNode addTwoNodes(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        int carry = 0;
        ListNode curr = node;
        while (l1 != null || l2 != null) {
           int val1 = l1 != null ? l1.val : 0;
           int val2 = l2 != null ? l2.val : 0;
           int sum = val1+val2+carry;
           curr.next = new ListNode(sum%10);
           curr = curr.next;
           carry = sum/10;
           if (l1 != null) {
               l1= l1.next;
           }
           if (l2 != null) {
               l2 = l2.next;
           }
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return node.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(8);

        ListNode l2 = new ListNode(8);
        l2.next = new ListNode(5);
        l2.next.next = new ListNode(7);

        addTwoNodes(l1, l2);

    }
}
