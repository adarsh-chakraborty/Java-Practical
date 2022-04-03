package p1;

public class User{
	private String firstName, lastName, country, email;; //property
		
	
	public void setFirstName(final String firstname){
		firstName = firstname;
	}	
	
	public String getFirstName(){
		return firstName;
	}

	// 
		public void setLastName(final String lastname){
		lastName = lastname;
	}	
	
	public String getLastName(){
		return lastName;
	}

	// 
	public void setCountry(final String usrCountry){
		country = usrCountry;
	}	
	
	public String getCountry(){
		return country;
	}
	//
	public void setEmail(final String userEmail){
		email = userEmail;
	}	
	
	public String getEmail(){
		return email;
	}
	
	public String getFullName(){
		return firstName + " " + lastName;
	} 
	
	public String getBIO(){
		return "Hello, I am "+ firstName+" " +lastName+  " and I am from "+ country + ".";
	}

	public String getMailtoUrl(){
		return "<a href=mailto:"+email+">"+email+"</a>";
	}
}