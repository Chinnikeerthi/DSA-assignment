
import java.util.HashSet;
import java.util.Scanner;

class Node1 {
    int data;
    Node1 next;

    public Node1(int data) {
        this.data = data;
        this.next = null;
    }
}

public class RemoveDuplicatesFromLinkedList {
    public static void removeDuplicates(Node head) {
        if (head == null || head.next == null) {
            return;
        }

        HashSet<Integer> set = new HashSet<>();
        Node current = head;
        Node prev = null;

        while (current != null) {
            if (set.contains(current.data)) {
                prev.next = current.next;
            } else {
                set.add(current.data);
                prev = current;
            }
            current = current.next;
        }
    }

    public static void printLinkedList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter elements for Linked List:");
        Node head = null;
        Node tail = null;
        int num;
        while ((num = scanner.nextInt()) != -1) {
            Node newNode = new Node(num);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        scanner.close();

        System.out.println("\nOriginal LinkedList:");
        printLinkedList(head);

        removeDuplicates(head);

        System.out.println("\nLinkedList after removing duplicates:");
        printLinkedList(head);
    }
}
