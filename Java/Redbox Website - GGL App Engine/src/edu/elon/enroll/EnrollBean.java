/*
 *EnrollBean.java 1.0 Oct 23, 2011 
 *
 *Copyright (c) 2011 Thonda D. Taylor II Inc.
 *Campus Box 7792, Elon University, Elon, NC 27244
 */
package edu.elon.enroll;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * @author ThondaT2
 *
 */
public class EnrollBean {

	private String c1;
	private String c2;
	private String c3;
	private String c4;
	/**
	 * @return the c1
	 */
	public String getC1() {
		return c1;
	}
	/**
	 * @param aC1 the c1 to set
	 */
	public void setC1(String aC1) {
		c1 = aC1;
	}
	/**
	 * @return the c2
	 */
	public String getC2() {
		return c2;
	}
	/**
	 * @param aC2 the c2 to set
	 */
	public void setC2(String aC2) {
		c2 = aC2;
	}
	/**
	 * @return the c3
	 */
	public String getC3() {
		return c3;
	}
	/**
	 * @param aC3 the c3 to set
	 */
	public void setC3(String aC3) {
		c3 = aC3;
	}
	/**
	 * @return the c4
	 */
	public String getC4() {
		return c4;
	}
	/**
	 * @param aC4 the c4 to set
	 */
	public void setC4(String aC4) {
		c4 = aC4;
	}
	
	public String doLogic(){
		if(c1.startsWith("csc")){
			return("gotCSC");
		}else if(c2.startsWith("csc")){
			return("gotCSC");
		}else if(c3.startsWith("csc")){
			return("gotCSC");
		}
		return("gotCSC");
	}
	
	public String enroll(){
		FacesContext context = FacesContext.getCurrentInstance();
		if(!c1.startsWith("csc")){
			context.addMessage(null, new FacesMessage("At least one course must be a CS course"));
		}else if(!c2.startsWith("csc")){
			context.addMessage(null, new FacesMessage("At least one course must be a CS course"));
		}else if(!c3.startsWith("csc")){
			context.addMessage(null, new FacesMessage("At least one course must be a CS course"));
		}
		if(context.getMessageList().size() > 0){
			return(null);
		}
		else{
			doLogic();
			return("isGood");
		}
	}
}
