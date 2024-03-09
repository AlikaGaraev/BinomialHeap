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
	public int treeNum;
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
		this.size += heap2.size();

		// Merge the two heaps
		HeapNode node1 = this.last.next;
		HeapNode node2 = heap2.last.next;
		if (this.last.next.rank > heap2.last.next.rank) {
			node1 = heap2.last.next;
			node2 = this.last.next;
		}
		while (node1 != this.last && node1 != heap2.last) {
			if (node1.next.rank > node2.rank) {
				HeapNode oldNext = node1.next;
				node1.setNext(node2);
				node2 = oldNext;
			}
			node1 = node1.next;
		}
		node2.setNext(node1.next);
		node1.setNext(node2);
		this.last = node2;

		// Consolidate the trees if needed and find the new min
		HeapNode node = this.last.next;
		HeapNode oldNode = this.last;
		HeapNode min = node;
		this.treeNum = 0;
		while (node != this.last) {
			if (node.rank == node.next.rank && node.rank != node.next.next.rank) {
				node = mergeTrees(node, node.next);
				oldNode.next = node;
			}
			if (node.item.key < min.item.key) min = node;
			this.treeNum++;

			oldNode = node;
			node = node.next;
		}
		this.min = min;
	}

	HeapNode mergeTrees(HeapNode n1, HeapNode n2) {
		if (n1.rank != n2.rank) return n1;
		if (n1.item.key > n2.item.key) {
			n1.next = n2.next;
			return mergeTrees(n2, n1);
		}
		if (n2.child != null) {
			n1.next = n2.child.next;
			n2.child.next = n1;
		}
		n2.child = n1;
		n1.parent = n2;
		n2.rank++;
		return n2;
	}

	/**
	 * Return the number of elements in the heap
	 */
	public int size() {
		return this.size;
	}

	/**
	 * The method returns true if and only if the heap
	 * is empty.
	 */
	public boolean empty() {
		return this.size == 0;
	}

	/**
	 * Return the number of trees in the heap.
	 */
	public int numTrees() {
		return this.treeNum;
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

		public void setNext(HeapNode next) {
			this.next = next;
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
