import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class RadioButton {
	private String firstName;
	private String lastName;
	private String language;
	List<String> languageList;
	
	public RadioButton(){
		languageList= new ArrayList<>();
		
		languageList.add("Java");
		languageList.add("Php");
		languageList.add("C#");
		languageList.add("Ruby");
	}

	public List<String> getLanguageList() {
		return languageList;
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

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}	
}
