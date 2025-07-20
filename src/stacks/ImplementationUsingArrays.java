package stacks;

public class ImplementationUsingArrays {

	private int top;
	private int[] array;

	public ImplementationUsingArrays(int capacity) {
		top = -1;
		array = new int[capacity];
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public boolean isStackFull() {
		return top == array.length - 1;
	}

	public void push(int val) {
		if (isStackFull()) {
			System.out.println("Stack Overflow!");
		} else {
			array[++top] = val;
		}
	}

	public int pop() {
		if (isEmpty()) {
			System.out.println("Stack Empty");
			return -1;
		} else {
			return array[top--];
		}
	}

	public void print() {
		System.out.print("Array contents: ");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println("\n(top index = " + top + ")");
	}

	public static void main(String[] args) {
		ImplementationUsingArrays stack = new ImplementationUsingArrays(5);
		stack.print();
		System.out.println("Is empty? " + stack.isEmpty());
		System.out.println();

		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);
		stack.print();
		System.out.println("Is full? " + stack.isStackFull());
		System.out.println();

		stack.push(60);
		stack.print();
		System.out.println();

		while (!stack.isEmpty()) {
			stack.pop();
			stack.print();
			System.out.println();
		}

		stack.pop();
		System.out.println("Is empty? " + stack.isEmpty());
	}

}
