package ps.leetcode;

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

    // just 1 iteration with 'walker & runner'

    public ListNode middleNode2(ListNode head) {
        ListNode walker = head;
        ListNode runner = head;

        while(runner != null) {
            runner = runner.next;

            if(runner != null) {
                walker = walker.next;
                runner = runner.next;
            }
        }

        return walker;
    }

    public ListNode middleNode3(ListNode head) {
        ListNode walker = head;
        ListNode runner = head;

        while(runner != null && runner.next != null) {
            walker = walker.next;
            runner = runner.next.next;
        }

        return walker;
    }

    public class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

}
