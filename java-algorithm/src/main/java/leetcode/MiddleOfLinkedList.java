package leetcode;

public class MiddleOfLinkedList {

    public ListNode middleNode(ListNode head) {
        ListNode temp = head;

        int count = 1;
        while(temp.next != null) {
            count++;
            temp = temp.next;
        }

        int mid = count / 2;
        while(mid > 0) {
            mid--;
            head = head.next;
        }

        return head;
    }

    public class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

}
