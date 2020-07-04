package com.practise;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class MergeSortedList {

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res;
        if(l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        if (l1.val <= l2.val) {
            res = new ListNode(l1.val);
            l1 = l1.next;
        } else {
            res = new ListNode(l2.val);
            l2 = l2.next;
        }

        ListNode head = res;

        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                res.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                res.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            res = res.next;
        }

        while(l1 != null) {
            res.next = new ListNode(l1.val);
            l1 = l1.next;
            res = res.next;
        }

        while(l2 != null) {
            res.next = new ListNode(l2.val);
            l2 = l2.next;
            res = res.next;
        }

        return head;
    }

    public static void main(String[] args) {

        int[] nums = { 1, 2, 3, 3 };
        //System.out.println(mergeTwoLists(null, null));

    }

}
