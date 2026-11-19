import java.util.Stack;

public class StackQueue {

    private Stack<Integer> inputStack;
    private Stack<Integer> outputStack;

    public StackQueue() {
        inputStack = new Stack<>();
        outputStack = new Stack<>();
    }

    public void enqueue(int value) {
        inputStack.push(value);
        System.out.println(value + " added to queue");
    }

    public int dequeue() {

        if (inputStack.isEmpty() && outputStack.isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }

    
        if (outputStack.isEmpty()) {
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }

        return outputStack.pop();
    }

  
    public int peek() {

        if (inputStack.isEmpty() && outputStack.isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }

        if (outputStack.isEmpty()) {
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }

        return outputStack.peek();
    }

 
    public boolean isEmpty() {
        return inputStack.isEmpty() && outputStack.isEmpty();
    }

    public static void main(String[] args) {

        StackQueue queue = new StackQueue();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Removed: " + queue.dequeue());
        System.out.println("Front: " + queue.peek());
        System.out.println("Removed: " + queue.dequeue());

        System.out.println("Is Queue Empty: " + queue.isEmpty());
    }
}
