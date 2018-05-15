package businessLogic;

public class Article extends Node{
	int type;
	String colour;
	
	/**
	 * this article creates a new clothing article
	 * @param type 		1	jacket
	 * 					2	shirt/blouse
	 * 					3	pants/troussers
	 * 					4	footwear
	 * @param colour RGB code for the colour
	 */
	public Article(int type, String colour) {
		//super();
		this.type = type;
		this.colour = colour;
	}
	
	public Article(int type, String colour, String[] keywords) {
		this(type, colour);
		this.keywords=keywords;
	}

	public void setId(int type,String colour) {
		this.id=Integer.toString(type)+colour;
	}

	public boolean matches(Article article) {
		//TODO implement function to match colour and type of two distinct articles of clothing
		boolean matches = this.matches(article);
		return matches;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}
	
	
}
