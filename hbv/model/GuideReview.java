package hbv.model;



public class GuideReview extends Review{
	
	public GuideReview(String title, String review, String writer, String date){
		this.reviewText = review;
                this.reviewTitle = title;
		this.writer = writer;
		this.dateOfWriting = date;
	}
}
