

import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class SwapAdjacentNodes {
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null && curr.next != null) {
            ListNode next = curr.next;
            curr.next = next.next;
            next.next = curr;

            if (prev == null) {
                head = next;
            } else {
                prev.next = next;
            }

            prev = curr;
            curr = curr.next;
        }

        return head;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements in the linked list: ");
        int n = scanner.nextInt();

        System.out.println("Enter the elements of the linked list:");
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        for (int i = 0; i < n; i++) {
            int val = scanner.nextInt();
            current.next = new ListNode(val);
            current = current.next;
        }

        ListNode inputHead = dummy.next;
        scanner.close();

        System.out.println("Original Linked List:");
        printLinkedList(inputHead);

        ListNode swappedHead = swapPairs(inputHead);

        System.out.println("\nLinked List after swapping adjacent nodes:");
        printLinkedList(swappedHead);
    }

    private static void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
