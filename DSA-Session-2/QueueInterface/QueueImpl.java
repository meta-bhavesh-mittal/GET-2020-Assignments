package Session2.QueueInterface;

public class QueueImpl<T> implements Queue<T> {
	
	private int front,rear,size;
	private T queue[];

	@SuppressWarnings("unchecked")
	public QueueImpl(int size) {
		this.front = -1;
		this.rear = -1;
		this.size = size;
		this.queue = (T[]) new Object[size];
	}

	@Override
	public boolean isFull() {
		if((rear+1)%size == front)
				return true;
		return false;
	}

	@Override
	public void enqueue(T t) {
		if(isFull()){
			System.out.println("OVERFLOW");
			System.out.println(queue);
			return;
		} else if(front == -1 && rear == -1) {
			front = 0;
			rear = 0;
		} else if(rear == size-1 && front !=0) {
			rear = 0;
		} else {
			rear = (rear+1)%size;
		}
		
		queue[rear] = t;
		System.out.println(t + " Added");
	}

	@Override
	public T dequeue() {
		// TODO Auto-generated method stub
		T deleted = null;
		if(front > -1)
			deleted = queue[front];
		if(isEmpty()) {
			System.out.println("UNDERFLOW");
			return null;
		} else if(front == rear) {
			front = -1;
			rear = -1;
		} else if (front == size-1) {
			front = 0;
		} else {
			front = front + 1;
		}
		return deleted;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return front == -1;
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		int i = front;
		if(isEmpty()){
			System.out.println("Queue is Empty.");
			return;
		}
		if(front <= rear) {
			while(i <= rear) {
				System.out.print(queue[i]+" <- ");
				i += 1;
			}
		} else {
			while(i < size) {
				System.out.print(queue[i]+" <- ");
				i += 1;
			}
			i = 0;
			while(i <= rear) {
				System.out.print(queue[i]+" <- ");
				i += 1;
			}
		}
	}

}
