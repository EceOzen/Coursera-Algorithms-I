import java.util.Stack;
/*To efficiently support stack operations (push and pop) along with a max operation that returns the maximum element, 
 * you can use a main stack to store the elements and an auxiliary stack to keep track of the maximum elements.
 * Here’s how it works:
 * Push Operation: When you push an element onto the main stack, also push it onto the auxiliary stack if it is greater than or equal to the current maximum. Otherwise, push the current maximum again.
 * Pop Operation: When you pop an element from the main stack, also pop an element from the auxiliary stack.
 * Max Operation: The top of the auxiliary stack always contains the maximum element.
 * */

public class MaxStack {
    private Stack<Double> mainStack;
    private Stack<Double> maxStack;

    public MaxStack() {
        mainStack = new Stack<>();
        maxStack = new Stack<>();
    }

    // Push element onto the stack
    public void push(double x) {
        mainStack.push(x);
        if (maxStack.isEmpty() || x >= maxStack.peek()) {
            maxStack.push(x);
        } else {
            maxStack.push(maxStack.peek());
        }
    }

    // Pop element from the stack
    public double pop() {
        if (mainStack.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        maxStack.pop();
        return mainStack.pop();
    }

    // Get the maximum element
    public double max() {
        if (maxStack.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return maxStack.peek();
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return mainStack.isEmpty();
    }

    // Get the size of the stack
    public int size() {
        return mainStack.size();
    }

    public static void main(String[] args) {
        MaxStack stack = new MaxStack();
        
        stack.push(5);
        System.out.println("Current max: " + stack.max()); // 5

        stack.push(1);
        System.out.println("Current max: " + stack.max()); // 5

        stack.push(5);
        System.out.println("Current max: " + stack.max()); // 5

        System.out.println("Popped: " + stack.pop()); // 5
        System.out.println("Current max: " + stack.max()); // 5

        System.out.println("Popped: " + stack.pop()); // 1
        System.out.println("Current max: " + stack.max()); // 5

        stack.push(7);
        System.out.println("Current max: " + stack.max()); // 7

        stack.push(3);
        System.out.println("Current max: " + stack.max()); // 7

        System.out.println("Popped: " + stack.pop()); // 3
        System.out.println("Current max: " + stack.max()); // 7

        System.out.println("Popped: " + stack.pop()); // 7
        System.out.println("Current max: " + stack.max()); // 5

        stack.push(8);
        System.out.println("Current max: " + stack.max()); // 8

        System.out.println("All tests passed!");
    }
}
