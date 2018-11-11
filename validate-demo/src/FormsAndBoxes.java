import javax.faces.bean.ManagedBean;

@ManagedBean
public class FormsAndBoxes {
	private String firstName;
	private String lastName;
	private String[] language;

	public FormsAndBoxes(){

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

	public String[] getLanguage() {
		return language;
	}

	public void setLanguage(String[] language) {
		this.language = language;
	}
}
