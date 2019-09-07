package stack;

interface StackQueueInterface<T> {
	void push(T ob) throws FullStackException;
	T pop() throws EmptyStackException;
	int getLength(); // Length of array.
	int getItemCount(); // Number of items currently stored.
}
