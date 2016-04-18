package hbv.model;

import java.sql.Date;

public class GuideReview extends Review{
	
	public GuideReview(String review, String writer, Date date){
		this.reviewText = review;
		this.writer = writer;
		this.dateOfWriting = date;
	}
}
