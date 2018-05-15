package businessLogic;

public class Edge extends Node{
	Node inputNode, outputNode;
	boolean bidirectional;
	int distance;
	float weight;
	
	/**
	 * This method links two nodes. Additionaly it can make the link bidrectional
	 * @param u
	 * @param v
	 * @param bidirectional
	 */
	public Edge(Node u, Node v,boolean bidirectional) {
		this.unlink();
		
		this.inputNode=u;
		this.inputNode=v;
		
		this.setBidirectional(bidirectional);
			
		
	}
	
	/**
	 * This method adds this Edge to the adjancency list of Node u.
	 * @param u 
	 * @param direction 1 for output edge, and -1 for input edge.
 	 */
	public void linkTo(Node u, int direction) {
		if(direction==1)
			u.outputEdges.put(this);
		else if(direction==-1)
			u.inputEdges.put(this);
		u.edges.put(this);
	}
	

	/**
	 * @param node
	 * @return Node to wich input Node n is connected to, null in case it doesn't exists 
	 */
	public Node oppositeNode(Node node) {
		Node opposite = (node.equals(inputNode))?outputNode:(node.equals(outputNode)?inputNode:null);
		return opposite;
	}
	
	/**
	 * Removes connections from Nodes
	 */
	public void unlink() {
		//TODO implement the method to unlink two Nodes. That is, remove eachother from their respective adjacency Lists and eliminate this connection
	}
	
	
	//getters and setters
	public boolean isBidirectional() {
		return bidirectional;
	}
	
	/**
	 * If input argument is true then inputNode is added to the adjancency list of outputNode and viceversa.
	 * @param bidirectional true if the connection is bidirectional, false if it is unidirectional
	 */
	public void setBidirectional(boolean bidirectional) {
		this.bidirectional=bidirectional;
		if(this.isBidirectional()) {
			this.linkTo(this.inputNode,1);
			this.linkTo(this.outputNode, 1);
		}
	}

	public int getDistance() {
		return distance;
	}
	
	/**
	 * This function sets the distance between two Nodes and sets the weight of the connection between both Nodes as the inverse of the distance
	 * @param distance
	 */
	public void setDistance(int distance) {
		this.distance = Math.abs(distance);
		this.setWeight(1/distance);
	}

	public float getWeight() {
		return weight;
	}
	
	public void setWeight(float weight) {
		this.weight = weight;
	}
	
	
}
