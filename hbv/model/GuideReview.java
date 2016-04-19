package hbv.model;



public class GuideReview extends Review{
	
	public GuideReview(String title, String review, String writer, String date, int likes){
		this.reviewText = review;
                this.reviewTitle = title;
		this.writer = writer;
		this.dateOfWriting = date;
                this.likes = 0;
	}
}
