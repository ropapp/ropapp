package businessLogic;

public class Graph {
	public List users,articles,outfits;
	public List wears, //from user to article or outfit
				includes, //from outift to article
				matches, //from article to article (Bidirectional)
				liked, //from user to outfit or article
				created; //from user to outfit
	
	/**
	 * This method traverses over the graph
	 * @return
	 */
	public List traverse() {
		//TODO implement the graph traversing algorithm
		return null;
	}
	
	
	public void addUser(User user) {
		this.users.put(user);
	}
	
	public void addArticle(Article article) {
		this.articles.put(article);
	}
	
	public void addOutfit(Outfit outfit) {
		this.outfits.put(outfit);
	}
	
	public void wears(User u, Article a) {
		this.wears.put(new Edge(u,a,false));
	}
	
	public void wears(User u, Outfit o) {
		this.wears.put(new Edge(u,o,false));
	}
	
	public void includes(Outfit o, Article a) {
		this.includes.put(new Edge(o,a,false));
	}
	
	public void matches(Article a1, Article a2) {
		this.matches.put(new Edge(a1,a2,true));
	}

	
	public void liked(User u, Outfit o) {
		this.liked.put(new Edge(u,o,false));
		
		//If a user likes an outfit, it means she likes each of the articles in the outfit
		
		Edge temp = (Edge) o.outputEdges.head;
		while(temp.next!=null) {
			
			liked(u,(Article) temp.oppositeNode(o));
		}
	}
	
	public void liked(User u, Article a) {
		this.liked.put(new Edge(u,a,false));
	}
	
	public void created(User u, Outfit o) {
		this.created.put(new Edge(u,o,false));
		
		//If an user creates an article, it means that she likes it
		
		liked(u,o);
	}
}
