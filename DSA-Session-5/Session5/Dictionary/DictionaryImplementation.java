package Session5.Dictionary;

import java.util.ArrayList;

public class DictionaryImplementation {

	Node root;
	ArrayList<Node> listRange;
	ArrayList<Node> list;
	public static int COUNT = 9;

	public DictionaryImplementation() {
		root = null;
		list = new ArrayList<Node>();
		listRange = new ArrayList<Node>();
	}

	/**
	 * This method is used to insert Key
	 * 
	 * @param
	 */
	public void insertKey(Node data) {
		root = insertKeyRecursively(root, data);
	}

	/**
	 * This method is used to insert key recurvisely
	 * 
	 * @param root
	 * @param data
	 * @return
	 */
	private Node insertKeyRecursively(Node root, Node data) {
		if (root == null) {
			root = data;
		} else if (data.key < root.key) {
			root.leftChild = insertKeyRecursively(root.leftChild, data);
		} else if (data.key > root.key) {
			root.rightChild = insertKeyRecursively(root.rightChild, data);
		}

		return root;
	}

	/**
	 * This method is used to print bst
	 * 
	 * @param root
	 */

	public static void print2D(Node root, int space) {
		// Base case
		if (root == null)
			return;

		// Increase distance between levels
		space += COUNT;

		// Process right child first
		print2D(root.rightChild, space);

		// Print current node after space
		// count
		System.out.print("\n");
		for (int i = COUNT; i < space; i++)
			System.out.print(" ");
		System.out.print(root.key + "\n");

		// Process left child
		print2D(root.leftChild, space);
	}

	/**
	 * This method is used to find minimum of the nodes.
	 * 
	 * @param root
	 * @return
	 */
	private Node findMinimum(Node root) {
		while (root != null) {
			root = root.leftChild;
		}
		return root;
	}

	/**
	 * This method is used to delete key
	 * 
	 * @param
	 */
	public Node deleteKey(int data) {

		root = deleteKeyRecursively(root, data);
		return root;
	}

	/**
	 * This method is used to delete recursively
	 * 
	 * @param root
	 * @param data
	 * @return
	 */
	private Node deleteKeyRecursively(Node root, int data) {
		Node result;
		if (root == null) {
			return root;
		} else if (data < root.key) {
			root.leftChild = deleteKeyRecursively(root.leftChild, data);
		} else if (data > root.key) {
			root.rightChild = deleteKeyRecursively(root.rightChild, data);
		} else {

			if(root.leftChild==null && root.rightChild ==null){
				root =null;
			}
			else if(root.leftChild!=null && root.rightChild ==null){
				root= root.leftChild;
			}
			else if(root.leftChild==null && root.rightChild !=null){
				root =root.rightChild;
			}

			else {

				Node sucessor = inOrderTraversal(root);
				//  System.out.println(sucessor.key + "----->" + sucessor.value);
				root.key = sucessor.key;
				root.value = sucessor.value;
				root.rightChild = deleteKeyRecursively(root.rightChild, sucessor.key);
				result = root;

			}
		}
		result = root;
		return result;
	}

	/**
	 * This method is used to get key value
	 * 
	 * @param
	 */
	public String getKeyValue(int data) {
		String result="Value for this Key Does NOT EXIST";
		Node node = this.root;
		while (node != null) {

			if (node.key == data) {
				result = node.value;
				break;
			} else if (node.key > data) {
				node = node.leftChild;
			} else {
				node = node.rightChild;
			}
		}
		return result;
	}

	/**
	 * This method is used to get Sorted list .
	 * 
	 * @param node
	 */
	public void getSortedList(Node root) {

		if (root == null) {
			return;
		}
		getSortedList(root.leftChild);
		list.add(root);
		// System.out.println(root.key);
		getSortedList(root.rightChild);

	}

	/**
	 * This method is used to get Sorted list in range .
	 * 
	 * @param Node
	 */
	public void getSortedListRange(Node root, int key1, int key2) {

		if (root == null) {
			return;
		}
		getSortedListRange(root.leftChild, key1, key2);

		if (root.key >= key1 && root.key <= key2) {
			listRange.add(root);
			System.out.println(root.key);
		}
		getSortedListRange(root.rightChild, key1, key2);
	}

	/**
	 * This method is used for inorder traversal
	 * 
	 * @param root
	 * @return
	 */
	public Node inOrderTraversal(Node root) {

		if (root == null) {
			return null;
		}

		Node temp = root.rightChild;
		Node res = null;
		while (temp != null) {
			res = temp.leftChild;

		}
		System.out.println(res.value);
		return temp;
	}

	public static void main(String[] args) {
		DictionaryImplementation d = new DictionaryImplementation();

		Node n1 = new Node(8, "BHAVESH");
		d.insertKey(n1);
		Node n2 = new Node(3, "MITTAL");
		d.insertKey(n2);
		Node n3 = new Node(10, "ABC");
		d.insertKey(n3);
		Node n4 = new Node(1, "DEF");
		d.insertKey(n4);
		Node n5 = new Node(6, "CCC");
		d.insertKey(n5);
		Node n6 = new Node(14, "DDD");
		d.insertKey(n6);
		Node n7 = new Node(4, "EEE");
		d.insertKey(n7);
		Node n8 = new Node(7, "FFF");
		d.insertKey(n8);
		Node n9 = new Node(13, "GGG");
		d.insertKey(n9);
		// d.show();
		d.print2D(n1, 0);
		//d.deleteKey(3);
		//d.print2D(n1, 8);
		//d.getSortedListRange(n1, 4, 13);
		//String res = d.getKeyValue(13);
		//System.out.println(res);
		//d.print2D(n1, 0);
	}
}