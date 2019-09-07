package general;

public interface StackQueueInterface<T> {
	void push(T ob) throws FullArrayException;
	T pop() throws EmptyArrayException;
	int getLength(); // Length of array.
	int getItemCount(); // Number of items currently stored.
}
