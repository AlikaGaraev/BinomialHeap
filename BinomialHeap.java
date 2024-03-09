/**
 * username1 - ishayyem
 * id1       - 322868852
 * name1     - Ishay Yemini
 * username2 - alikagaraev
 * id2       - 323222141
 * name2     - Alika Garaev
 * BinomialHeap
 *
 * An implementation of binomial heap over non-negative integers.
 * Based on exercise from previous semester.
 */
public class BinomialHeap {
	public int size;
	public HeapNode last;
	public HeapNode min;

	public BinomialHeap() {}

	public BinomialHeap(int size, HeapNode last, HeapNode min) {
		this.size = size;
		this.last = last;
		this.min = min;
	}

	/**
	 * pre: key > 0
	 * Insert (key,info) into the heap and return the newly generated HeapItem.
	 */
	public HeapItem insert(int key, String info) {
		HeapNode newNode = new HeapNode(key, info);

		this.meld(newNode.toHeap());

		return newNode.item;
	}

	/**
	 * Delete the minimal item
	 */
	public void deleteMin() {
		if (size == 0) return;
		// find new min
		// last is the same
	}

	/**
	 * Return the minimal HeapItem
	 */
	public HeapItem findMin() {
		return min.item;
	}

	/**
	 * pre: 0 < diff < item.key
	 * Decrease the key of item by diff and fix the heap.
	 */
	public void decreaseKey(HeapItem item, int diff) {
		// should be replaced by student code
	}

	/**
	 * Delete the item from the heap.
	 */
	public void delete(HeapItem item) {
		// should be replaced by student code
	}

	/**
	 * Meld the heap with heap2
	 */
	public void meld(BinomialHeap heap2) {
		// should be replaced by student code
	}

	/**
	 * Return the number of elements in the heap
	 */
	public int size() {
		return size; // should be replaced by student code
	}

	/**
	 * The method returns true if and only if the heap
	 * is empty.
	 */
	public boolean empty() {
		return size == 0;
	}

	/**
	 * Return the number of trees in the heap.
	 */
	public int numTrees() {
		return 0; // should be replaced by student code
	}

	/**
	 * Class implementing a node in a Binomial Heap.
	 */
	public class HeapNode {
		public HeapItem item;
		public HeapNode child;
		public HeapNode next;
		public HeapNode parent;
		public int rank;

		public HeapNode(int key, String info) {
			this.item = new HeapItem(this, key, info);
		}

		/**
		 * Return the node as a heap
		 */
		public BinomialHeap toHeap() {
			return new BinomialHeap(1, this, this);
		}
	}

	/**
	 * Class implementing an item in a Binomial Heap.
	 */
	public class HeapItem {
		public HeapNode node;
		public int key;
		public String info;

		public HeapItem(HeapNode node, int key, String info) {
			this.node = node;
			this.key = key;
			this.info = info;
		}
	}
}
