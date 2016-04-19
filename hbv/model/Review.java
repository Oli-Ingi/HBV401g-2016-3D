package hbv.model;



public abstract class Review {

	protected String reviewText;
	protected String writer;
	protected String dateOfWriting;
	protected int likes;
	
	
	public String getText(){
		return reviewText;
	}
	
	public String getWriter(){
		return writer;
	}
	
	public String getDate(){
		return dateOfWriting;
	}
	
	public int getLikeAmount(){
		return likes;
	}
	
	public void likeReview(){
		likes++;
	}
}
