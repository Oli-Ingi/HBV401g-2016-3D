package hbv.model;



public class GuideReview extends Review{
	
	public GuideReview(String review, String writer, String date){
		this.reviewText = review;
		this.writer = writer;
		this.dateOfWriting = date;
	}
}
