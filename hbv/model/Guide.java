package hbv.model;

import java.util.ArrayList;

public class Guide {
	
	private String name;
        private String nickName;
	private int age;
	private String gender;
	private String profile;
	private ArrayList<GuideReview> reviews;
	
	public Guide(String name, String nickName,int age, String gender, String profile){
		this.name = name;
                this.nickName = nickName;
		this.age = age;
		this.gender = gender;
		this.profile = profile;
                reviews = new ArrayList<>();
	}

	public String getName() {
		return name;
	}
        
        public String getNickName(){
            return nickName;
        }

	public int getAge() {
		return age;
	}
	
	public String getGender(){
		return gender;
	}
	
	public String getProfile(){
		return profile;
	}
	
	public ArrayList<GuideReview> getReviews() {
		return reviews;
	}
        
        public void setReview(GuideReview review){
            this.reviews.add(review);
        }
        
        public void clearReviews(){
            this.reviews.clear();
        }
        
        public void setName(String newName){
            this.name = newName;
        }
        
        public void setNickName(String nick){
            this.nickName = nick;
        }
        
        public void setAge(int newAge){
            this.age = newAge;
        }
        
        public void setGender(String newGender){
            // I guess people can redefine their gender these days.
            this.gender = newGender;
        }
        
        public void setProfile(String updatedProfile){
            this.profile = updatedProfile;
        }
        
        @Override
        public String toString(){
            return this.name;
        }
}
