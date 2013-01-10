/*
 *RedBoxBean.java 1.0 Oct 26, 2011 
 *
 *Copyright (c) 2011 Thonda D. Taylor II Inc.
 *Campus Box 7792, Elon University, Elon, NC 27244
 */
/**
 * 
 */
package redbox;

//<!-- Copyright (c) Thonda Taylor 28 Oct 2011 -->
import java.io.Serializable;
import java.util.ResourceBundle;
import java.util.Locale;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIInput;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletRequest;

/**
 * @author ThondaT2
 * RedBoxBean is my Java bean that implements Serializable, because of the fact that it is a Session Scoped Bean.
 */

public class RedBoxBean implements Serializable {

	/**
	 * All of the variables that will get called and set from the JSF page into the bean
	 */
	private static final long serialVersionUID = 1L;
	private String firstName;
	private String fnColor;
	private String lastName;
	private String lnColor;
	private String email;
	private String eColor;
	private String password;
	private String pColor;
	private String confirmPass;
	private String cpColor;
	private String zipCode;
	private String zColor;
	private Locale currentLocal;

	/**
	 * @return the fnColor
	 */
	public String getFnColor() {
		if (firstName.trim().length() == 0) {
			fnColor = "red";
		}
		if (firstName.trim().length() != 0) {
			fnColor = "black";
		}
		
		return fnColor;
	}

	/**
	 * @param aFnColor
	 *            the fnColor to set
	 */
	public void setFnColor(String aFnColor) {
		fnColor = aFnColor;
	}

	/**
	 * @return the lnColor
	 */
	public String getLnColor() {
		if(lastName.trim().length() == 0){
			lnColor = "red";
	}
		else{
			lnColor = "black";
		}
		return lnColor;
	}

	/**
	 * @param aLnColor
	 *            the lnColor to set
	 */
	public void setLnColor(String aLnColor) {
		lnColor = aLnColor;
	}

	/**
	 * @return the eColor
	 */
	public String geteColor() {
		if(email.trim().length()==0){
			eColor ="red";
		}
		else{
			eColor ="black";
		}
		return eColor;
	}

	/**
	 * @param aEColor
	 *            the eColor to set
	 */
	public void seteColor(String aEColor) {
		eColor = aEColor;
	}

	/**
	 * @return the pColor
	 */
	public String getpColor() {
		if(password.trim().length() == 0){
			pColor="red";
		}
		else{
			pColor="black";
		}
		return pColor;
	}

	/**
	 * @param aPColor
	 *            the pColor to set
	 */
	public void setpColor(String aPColor) {
		pColor = aPColor;
	}

	/**
	 * @return the cpColor
	 */
	public String getCpColor() {
		if(confirmPass.trim().length() == 0){
			cpColor="red";
		}
		else{
			cpColor="black";
		}
		return cpColor;
	}

	/**
	 * @param aCpColor
	 *            the cpColor to set
	 */
	public void setCpColor(String aCpColor) {
		cpColor = aCpColor;
	}

	/**
	 * @return the zColor
	 */
	public String getzColor() {
		if(zipCode.trim().length() == 0){
			zColor="red";
		}
		else{
			zColor="black";
		}
		return zColor;
	}

	/**
	 * @param aZColor
	 *            the zColor to set
	 */
	public void setzColor(String aZColor) {
		zColor = aZColor;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param aFirstName
	 *            the firstName to set
	 */
	public void setFirstName(String aFirstName) {
		firstName = aFirstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param aLastName
	 *            the lastName to set
	 */
	public void setLastName(String aLastName) {
		lastName = aLastName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param aEmail
	 *            the email to set
	 */
	public void setEmail(String aEmail) {
		email = aEmail;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param aPassword
	 *            the password to set
	 */
	public void setPassword(String aPassword) {
		password = aPassword;
	}

	/**
	 * @return the confirmPass
	 */
	public String getConfirmPass() {
		return confirmPass;
	}

	/**
	 * @param aConfirmPass
	 *            the confirmPass to set
	 */
	public void setConfirmPass(String aConfirmPass) {
		confirmPass = aConfirmPass;
	}

	/**
	 * @return the zipCode
	 */
	public String getZipCode() {
		return zipCode;
	}

	/**
	 * @param aZipCode
	 *            the zipCode to set
	 */
	public void setZipCode(String aZipCode) {
		zipCode = aZipCode;
	}

	
	
	/**
	 * 
	 * @return
	 * 		Either the redbox <String> or the continue <String>
	 * 		The redbox string navigates the user back to the register page for data re-entry
	 * 		The continue string navigates the user to the next page after successful completion of each entry field and only after each one has passed the appropriate validation phase.
	 * The method only runs until the final check of password and confirm password is passed and both of them are exactly equal <Strings> or <input values>
	 * The facesContext allows for the switch between English and Spanish Locale's
	 */
	public String hitContinue() {
		ExternalContext aContextLocale =
			  FacesContext.getCurrentInstance().getExternalContext();
			  currentLocal=((ServletRequest) aContextLocale.getRequest()).getLocale(); 
			  ResourceBundle labels =  ResourceBundle.getBundle("redbox.redbox", currentLocal); 
			  FacesContext context = FacesContext.getCurrentInstance();
		
		while(!confirmPass.equals(password)){
			context.addMessage(null, new 
					FacesMessage(labels.getString("cpMessage"))); 
			return("redbox");
		}
		
		  
		 /* if(firstName.trim().length() == 0){ context.addMessage(null, new
		 * FacesMessage(labels.getString("firstNameMessage"))); }
		 * if(lastName.trim().length() == 0){ context.addMessage(null, new
		 * FacesMessage(labels.getString("lastNameMessage"))); }
		 * if(email.trim().length() == 0){ context.addMessage(null, new
		 * FacesMessage(labels.getString("emailMessage"))); }
		 * if(password.trim().length() == 0){ context.addMessage(null, new
		 * FacesMessage(labels.getString("passwordMessage"))); }
		 * if(confirmPass.trim().length() == 0 ||
		 * !confirmPass.equals(password)){ context.addMessage(null, new
		 * FacesMessage(labels.getString("cpMessage"))); }
		 * /*if(zipCode.trim().length() == 0){ context.addMessage(null, new
		 * FacesMessage(labels.getString("zcodeMessage"))); }
		  if(context.getMessageList().size() > 0){ return(null); }
		 */
		  
		return ("continue");
	}
}
