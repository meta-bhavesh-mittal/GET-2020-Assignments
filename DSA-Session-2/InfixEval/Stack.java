package Session2.InfixEval;

public interface Stack<T> {
	public void push(T t);
	public T pop();
	public T peek();
	public int size();
	boolean isStackEmpty();
	boolean isStackFull();
	public T secondPeek();
}
