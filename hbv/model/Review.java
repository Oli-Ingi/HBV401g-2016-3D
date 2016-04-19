package hbv.model;



public abstract class Review {

	protected String reviewText;
	protected String writer;
	protected String dateOfWriting;
	protected int likes;
        protected String reviewTitle;
	
	
	public String getText(){
		return reviewText;
	}
	
        public String getTitle(){
            return reviewTitle;
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
