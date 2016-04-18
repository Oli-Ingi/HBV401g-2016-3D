package hbv.model;

import java.sql.Date;

public abstract class Review {

	protected String reviewText;
	protected String writer;
	protected Date dateOfWriting;
	protected int likes;
	
	
	public String getText(){
		return reviewText;
	}
	
	public String getWriter(){
		return writer;
	}
	
	public Date getDate(){
		return dateOfWriting;
	}
	
	public int getLikeAmount(){
		return likes;
	}
	
	public void likeReview(){
		likes++;
	}
}
