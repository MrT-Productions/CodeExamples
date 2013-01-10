/*
 *AjaxBean.java 1.0 Oct 20, 2011 
 *
 *Copyright (c) 2011 Thonda D. Taylor II Inc.
 *Campus Box 7792, Elon University, Elon, NC 27244
 */
package ajax;

/**
 * @author ThondaT2
 *
 */
public class AjaxBean {

	private double total=0.00;
	private double ipadPrice=499;
	private double ipadD=0.0;
	private boolean ipadCheck;
	private double iphonePrice=99;
	private double iphoneD=0.0;
	/**
	 * @return the ipadD
	 */
	public double getIpadD() {
		return ipadD;
	}
	/**
	 * @param aIpadD the ipadD to set
	 */
	public void setIpadD(double aIpadD) {
		ipadD = aIpadD;
	}
	/**
	 * @return the iphoneD
	 */
	public double getIphoneD() {
		return iphoneD;
	}
	/**
	 * @param aIphoneD the iphoneD to set
	 */
	public void setIphoneD(double aIphoneD) {
		iphoneD = aIphoneD;
	}

	private boolean iphoneCheck;
	/**
	 * @return the ipadCheck
	 */
	public boolean isIpadCheck() {
		return ipadCheck;
	}
	/**
	 * @param aIpadCheck the ipadCheck to set
	 */
	public void setIpadCheck(boolean aIpadCheck) {
		ipadCheck = aIpadCheck;
	}
	/**
	 * @return the iphoneCheck
	 */
	public boolean isIphoneCheck() {
		return iphoneCheck;
	}
	/**
	 * @param aIphoneCheck the iphoneCheck to set
	 */
	public void setIphoneCheck(boolean aIphoneCheck) {
		iphoneCheck = aIphoneCheck;
	}
	/**
	 * @return the total
	 */
	public double getTotal() {
		total = 0.00;
		if(ipadCheck==true){
			addIpad();
		}
		if(iphoneCheck==true){
			addIphone();
		}
		if(ipadCheck==true && iphoneCheck==true){
			addBoth();
		}
		return total;
	}
	/**
	 * @param aTotal the total to set
	 */
	public void setTotal(double aTotal) {
		total = aTotal;
	}
	/**
	 * @return the ipadPrice
	 */
	public double getIpadPrice() {
		return ipadPrice;
	}
	/**
	 * @param aIpadPrice the ipadPrice to set
	 */
	public void setIpadPrice(double aIpadPrice) {
		ipadPrice = aIpadPrice;
	}
	/**
	 * @return the iphonePrice
	 */
	public double getIphonePrice() {
		return iphonePrice;
	}
	/**
	 * @param aIphonePrice the iphonePrice to set
	 */
	public void setIphonePrice(double aIphonePrice) {
		iphonePrice = aIphonePrice;
	}
	
	public double addIpad(){
		total = ((ipadPrice) - (ipadD/100 * ipadPrice)); 
		return total;
	}
	
	public double addIphone(){
		total = ((iphonePrice) - (iphoneD/100 * iphonePrice));
		return total;
	}
	
	public double addBoth(){
		total = (((ipadPrice) - (ipadD/100 * ipadPrice)) + ((iphonePrice) - (iphoneD/100 * iphonePrice)));
		return total;
	}
	
}
