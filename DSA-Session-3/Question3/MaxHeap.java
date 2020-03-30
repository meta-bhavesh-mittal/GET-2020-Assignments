package Session3.Question3;

import java.util.Scanner;

public class MaxHeap {
	private int size;
	private Bowler[] heap;

	public MaxHeap(int maxSize) {
		this.size = 0;
		this.heap = new Bowler[maxSize + 1];
		this.heap[size] = new Bowler(0, 0);
	}

	public int parent(int current) {
		return current / 2;
	}

	public void swap(int current, int parent) {
		Bowler temp;
		temp = heap[current];
		heap[current] = heap[parent];
		heap[parent] = temp;
	}

	/**
	 * 
	 * @param bowler
	 *            Insert a bowler into heap
	 */
	public void insert(Bowler bowler) {

		heap[++size] = bowler;
		System.out.println("At " + size + " inserted " + bowler.toString()
				+ "," + heap[size].toString());
		// Traverse up and fix violated property
		int current = size;
		while (current > 1 && heap[current].getBalls() > heap[parent(current)].getBalls()) {
			swap(current, parent(current));
			current = parent(current);
		}
	}

	/**
	 * Extract a bowler from heap
	 */
	public int extract() {
		// System.out.println(heap[1].ball +" "+heap[1].bowler);

		Bowler extractedBolwer = heap[1];
		heap[1] = heap[size--];
		heapify(1);
		return extractedBolwer.getBowler();

	}

	/**
	 * It Resets the Heap again.
	 * 
	 * @param pos
	 */
	public void heapify(int pos) {
		if (isLeaf(pos))
			return;
		System.out.println("POS -> " + pos + " left->" + leftChild(pos) + "->"
				+ heap[leftChild(pos)].toString() + " right-> "
				+ rightChild(pos) + "->" + heap[rightChild(pos)].toString());

		if (heap[pos].getBalls() < heap[leftChild(pos)].getBalls()
				|| heap[pos].getBalls() < heap[rightChild(pos)].getBalls()) {

			if (heap[leftChild(pos)].getBalls() > heap[rightChild(pos)]
					.getBalls()) {
				swap(pos, leftChild(pos));
				heapify(leftChild(pos));
			} else {
				swap(pos, rightChild(pos));
				heapify(rightChild(pos));
			}
		}
	}

	/**
	 * 
	 * @param pos
	 * @return Returns right child of a node
	 */
	public int rightChild(int pos) {
		return (pos * 2) + 1;
	}

	/**
	 * 
	 * @param pos
	 * @return Returns Left child of a node
	 */
	public int leftChild(int pos) {
		return pos * 2;
	}

	/**
	 * 
	 * @param pos
	 * @return If pos node is leaf return True otherwise False
	 */
	public boolean isLeaf(int pos) {
		if (pos > size / 2 && pos <= size)
			return true;
		return false;
	}

	public Bowler getMaxBowler() {

		return this.heap[1];
	}

	public boolean isMaxFromItsChild(int pos) {
		if (this.heap[pos].getBalls() >= heap[leftChild(pos)].getBalls()
				&& this.heap[pos].getBalls() >= heap[rightChild(pos)]
						.getBalls())
			return true;
		return false;
	}

	/**
	 * Return the order of Bowlers in which Virat will play bowlers
	 * 
	 * @param remainingBowls
	 */
	public void playVirat(int remainingBowls) {
		// TODO Auto-generated method stub
		int[] orderOfBowlers = new int[remainingBowls];
		int index = 0;

		while (remainingBowls > 0) {

			while (this.isMaxFromItsChild(1) && remainingBowls > 0) {
				if (this.getMaxBowler().getBalls() == 0) {
					this.extract();
				}
				orderOfBowlers[index] = this.getMaxBowler().getBowler();
				this.getMaxBowler()
						.setBalls(this.getMaxBowler().getBalls() - 1);
				remainingBowls -= 1;
				index += 1;
			}
			this.heapify(1);
		}

		for (int i = 0; i < index; i++)
			System.out.print(orderOfBowlers[i] + ",");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Total no. of bowlers : ");
		int noOfBowlers = sc.nextInt();

		System.out.println("Enter Total no. of bolws Virat going to plae: ");
		int remainingBowls = sc.nextInt();

		MaxHeap maxHeap = new MaxHeap(noOfBowlers);

		System.out.println("Enter quota of each bolwer : ");
		for (int i = 0; i < noOfBowlers; i++) {
			int ball = sc.nextInt();
			Bowler newBowler = new Bowler(i + 1, ball);
			maxHeap.insert(newBowler);
		}
		for (Bowler bowler : maxHeap.heap) {
			System.out.println("-----" + bowler.toString());
		}
		maxHeap.playVirat(remainingBowls);
		sc.close();
	}

}
