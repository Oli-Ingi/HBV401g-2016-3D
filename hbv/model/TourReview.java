package hbv.model;

import java.sql.Date;

public class TourReview extends Review{

	public TourReview(String review, String writer, Date date){
		this.reviewText = review;
		this.writer = writer;
		this.dateOfWriting = date;
	}
}
