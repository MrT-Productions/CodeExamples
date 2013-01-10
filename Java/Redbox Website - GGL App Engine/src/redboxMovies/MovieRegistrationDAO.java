/*
 *MovieRegistrationDAO.java 1.0 Nov 21, 2011 
 *
 *Copyright (c) 2011 Thonda D. Taylor II Inc.
 *Campus Box 7792, Elon University, Elon, NC 27244
 */
package redboxMovies;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.google.appengine.api.datastore.Text;
/**
 * @author ThondaT2
 *
 */
public class MovieRegistrationDAO extends Movies implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MovieRegistrationDAO(){
		//intentionally left blank
	}
	
	
	public void add(Movie aMovie){
		EntityManager em = null;
		try {
			em = EMF.get().createEntityManager();
			Movie newMovie = new Movie(
			aMovie.getSmallURL(),
			aMovie.getBigURL(),
			aMovie.getTitle(),
			aMovie.getNumberRating(),
			aMovie.getDescription(),
			aMovie.getGenres(),
			aMovie.getStaring(),
			aMovie.getDirectors(),
			aMovie.getStudio(),
			aMovie.getSubtitles(),
			aMovie.getFormat(),
			aMovie.getReleaseDate(),
			aMovie.getRunTime(),
			aMovie.getMovieRating()
			);
			em.persist(aMovie);
		} finally {
			em.close();
		}
	}
	
	public Movie add25Movies(){
		Movie twoFive = new Movie();
		for(int i = 0; i < 25; i++){
			add(twoFive);
		}
		return twoFive;
	}

 	
}
