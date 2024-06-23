import java.util.Stack;
/*To implement a queue using two stacks, 
 * we can take advantage of the "push" and "pop" operations of the stacks. 
 * The idea is to use one stack for enqueuing elements and another stack for dequeuing elements. 
 * 
 * Here's how you can achieve this:
 * Enqueue (push) Operation: Push the new element onto the first stack (stack1).
 * Dequeue (pop) Operation:
 * If the second stack (stack2) is empty, transfer all elements from the first stack (stack1) to the second stack (stack2). 
 * This reverses the order of the elements, making it possible to dequeue the oldest element.
 * Pop the top element from the second stack (stack2).
 * This approach ensures that each operation takes a constant amortized number of stack operations.
 * */

public class QueueWithTwoStack {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public QueueWithTwoStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // Enqueue operation
    public void enqueue(int data) {
        stack1.push(data);
    }

    // Dequeue operation
    public int dequeue() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        if (stack2.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        return stack2.pop();
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    // Peek at the front element without removing it
    public int peek() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        if (stack2.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        return stack2.peek();
    }

    public static void main(String[] args) {
        QueueWithTwoStack queue = new QueueWithTwoStack();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Dequeued: " + queue.dequeue()); // Output: 10
        System.out.println("Front element: " + queue.peek()); // Output: 20

        queue.enqueue(40);

        System.out.println("Dequeued: " + queue.dequeue()); // Output: 20
        System.out.println("Dequeued: " + queue.dequeue()); // Output: 30
        System.out.println("Dequeued: " + queue.dequeue()); // Output: 40
        System.out.println("Is queue empty? " + queue.isEmpty()); // Output: true
    }
}
