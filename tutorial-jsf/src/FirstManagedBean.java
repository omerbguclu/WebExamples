import javax.faces.bean.ManagedBean;

@ManagedBean
public class FirstManagedBean {
	private String firstName;
	private String lastName;
	
	public FirstManagedBean(){		
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
