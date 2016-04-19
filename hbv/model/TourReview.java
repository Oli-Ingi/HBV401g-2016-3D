package hbv.model;


public class TourReview extends Review{

	public TourReview(String title, String review, String writer, String date, int likes){
		this.reviewText = review;
                this.reviewTitle = title;
		this.writer = writer;
		this.dateOfWriting = date;
                this.likes = likes;
	}
}
