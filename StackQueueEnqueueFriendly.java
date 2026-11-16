
import java.util.Stack;

public class StackQueueEnqueueFriendly {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public StackQueueEnqueueFriendly() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void enqueue(int value) {

        stack1.push(value);

        System.out.println(value + " added to queue.");
    }

    public int dequeue() {

        if (stack1.isEmpty() && stack2.isEmpty()) {
            throw new RuntimeException("Queue is empty!");
        }

        if (stack2.isEmpty()) {

            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();
    }

    public int peek() {

        if (stack1.isEmpty() && stack2.isEmpty()) {
            throw new RuntimeException("Queue is empty!");
        }

        if (stack2.isEmpty()) {

            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.peek();
    }

    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public int size() {
        return stack1.size() + stack2.size();
    }

    public static void main(String[] args) {

        StackQueueEnqueueFriendly queue =
                new StackQueueEnqueueFriendly();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Front element: " + queue.peek());

        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Dequeued: " + queue.dequeue());

        queue.enqueue(40);

        System.out.println("Front element: " + queue.peek());

        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Dequeued: " + queue.dequeue());

        System.out.println("Is queue empty: " + queue.isEmpty());
    }
}
