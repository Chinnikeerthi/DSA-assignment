import java.util.Scanner;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class MergeAndSortLinkedLists {
    public static Node mergeLinkedLists(Node head1, Node head2) {
    	Node dummy = new Node(-1);
        Node current = dummy;

        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                current.next = head1;
                head1 = head1.next;
            } else {
                current.next = head2;
                head2 = head2.next;
            }
            current = current.next;
        }

        if (head1 != null) {
            current.next = head1;
        } else {
            current.next = head2;
        }

        return dummy.next;
    }

    public static Node sortLinkedList(Node head) {
    	if (head == null || head.next == null) {
            return head;
        }

        Node middle = getMiddle(head);
        Node nextOfMiddle = middle.next;
        middle.next = null;

        Node left = sortLinkedList(head);
        Node right = sortLinkedList(nextOfMiddle);

        return mergeSortedLists(left, right);
    }

    private static Node getMiddle(Node head) {
        if (head == null) {
            return head;
        }

        Node slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static Node mergeSortedLists(Node left, Node right) {
        Node dummy = new Node(-1);
        Node current = dummy;

        while (left != null && right != null) {
            if (left.data < right.data) {
                current.next = left;
                left = left.next;
            } else {
                current.next = right;
                right = right.next;
            }
            current = current.next;
        }

        if (left != null) {
            current.next = left;
        } else {
            current.next = right;
        }

        return dummy.next;
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

                System.out.println("Enter elements for Linked List 1:");
        String[] input1 = scanner.nextLine().split(" ");
        Node head1 = null;
        Node tail1 = null;
        for (String str : input1) {
            int num = Integer.parseInt(str);
            Node newNode = new Node(num);
            if (head1 == null) {
                head1 = newNode;
                tail1 = newNode;
            } else {
                tail1.next = newNode;
                tail1 = newNode;
            }
        }

        System.out.println("Enter elements for Linked List 2:");
        String[] input2 = scanner.nextLine().split(" ");
        Node head2 = null;
        Node tail2 = null;
        for (String str : input2) {
            int num = Integer.parseInt(str);
            Node newNode = new Node(num);
            if (head2 == null) {
                head2 = newNode;
                tail2 = newNode;
            } else {
                tail2.next = newNode;
                tail2 = newNode;
            }
        }

        scanner.close();

        System.out.println("Merged LinkedList:");
        Node mergedList = mergeLinkedLists(head1, head2);
        printLinkedList(mergedList);

        System.out.println("\nSorted LinkedList:");
        Node sortedList = sortLinkedList(mergedList);
        printLinkedList(sortedList);
    }
}
