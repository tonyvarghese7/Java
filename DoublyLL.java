import java.util.Scanner;

class Node {
    int data;
    Node prev;
    Node next;

    public Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class DoublyLinkedList {
    Node head;

    // Method to insert a new node at the end of the list
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
        }
    }

    // Method to delete a given element from the list
    public void delete(int key) {
        Node current = head;
        while (current != null && current.data != key) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Element not found in the list.");
            return;
        }

        if (current.prev != null) {
            current.prev.next = current.next;
        } else {
            head = current.next;
        }

        if (current.next != null) {
            current.next.prev = current.prev;
        }
    }

    // Method to display the contents of the list
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

public class DoublyLL {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a doubly linked list
        DoublyLinkedList list = new DoublyLinkedList();
        System.out.print("Enter the number of elements in the list: ");
        int n = scanner.nextInt();
        System.out.print("Enter the elements of the list: ");
        for (int i = 0; i < n; i++) {
            int data = scanner.nextInt();
            list.insert(data);
        }

        // Display the initial list
        System.out.println("Initial list:");
        list.display();

        // Delete a given element
        System.out.print("Enter the element to delete: ");
        int elementToDelete = scanner.nextInt();
        list.delete(elementToDelete);

        // Display the updated list
        System.out.println("List after deletion:");
        list.display();

        scanner.close();
    }
}
