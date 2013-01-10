/*
 *Movie.java 1.0 Nov 1, 2011 
 *
 *Copyright (c) 2011 Thonda D. Taylor II Inc.
 *Campus Box 7792, Elon University, Elon, NC 27244
 */
package redboxMovies;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Text;

/**
 * @author ThondaT2
 * 
 * Movie is my Java object that implements a Comparable interface that takes in a Movie object as its parameter
 */
@Entity
public class Movie implements Serializable {
	/**
	 * Represents all of the instance variables throughout the entire class
	 * These variables make up the description of what a Movie object is / holds
	 */
	@Basic
	private String smallURL="";
	@Basic
	private String bigURL="";
	@Basic
	private String title="";
	@Basic
	private String numberRating="";
	@Basic
	private Text description= new Text("");
	@Basic
	private String genres="";
	@Basic
	private String staring="";
	@Basic
	private String directors="";
	@Basic
	private String studio="";
	@Basic
	private String subtitles="";
	@Basic
	private String format="";
	@Basic
	private String releaseDate="";
	@Basic
	private String runTime="";
	@Basic
	private String movieRating="";
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Key id;
	
	/**
	 * This is my no argument constructor that simply initializes all of my data variables to an empty <String>
	 */
	public Movie(){
		smallURL="";
		bigURL="";
		title="";
		numberRating="";
		description=new Text("");
		genres="";
		staring="";
		directors="";
	    studio="";
		subtitles="";
	    format="";
	}
	
	/**
	 * @param aSmallURL
	 * @param aBigURL
	 * @param aTitle
	 * @param aNumberRating
	 * @param aDescription
	 * @param aGenres
	 * @param aStaring
	 * @param aDirectors
	 * @param aStudio
	 * @param aSubtitles
	 * @param aFormat
	 * @param aReleaseDate
	 * @param aRunTime
	 * @param aMovieRating
	 * 
	 * This method constructs a single Movie Object, and sets its input values to the instance variables at the top of my class
	 */
	public Movie(String aSmallURL, String aBigURL, String aTitle,
			String aNumberRating, Text aDescription, String aGenres,
			String aStaring, String aDirectors, String aStudio,
			String aSubtitles, String aFormat, String aReleaseDate,
			String aRunTime, String aMovieRating) {
		super();
		smallURL = aSmallURL;
		bigURL = aBigURL;
		title = aTitle;
		numberRating = aNumberRating;
		description = aDescription;
		genres = aGenres;
		staring = aStaring;
		directors = aDirectors;
		studio = aStudio;
		subtitles = aSubtitles;
		format = aFormat;
		releaseDate = aReleaseDate;
		runTime = aRunTime;
		movieRating = aMovieRating;
		EntityManager em = null;
		try {
			em = EMF.get().createEntityManager();
			em.persist(this);
		} finally {
			em.close();
		}
	}

	/**
	 * @return the smallURL
	 */
	public String getSmallURL() {
		return smallURL;
	}
	/**
	 * @param aSmallURL the smallURL to set
	 */
	public void setSmallURL(String aSmallURL) {
		smallURL = aSmallURL;
	}
	/**
	 * @return the bigURL
	 */
	public String getBigURL() {
		return bigURL;
	}
	/**
	 * @param aBigURL the bigURL to set
	 */
	public void setBigURL(String aBigURL) {
		bigURL = aBigURL;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param aTitle the title to set
	 */
	public void setTitle(String aTitle) {
		title = aTitle;
	}
	/**
	 * @return the numberRating
	 */
	public String getNumberRating() {
		return numberRating;
	}
	/**
	 * @param aNumberRating the numberRating to set
	 */
	public void setNumberRating(String aNumberRating) {
		numberRating = aNumberRating;
	}
	/**
	 * @return the description
	 */
	public Text getDescription() {
		return description;
	}
	/**
	 * @param aDescription the description to set
	 */
	public void setDescription(Text aDescription) {
		description = aDescription;
	}
	/**
	 * @return the genres
	 */
	public String getGenres() {
		return genres;
	}
	/**
	 * @param aGenres the genres to set
	 */
	public void setGenres(String aGenres) {
		genres = aGenres;
	}
	/**
	 * @return the staring
	 */
	public String getStaring() {
		return staring;
	}
	/**
	 * @param aStaring the staring to set
	 */
	public void setStaring(String aStaring) {
		staring = aStaring;
	}
	/**
	 * @return the directors
	 */
	public String getDirectors() {
		return directors;
	}
	/**
	 * @param aDirectors the directors to set
	 */
	public void setDirectors(String aDirectors) {
		directors = aDirectors;
	}
	/**
	 * @return the studio
	 */
	public String getStudio() {
		return studio;
	}
	/**
	 * @param aStudio the studio to set
	 */
	public void setStudio(String aStudio) {
		studio = aStudio;
	}
	/**
	 * @return the subtitles
	 */
	public String getSubtitles() {
		return subtitles;
	}
	/**
	 * @param aSubtitles the subtitles to set
	 */
	public void setSubtitles(String aSubtitles) {
		subtitles = aSubtitles;
	}
	/**
	 * @return the format
	 */
	public String getFormat() {
		return format;
	}
	/**
	 * @param aFormat the format to set
	 */
	public void setFormat(String aFormat) {
		format = aFormat;
	}
	/**
	 * @return the releaseDate
	 */
	public String getReleaseDate() {
		return releaseDate;
	}
	/**
	 * @param aReleaseDate the releaseDate to set
	 */
	public void setReleaseDate(String aReleaseDate) {
		releaseDate = aReleaseDate;
	}
	/**
	 * @return the runTime
	 */
	public String getRunTime() {
		return runTime;
	}
	/**
	 * @param aRunTime the runTime to set
	 */
	public void setRunTime(String aRunTime) {
		runTime = aRunTime;
	}
	/**
	 * @return the movieRating
	 */
	public String getMovieRating() {
		return movieRating;
	}
	/**
	 * @param aMovieRating the movieRating to set
	 */
	public void setMovieRating(String aMovieRating) {
		movieRating = aMovieRating;
	}
	/**
	 * @return the id
	 */
	public Key getId() {
		return id;
	}
	/**
	 * @param aId the id to set
	 */
	public void setId(Key aId) {
		id = aId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 
	@Override
	public int compareTo(Movie aO) {
		// TODO Auto-generated method stub
		Movie x= (Movie) aO;
		return title.compareTo(x.title);
	}*/
	
	
	
	
	
	
}
