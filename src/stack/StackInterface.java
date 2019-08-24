package stack;

interface StackInterface<T> {
	void push(T ob);
	T pop();
	int getLength();
	T[] getStack();
}
