import javax.faces.bean.ManagedBean;

@ManagedBean
public class PrePopulated {
	private String firstName;
	private String lastName;
	private String favoriteLanguage;
	
	public PrePopulated(){
		firstName="Ahmet";
		lastName="Mehmet";
		favoriteLanguage="Ruby";
	}

	public String getFavoriteLanguage() {
		return favoriteLanguage;
	}

	public void setFavoriteLanguage(String favoriteLanguage) {
		this.favoriteLanguage = favoriteLanguage;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}	
}
