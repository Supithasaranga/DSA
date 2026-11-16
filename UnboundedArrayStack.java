
public class UnboundedArrayStack {

    private int[] stack;
    private int top;
    private int initialCapacity;

    public UnboundedArrayStack() {
        initialCapacity = 4;
        stack = new int[initialCapacity];
        top = -1;
    }

    private void grow() {
        int newCapacity = stack.length * 2;

        int[] newStack = new int[newCapacity];

        for (int i = 0; i <= top; i++) {
            newStack[i] = stack[i];
        }

        stack = newStack;

        System.out.println("Array capacity increased to: "
                + stack.length);
    }

    private void shrink() {

        if (stack.length > initialCapacity
                && size() <= stack.length / 4) {

            int newCapacity = Math.max(
                    initialCapacity, stack.length / 2);

            int[] newStack = new int[newCapacity];

            for (int i = 0; i <= top; i++) {
                newStack[i] = stack[i];
            }

            stack = newStack;

            System.out.println("Array capacity decreased to: "
                    + stack.length);
        }
    }

    public void push(int value) {

        if (top == stack.length - 1) {
            grow();
        }

        stack[++top] = value;

        System.out.println(value + " pushed into stack.");
    }

    public int pop() {

        if (isEmpty()) {
            throw new RuntimeException("Stack is empty!");
        }

        int removed = stack[top];
        stack[top] = 0;
        top--;

        shrink();

        return removed;
    }

    public int peek() {

        if (isEmpty()) {
            throw new RuntimeException("Stack is empty!");
        }

        return stack[top];
    }

    public int size() {
        return top + 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void display() {

        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return;
        }

        System.out.print("Stack elements: ");

        for (int i = top; i >= 0; i--) {
            System.out.print(stack[i] + " ");
        }

        System.out.println();
    }

    public int getCapacity() {
        return stack.length;
    }

    public static void main(String[] args) {

        UnboundedArrayStack stack =
                new UnboundedArrayStack();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        stack.push(50);
        stack.push(60);

        stack.display();

        System.out.println("Top element: " + stack.peek());
        System.out.println("Current capacity: "
                + stack.getCapacity());

        System.out.println("Popped: " + stack.pop());
        System.out.println("Popped: " + stack.pop());
        System.out.println("Popped: " + stack.pop());
        System.out.println("Popped: " + stack.pop());

        stack.display();

        System.out.println("Current capacity: "
                + stack.getCapacity());
    }
}
