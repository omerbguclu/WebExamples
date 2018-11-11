import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class DropDown {
	private String firstName;
	private String lastName;
	private String country;
	List<String> countryList;
	
	public DropDown(){
		countryList= new ArrayList<>();
		
		countryList.add("Turkey");
		countryList.add("Cyprus");
	}

	public List<String> getCountryList() {
		return countryList;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}	
}
