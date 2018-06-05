package businessLogic;

public class Graph {
	List articles=new List();
	List users=new List();
	List outfits = new List();
	
	public void addArticle(Article a) {
		Article temp=(Article)articles.head;
		while(temp!=null) {
			Edge e = new Edge(temp,a);
			temp.Adjacency.put(e);
			a.Adjacency.put(e);
			temp=(Article)temp.next;
		}
		articles.put(a);
	}
	
	public void addWardrobe(List articles) {
		Article temp = (Article) articles.head;
		while(temp!=null) {
			addArticle(temp);
		}
	}
	
	public void addOutfit(User u,List items) {
		Outfit o = new Outfit(items);
		outfits.put(o);
		u.getAdjacency().put(o);
	}
	
	public void addOutfit(List items) {
		Outfit o = new Outfit(items);
		outfits.put(o);
	}
	
	public void addOutfit(User u, Outfit o) {
		outfits.put(o);
		u.getAdjacency().put(o);
	}
	
	public void addUser(User u) {
		users.put(u);
	}
	
	
	public List generate(User u,float[] metadata) {
		List filtered = BFSfilter(u,metadata);
		List generated = new List();
		Outfit o = (Outfit)filtered.head;
		while(o!=null) {
			Article temp = (Article) o.getAdjacency().head;
			while(temp!=null) {
				List items = generateOutfit(temp,new int[] {0,0,0,0});
				if(!items.isEmpty())
					generated.put(new Outfit(items));
				temp=(Article)temp.next;
			}
			o=(Outfit) o.next;
		}
		return generated;
	}
	
	public List generateOutfit(Article a, int[] types) {
		List items = new List();
		Article temp = (Article) a.Adjacency.max.oppositeNode(a);
		types[a.type-1]=1;
		if(types[temp.type-1]==0) {
			items.put(generateOutfit(temp,types));
			items.put(temp);
		}
		//temp=(Article) temp.next;
		return items;
	}
	
	public List BFSfilter(User u, float[] metadata) {
		List adj = u.getAdjacency();
		List output=new List();
		Outfit temp = (Outfit) adj.head;
		while(temp!=null) {
			if(Graph.distance(temp.metadata, metadata)<=0.25) {
				output.put(temp);;
			}
			temp=(Outfit)temp.next;
		}
		
		return output;
	}
	
	
	public static float distance(float[] m1, float[] m2) {
		return (float) Math.sqrt(Math.pow(m1[0]-m2[0], 2)+Math.pow(m1[1]-m2[1], 2));
	}
	
}
