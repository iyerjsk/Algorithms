package LinkedList;

/**
 * Remove all elements from a linked list of integers that have value val.
 *
 * Example:
 *
 * Input:  1->2->6->3->4->5->6, val = 6
 * Output: 1->2->3->4->5
 */
public class RemoveLinkedListElements {
    public static class ListNode {
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

    public ListNode removeElements(ListNode head, int val) {
        ListNode node = head;
        ListNode prev = null;
        while (node != null) {
            if (node.val == val) {
                if (prev == null) {
                    head = node.next;
                    node = head;
                } else {
                    prev.next = node.next;
                    node = prev.next;
                }
            } else {
                prev = node;
                node = node.next;
            }
        }

        return head;
    }
}
