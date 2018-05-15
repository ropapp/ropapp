package businessLogic;

public class List {
	Node head = null;
	Node tail = null;
	
	public boolean isEmpty() {
		return (head.next==null);
	}
	
	public void put(Node node) {
		// TODO implement put node
		
	}
	
	public void put(Node node, int index) {
		// TODO implement put node at position index
	}
	
	public Node remove(int index) {
		Node node = new Node();
		return node;
		
		//TODO implement remove node
	}
	/**
	 * This function imlplements the interpolation search algorithm.
	 * @param n Node to be searched
	 * @return Index of Node n in the list
	 */
	public int interpolationSearch(Node n) {
		int i=0;
		return i;
		
		//TODO implement interpolation search
	}

}
