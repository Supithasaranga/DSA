public class SinglyLinkedList {

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    public void insertAtBeginning(int data) {

        Node newNode = new Node(data);

        newNode.next = head;
        head = newNode;

        System.out.println(data + " inserted at beginning");
    }

    public void insertAtEnd(int data) {

        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;

        System.out.println(data + " inserted at end");
    }

    public void delete(int data) {

        if (head == null) {
            System.out.println("List is empty!");
            return;
        }

        if (head.data == data) {
            head = head.next;
            System.out.println(data + " deleted");
            return;
        }

        Node current = head;

        while (current.next != null &&
               current.next.data != data) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Element not found!");
            return;
        }

        current.next = current.next.next;

        System.out.println(data + " deleted");
    }

    public boolean search(int data) {

        Node current = head;

        while (current != null) {

            if (current.data == data) {
                return true;
            }

            current = current.next;
        }

        return false;
    }

    public void display() {

        if (head == null) {
            System.out.println("List is empty!");
            return;
        }

        Node current = head;

        System.out.print("Linked List: ");

        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }

        System.out.println("NULL");
    }

    public static void main(String[] args) {

        SinglyLinkedList list = new SinglyLinkedList();

        list.insertAtBeginning(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.insertAtBeginning(5);

        list.display();

        list.delete(20);

        list.display();

        System.out.println("Search 30: " + list.search(30));
        System.out.println("Search 50: " + list.search(50));
    }
}
