import javax.faces.bean.ManagedBean;

@ManagedBean
public class StudentCountry {
	private String country;
	
	public StudentCountry(){		
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}


}
