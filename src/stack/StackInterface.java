package stack;

interface StackInterface<T> {
	void push(T ob);
	T pop();
	int getLength(); // Length of array.
	int getCount(); // Number of items currently stored.
}
