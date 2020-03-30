package Session2.InfixEval;

public class StackImpl<T> implements Stack<T> {

	private int stackSize;
	private T[] stackArr;
	private int top;

	/**
	 * constructor to create stack with size
	 * 
	 * @param size
	 */
	@SuppressWarnings("unchecked")
	public StackImpl(int size) {
		this.stackSize = size;
		this.stackArr = (T[]) new Object[stackSize];
		this.top = -1;
	}

	/**
	 * This method adds new entry to the top of the stack
	 * 
	 * @param entry
	 * @throws Exception
	 */
	@Override
	public void push(T entry) {
		if (this.isStackFull()) {
			System.out.println(("Stack is full."));
			// this.increaseStackCapacity();
			return;
		}
		System.out.println("Adding: " + entry);
		this.stackArr[++top] = entry;
	}

	/**
	 * This method removes an entry from the top of the stack.
	 * 
	 * @return
	 * @throws Exception
	 */
	@Override
	public T pop(){
		if (this.isStackEmpty()) {
			System.out.println("Stack is empty. Can not remove element.");
			return null;
		}
		T entry = this.stackArr[top--];
		System.out.println("Removed entry: " + entry);
		return entry;
	}

	/**
	 * This method returns top of the stack without removing it.
	 * 
	 * @return
	 */
	@Override
	public T peek() {
		return stackArr[top];
	}

	//
	// private void increaseStackCapacity(){
	//
	// @SuppressWarnings("unchecked")
	// T[] newStack = (T[]) new Object[this.stackSize*2];
	// for(int i=0;i<stackSize;i++){
	// newStack[i] = this.stackArr[i];
	// }
	// this.stackArr = newStack;
	// this.stackSize = this.stackSize*2;
	// }

	/**
	 * This method returns true if the stack is empty
	 * 
	 * @return
	 */
	@Override
	public boolean isStackEmpty() {
		return (top == -1);
	}

	/**
	 * This method returns true if the stack is full
	 * 
	 * @return
	 */
	@Override
	public boolean isStackFull() {
		return (top == stackSize - 1);
	}

	@Override
	public int size() {
		return top;
	}
	
	@Override
	public T secondPeek() {
		if(top > 0)
			return stackArr[top-1];
		return null;
	}
}
