/*
 *OntrackBean.java 1.0 Oct 13, 2011 
 *
 *Copyright (c) 2011 Thonda D. Taylor II Inc.
 *Campus Box 7792, Elon University, Elon, NC 27244
 */
package edu.elon.ontrack;

import javax.faces.model.SelectItem;
/**
 * @author ThondaT2
 * @version final
 * Copyright (c) Thonda Taylor II 14 October 2011
 */
public class OntrackBean {

private String term="";
private String startingOADate="";
private String endingBDate="";
private String sMA="";
private String sEB="";
private String subjects="";
private String sub1="";
private String sub2="";
private String sub3="";
private String sub4="";


/**
 * @return the sMA
 */
public String getsMA() {
	return sMA;
}
/**
 * @param aSMA the sMA to set
 */
public void setsMA(String aSMA) {
	sMA = aSMA;
}
/**
 * @return the sEB
 */
public String getsEB() {
	return sEB;
}
/**
 * @param aSEB the sEB to set
 */
public void setsEB(String aSEB) {
	sEB = aSEB;
}
/**
 * @return the sub2
 */
public String getSub2() {
	return sub2;
}
/**
 * @param aSub2 the sub2 to set
 */
public void setSub2(String aSub2) {
	sub2 = aSub2;
}
/**
 * @return the sub3
 */
public String getSub3() {
	return sub3;
}
/**
 * @param aSub3 the sub3 to set
 */
public void setSub3(String aSub3) {
	sub3 = aSub3;
}
/**
 * @return the sub4
 */
public String getSub4() {
	return sub4;
}
/**
 * @param aSub4 the sub4 to set
 */
public void setSub4(String aSub4) {
	sub4 = aSub4;
}
/**
 * @return the subjects
 */
public String getSubjects() {
	return subjects;
}
/**
 * @param aSub1 the sub1 to set
 */
public void setSub1(String aSub1) {
	sub1 = aSub1;
}
/**
 * @return the subjects
 */
public String getSub1() {
	return sub1;
}
/**
 * @param aSubjects the subjects to set
 */
public void setSubjects(String aSub1) {
	sub1 = aSub1;
}

private String sectionsMAfter="";
private String sectionsEBefore="";
/**
 * @return the term
 */
public String getTerm() {
	return term;
}
/**
 * @param aTerm the term to set
 */
public void setTerm(String aTerm) {
	term = aTerm;
}
/**
 * @return the startingOADate
 */
public String getStartingOADate() {
	return startingOADate;
}
/**
 * @param aStartingOADate the startingOADate to set
 */
public void setStartingOADate(String aStartingOADate) {
	startingOADate = aStartingOADate;
}
/**
 * @return the endingBDate
 */
public String getEndingBDate() {
	return endingBDate;
}
/**
 * @param aEndingBDate the endingBDate to set
 */
public void setEndingBDate(String aEndingBDate) {
	endingBDate = aEndingBDate;
}
/**
 * @return the sectionsMAfter
 */
public String getSectionsMAfter() {
	return sectionsMAfter;
}
/**
 * @param aSectionsMAfter the sectionsMAfter to set
 */
public void setSectionsMAfter(String aSectionsMAfter) {
	sectionsMAfter = aSectionsMAfter;
}
/**
 * @return the sectionsEBefore
 */
public String getSectionsEBefore() {
	return sectionsEBefore;
}
/**
 * @param aSectionsEBefore the sectionsEBefore to set
 */
public void setSectionsEBefore(String aSectionsEBefore) {
	sectionsEBefore = aSectionsEBefore;
}
public SelectItem[] getTerms(){ return terms; }
private static SelectItem[] terms = {
	new SelectItem(""),
	new SelectItem("Fall 2011"),
	new SelectItem("Winter 2012"),
	new SelectItem("Spring 2012"),
};

public SelectItem[] getSubjectItems(){ return subjectItems; }
private static SelectItem[] subjectItems = {
	new SelectItem(""),
	new SelectItem("Biology"),
	new SelectItem("Chemistry"),
	new SelectItem("Computer Science"),
	new SelectItem("Computer Information Systems"),
	new SelectItem("German"),
	new SelectItem("Mathmatics"),
};

public SelectItem[] getCourses(){ return courses; }
private static SelectItem[] courses = {
	new SelectItem(""),
	new SelectItem("First Year"),
	new SelectItem("Second Year"),
	new SelectItem("Pseudo Advanced"),
	new SelectItem("Third Year"),
	new SelectItem("Fourth Year"),
};

public SelectItem[] getTimes(){ return times; }
private static SelectItem[] times = {
    new SelectItem(""),
	new SelectItem("5am"),
	new SelectItem("6am"),
	new SelectItem("7am"),
	new SelectItem("8am"),
	new SelectItem("9am"),
	new SelectItem("10am"),
	new SelectItem("11am"),
	new SelectItem("12pm"),
	new SelectItem("1pm"),
	new SelectItem("2pm"),
	new SelectItem("3pm"),
	new SelectItem("4pm"),
	new SelectItem("5pm"),
	new SelectItem("6pm"),
	new SelectItem("7pm"),
	new SelectItem("8pm"),
	new SelectItem("9pm"),
	new SelectItem("10pm"),
};

public String hitSubmit(){
	
	if(sub1.isEmpty()){
		sub1 = "no selection";
	}
	if(sub2.isEmpty()){
		sub2 = "no selection";
	}
	if(sub3.isEmpty()){
		sub3 = "no selection";
	}
	if(sub4.isEmpty()){
		sub4 = "no selection";
	}
	subjects= (sub1 +", " + sub2 + ", " + sub3 + ", "+ sub4);
	return "ontrackSelection";
}

}
