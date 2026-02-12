package generics.wildcards;

class MyStack<T> {

    private T[] elements;
    private int size;
    private int capacity;

    // Default constructor
    public MyStack() {
        this.capacity = 10;
        this.elements = (T[]) new Object[capacity];
        this.size = 0;
    }

    // Push element
    public void push(T value) {
        if (size == capacity) {
            resize();
        }
        elements[size++] = value;
    }

    // Pop element
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        T value = elements[--size];
        elements[size] = null;  // Avoid memory leak
        return value;
    }

    // Peek element
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return elements[size - 1];
    }

    // Check empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Get size
    public int size() {
        return size;
    }

    // Resize logic (Double capacity)
    private void resize() {
        capacity = capacity * 2;
        T[] newArray = (T[]) new Object[capacity];

        for (int i = 0; i < size; i++) {
            newArray[i] = elements[i];
        }

        elements = newArray;
    }
}

public class BoundedTypeParameters {
    public static void main(String[] args) {

        MyStack<Integer> stack = new MyStack<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println(stack.pop());   // 30
        System.out.println(stack.peek());  // 20
        System.out.println(stack.size());  // 2
    }
}
