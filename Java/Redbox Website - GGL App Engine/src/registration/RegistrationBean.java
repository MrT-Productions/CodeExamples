/*
 *RegistrationBean.java 1.0 Oct,4 2011 
 *
 *Copyright (c) 2011 Thonda D. Taylor II Inc.
 *Campus Box 7792, Elon University, Elon, NC 27244
 */
package registration;

import java.util.Locale;
import java.util.ResourceBundle;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletRequest;

/**
 * @author ThondaT2
 * @version Final
 * Copyright (c) Thonda Taylor II 4 October 2011
 */

/**
 * <RegistrationBean> 
 * 		Class that holds my instance variables of type <String>.
 * 		Contains all getters and setters
 * 		Holds navigation to two different xhtml pages.
 * 		 
 */
public class RegistrationBean {


private String firstName="";
private String lastName="";
private String pNumberOne="";
private String pNumberTwo="";
private String pNumberThree="";
private String email="";
private String confirmEmail="";
private String password="";
private String confirmPassword="";
private String invalid="";
private Locale currentLocal;
//private Locale aContextLocale;


	public String getFirstName(){ return firstName; }
	public void setFirstName(String aFirstName){ firstName = aFirstName;}
	
	public String getLastName(){ return lastName; }
	public void setLastName(String aLastName){ lastName = aLastName; }
	
	public String getpNumberOne(){ return pNumberOne; }
	public void setpNumberOne(String aNumber){ pNumberOne = aNumber; }
	
	public String getEmail(){ return email; }
	public void setEmail(String anEmail){ email = anEmail; }
	
	public String getConfirmEmail(){ return confirmEmail; }
	public void setConfirmEmail(String sameEmail){ confirmEmail = sameEmail; }
	
	public String getPassword(){ return password; }
	public void setPassword(String aPassword){ password = aPassword; }
	
	public String getConfirmPassword(){ return confirmPassword; }
	public void setConfirmPassword(String samePassword){ confirmPassword = samePassword; }
	/**
	 * @return the invalid
	 */
	public String getInvalid() { return invalid; }
	/**
	 * @param aInvalid the invalid to set
	 */
	public void setInvalid(String aInvalid) { invalid = aInvalid; }
	/**
	 * @return the pNumber2
	 */
	public String getpNumberTwo() {
		return pNumberTwo;
	}
	/**
	 * @param aPNumber2 the pNumber2 to set
	 */
	public void setpNumberTwo(String aPNumber2) {
		pNumberTwo = aPNumber2;
	}
	/**
	 * @return the pNumber3
	 */
	public String getpNumberThree() {
		return pNumberThree;
	}
	/**
	 * @param aPNumber3 the pNumber3 to set
	 */
	public void setpNumberThree(String aPNumber3) {
		pNumberThree = aPNumber3;
	}

	/**
	 * @param Action method <hitSubmit> holds no arguments, creates a resource bundle instance of 
	 * 		  <labels> and concatenates the string <invalid> in order to dynamically prompt the user 
	 *        of their errors on the invalidRegistration.xhtml page
	 * @return validRegistration
	 * 		returns a <String> validRegistration that navigates it to the validRegistration.xhtml
	 * @return invalidRegistration
	 * 		returns a <String> invalidRegistration that navigates it to the invalidRegistration.xhtml
	 */
	public String hitSubmit(){
		invalid="";
		ExternalContext aContextLocale = FacesContext.getCurrentInstance().getExternalContext();
		currentLocal=((ServletRequest) aContextLocale.getRequest()).getLocale();
		ResourceBundle labels = ResourceBundle.getBundle("registration.registration", currentLocal);
		if(firstName!="" && lastName!="" && pNumberOne!="" && pNumberTwo!="" && pNumberThree!="" && email!="" && confirmEmail!="" &&
				password!="" && confirmPassword!="" && email.equals(confirmEmail) && password.equals(confirmPassword)) { 
			return "validRegistration";
		}
		if(firstName=="" || lastName=="" || pNumberOne=="" || email=="" || confirmEmail=="" ||
				password=="" || confirmPassword=="" || pNumberTwo=="" || pNumberThree=="" || !email.equals(confirmEmail) || !password.equals(confirmPassword)){
			if(firstName==""){
				invalid = invalid + labels.getString("emptyFirstName"); 
			}
			if(lastName==""){
				invalid = invalid + labels.getString("emptyLastName"); 
			}
			if(pNumberOne=="" || pNumberTwo=="" || pNumberThree==""){
				invalid = invalid + labels.getString("emptyNumber"); 
			}
			if(email=="" || confirmEmail==""){
				invalid = invalid + labels.getString("emptyEmail"); 
			}
			if(!email.equals(confirmEmail)){
				invalid = invalid + labels.getString("matchEmail"); 
			}
			if(password=="" || confirmPassword==""){
				invalid = invalid + labels.getString("emptyPassword"); 
			}
			if(!password.equals(confirmPassword)){
				invalid = invalid + labels.getString("matchPassword"); 
			}
			//return "invalidRegistration";
		}
		return "invalidRegistration";
	}
}
