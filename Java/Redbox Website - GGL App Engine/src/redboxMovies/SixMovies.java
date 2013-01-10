/*
 *sixMovies.java 1.0 Nov 4, 2011 
 *
 *Copyright (c) 2011 Thonda D. Taylor II Inc.
 *Campus Box 7792, Elon University, Elon, NC 27244
 */
package redboxMovies;

import java.util.ArrayList;

/**
 * @author ThondaT2
 * This Class holds 6 Movie Objects 
 */
@SuppressWarnings("unused")
public class SixMovies {

	/**
	 * These create the 6 different movies
	 */
	private Movie movie1;
	private Movie movie2;
	private Movie movie3;
	private Movie movie4;
	private Movie movie5;
	private Movie movie6;
	
	/**
	 * @return the movie1
	 */
	public Movie getMovie1() {
		return movie1;
	}
	
	/**
	 * @param aMovie1 the movie1 to set
	 */
	public void setMovie1(Movie aMovie1) {
		movie1 = aMovie1;
	}
	
	/**
	 * @return the movie2
	 */
	public Movie getMovie2() {
		return movie2;
	}

	/**
	 * @param aMovie2 the movie2 to set
	 */
	public void setMovie2(Movie aMovie2) {
		movie2 = aMovie2;
	}
	
	/**
	 * @return the movie3
	 */
	public Movie getMovie3() {
		return movie3;
	}

	/**
	 * @param aMovie3 the movie3 to set
	 */
	public void setMovie3(Movie aMovie3) {
		movie3 = aMovie3;
	}

	/**
	 * @return the movie4
	 */
	public Movie getMovie4() {
		return movie4;
	}

	/**
	 * @param aMovie4 the movie4 to set
	 */
	public void setMovie4(Movie aMovie4) {
		movie4 = aMovie4;
	}

	/**
	 * @return the movie5
	 */
	public Movie getMovie5() {
		return movie5;
	}

	/**
	 * @param aMovie5 the movie5 to set
	 */
	public void setMovie5(Movie aMovie5) {
		movie5 = aMovie5;
	}

	/**
	 * @return the movie6
	 */
	public Movie getMovie6() {
		return movie6;
	}

	/**
	 * @param aMovie6 the movie6 to set
	 */
	public void setMovie6(Movie aMovie6) {
		movie6 = aMovie6;
	}



	/**
	 * No argument SixMovies class constructor that sets each Movie variable to a Movie Object 
	 */
	public SixMovies(){
	  movie1 = new Movie();
	  movie2 = new Movie();
	  movie3 = new Movie();
	  movie4 = new Movie();
	  movie5 = new Movie();
	  movie6 = new Movie();
	}



	/**
	 * @param aMovie1
	 * @param aMovie2
	 * @param aMovie3
	 * @param aMovie4
	 * @param aMovie5
	 * @param aMovie6
	 * 
	 * This method constructs 6/six Movie Objects, and sets its input values to the instance variables at the top of my class
	 */
	public SixMovies(Movie aMovie1, Movie aMovie2, Movie aMovie3,
			Movie aMovie4, Movie aMovie5, Movie aMovie6) {
		super();
		movie1 = aMovie1;
		movie2 = aMovie2;
		movie3 = aMovie3;
		movie4 = aMovie4;
		movie5 = aMovie5;
		movie6 = aMovie6;
	}
	
	
	
}
