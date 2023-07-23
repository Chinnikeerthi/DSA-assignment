
import java.util.Scanner;


public class ReverseGroup {
    public static ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode current = head;

        while (current != null && count < k) {
            current = current.next;
            count++;
        }

        if (count < k) {
            return head;
        }

        current = head;
        ListNode prev = null;
        for (int i = 0; i < k; i++) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        
        head.next = reverseKGroup(current, k);

        return prev;
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

        System.out.print("Enter the value of k (positive integer): ");
        int k = scanner.nextInt();
        scanner.close();

        ListNode inputHead = dummy.next;

        System.out.println("Original Linked List:");
        printLinkedList(inputHead);

        ListNode reversedHead = reverseKGroup(inputHead, k);

        System.out.println("\nLinked List after reversing nodes in groups of " + k + ":");
        printLinkedList(reversedHead);
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
