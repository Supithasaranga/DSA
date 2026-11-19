public class DoublyLinkedList {

    class Node {
        int data;
        Node previous;
        Node next;

        Node(int data) {
            this.data = data;
            this.previous = null;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;

    public void insertAtBeginning(int data) {

        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        }

        System.out.println(data + " inserted at beginning");
    }

    public void insertAtEnd(int data) {

        Node newNode = new Node(data);

        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }

        System.out.println(data + " inserted at end");
    }

    public void delete(int data) {

        Node current = head;

        while (current != null && current.data != data) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Element not found!");
            return;
        }

        if (current == head) {
            head = current.next;
        }

        if (current == tail) {
            tail = current.previous;
        }

        if (current.previous != null) {
            current.previous.next = current.next;
        }

        if (current.next != null) {
            current.next.previous = current.previous;
        }

        System.out.println(data + " deleted");
    }

    public void displayForward() {

        Node current = head;

        System.out.print("Forward: ");

        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }

        System.out.println("NULL");
    }

    public void displayBackward() {

        Node current = tail;

        System.out.print("Backward: ");

        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.previous;
        }

        System.out.println("NULL");
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

    public static void main(String[] args) {

        DoublyLinkedList list = new DoublyLinkedList();

        list.insertAtBeginning(20);
        list.insertAtBeginning(10);
        list.insertAtEnd(30);
        list.insertAtEnd(40);

        list.displayForward();
        list.displayBackward();

        list.delete(30);

        list.displayForward();

        System.out.println("Search 40: " + list.search(40));
        System.out.println("Search 50: " + list.search(50));
    }
}
