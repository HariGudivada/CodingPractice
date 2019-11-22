package GrokkingCodingInterview;

class PalindromicLinkedList {

    public static boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;
       while (fast != null && fast.next != null) {
           slow = slow.next;
           fast = fast.next.next;
       }


       ListNode second = reverse(slow);
       ListNode copyOfSecond = second;

       while (head!=null && second!=null) {
           if (head.val != second.val) {
               break;
           }
           head = head.next;
           second = second.next;
       }
       reverse(copyOfSecond);
       if(head == null || second == null) {
           return true;
       }

       return false;
    }

    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head =next;
        }

        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(2);
        System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));

//        head.next.next.next.next.next = new ListNode(2);
//        System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));
    }
}
