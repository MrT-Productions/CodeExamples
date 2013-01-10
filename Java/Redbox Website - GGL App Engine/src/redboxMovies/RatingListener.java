/*
 *RatingListener.java 1.0 Nov 9, 2011 
 *
 *Copyright (c) 2011 Thonda D. Taylor II Inc.
 *Campus Box 7792, Elon University, Elon, NC 27244
 */
package redboxMovies;

import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ValueChangeEvent;
import javax.faces.event.ValueChangeListener;
/**
 * @author ThondaT2
 *
 */
public class RatingListener implements ValueChangeListener {

	/* (non-Javadoc)
	 * @see javax.faces.event.ValueChangeListener#processValueChange(javax.faces.event.ValueChangeEvent)
	 */
	@Override
	public void processValueChange(ValueChangeEvent aArg0)
			throws AbortProcessingException {
		// TODO Auto-generated method stub
		// Get ratings from bean
		RedBoxBean ratingGenre = (RedBoxBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ratingGenre");
		ratingGenre.setRatingGenre(aArg0.getNewValue().toString());
		
	}

}
