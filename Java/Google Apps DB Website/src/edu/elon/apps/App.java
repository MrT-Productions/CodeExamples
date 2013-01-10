/**
 * @App.java		@Version 1.0 3/12/2012
 * 
 * Copyright (c) 2012 Thonda Taylor II Productions.
 * 3567 Campus Box, Elon, North Carolina, 38053 USA.
 * All rights reserved.
 * 
 * This software is the confidential and proprietary information
 * of Thonda Taylor II Productions.  All of the work is original 
 * work completed solely by Thonda Taylor II, with no assistance
 * from anyone.
 */ 
package edu.elon.apps;

/**
 * @author thondaTaylor
 * Creates an App object for the DB
 */
public class App {

	private String appCode;
	private String developersName;
	private String appTitle;
	private String appCatagory;
	private String dateUpdated;
	private String currentVersion;
	private String price;
	private String rating;
	private String appDescription;
	/**
	 * @param appCode
	 * @param developersName
	 * @param appTitle
	 * @param appCatagory
	 * @param dateUpdated
	 * @param currentVersion
	 * @param price
	 * @param rating
	 * @param appDescription
	 * Constructs an application for the DB
	 */
	public App(String appCode, String developersName, String appTitle,
			String appCatagory, String dateUpdated, String currentVersion,
			String price, String rating, String appDescription) {
		super();
		this.appCode = appCode;
		this.developersName = developersName;
		this.appTitle = appTitle;
		this.appCatagory = appCatagory;
		this.dateUpdated = dateUpdated;
		this.currentVersion = currentVersion;
		this.price = price;
		this.rating = rating;
		this.appDescription = appDescription;
	}
	/**
	 * No Argument Constructor
	 */
	public App(){
		
	}
	/**
	 * @return the appCode
	 */
	public String getAppCode() {
		return appCode;
	}
	/**
	 * @param appCode the appCode to set
	 */
	public void setAppCode(String appCode) {
		this.appCode = appCode;
	}
	/**
	 * @return the developersName
	 */
	public String getDevelopersName() {
		return developersName;
	}
	/**
	 * @param developersName the developersName to set
	 */
	public void setDevelopersName(String developersName) {
		this.developersName = developersName;
	}
	/**
	 * @return the appTitle
	 */
	public String getAppTitle() {
		return appTitle;
	}
	/**
	 * @param appTitle the appTitle to set
	 */
	public void setAppTitle(String appTitle) {
		this.appTitle = appTitle;
	}
	/**
	 * @return the appCatagory
	 */
	public String getAppCatagory() {
		return appCatagory;
	}
	/**
	 * @param appCatagory the appCatagory to set
	 */
	public void setAppCatagory(String appCatagory) {
		this.appCatagory = appCatagory;
	}
	/**
	 * @return the dateUpdated
	 */
	public String getDateUpdated() {
		return dateUpdated;
	}
	/**
	 * @param dateUpdated the dateUpdated to set
	 */
	public void setDateUpdated(String dateUpdated) {
		this.dateUpdated = dateUpdated;
	}
	/**
	 * @return the currentVersion
	 */
	public String getCurrentVersion() {
		return currentVersion;
	}
	/**
	 * @param currentVersion the currentVersion to set
	 */
	public void setCurrentVersion(String currentVersion) {
		this.currentVersion = currentVersion;
	}
	/**
	 * @return the price
	 */
	public String getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(String price) {
		this.price = price;
	}
	/**
	 * @return the rating
	 */
	public String getRating() {
		return rating;
	}
	/**
	 * @param rating the rating to set
	 */
	public void setRating(String rating) {
		this.rating = rating;
	}
	/**
	 * @return the appDescription
	 */
	public String getAppDescription() {
		return appDescription;
	}
	/**
	 * @param appDescription the appDescription to set
	 */
	public void setAppDescription(String appDescription) {
		this.appDescription = appDescription;
	}
	
}
