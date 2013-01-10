/*
 *Movies.java 1.0 Nov 1, 2011 
 *
 *Copyright (c) 2011 Thonda D. Taylor II Inc.
 *Campus Box 7792, Elon University, Elon, NC 27244
 */
package redboxMovies;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import javax.persistence.EntityManager;

import com.google.appengine.api.datastore.Text;
import com.sun.tools.javac.code.Attribute.Array;


/**
 * @author ThondaT2
 * This class holds Collections and Arrays of Movies and SixMovie at a time placeholders  
 */
@SuppressWarnings("unused")
public class Movies {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Creates the instance variable that I will utilize throughout the entire class
	 */
	private Movie[] movie;
	private SixMovies[] six;
	protected Movie selectedMovie;
	private int numberOfGroups;
	protected ArrayList<Movie> allTogether;
	protected ArrayList<Movie> whileSorting;
	protected String sorting = "Release Dates";
	protected String ratingSort="All Ratings"; 
	protected String genreSort="All";

	/**
	 * 
	 * @param movie
	 * Takes in an infinite amount of movie objects
	 */
	public Movies(Movie... movie) {
		this.movie = movie;
	}

	/**
	 * @return the movie
	 */
	public Movie[] getMovie() {
		return movie;
	}

	/**
	 * @param aMovie
	 *            the movie to set
	 */
	public void setMovie(Movie[] aMovie) {
		movie = aMovie;
	}

	
	/**
	 * @return the selectedMovie
	 */
	public Movie getSelectedMovie() {
		return selectedMovie;
	}

	/**
	 * @param aSelectedMovie the selectedMovie to set
	 */
	public void setSelectedMovie(Movie aSelectedMovie) {
		selectedMovie = aSelectedMovie;
	}

	/**
	 * @return the allTogether
	 */
	public ArrayList<Movie> getAllTogether() {
		return allTogether;
	}

	/**
	 * @param aAllTogether the allTogether to set
	 */
	public void setAllTogether(ArrayList<Movie> aAllTogether) {
		allTogether = aAllTogether;
	}

	/**
	 * @return the whileSorting
	 */
	public ArrayList<Movie> getWhileSorting() {
		return whileSorting;
	}

	/**
	 * @param aWhileSorting the whileSorting to set
	 */
	public void setWhileSorting(ArrayList<Movie> aWhileSorting) {
		whileSorting = aWhileSorting;
	}

	/**
	 * @return the sorting
	 */
	public String getSorting() {
		return sorting;
	}

	/**
	 * @param aSorting the sorting to set
	 */
	public void setSorting(String aSorting) {
		sorting = aSorting;
	}

	/**
	 * @return the ratingSort
	 */
	public String getRatingSort() {
		return ratingSort;
	}

	/**
	 * @param aRatingSort the ratingSort to set
	 */
	public void setRatingSort(String aRatingSort) {
		ratingSort = aRatingSort;
	}

	/**
	 * @return the genreSort
	 */
	public String getGenreSort() {
		return genreSort;
	}

	/**
	 * @param aGenreSort the genreSort to set
	 */
	public void setGenreSort(String aGenreSort) {
		genreSort = aGenreSort;
	}
	
	
	/*public void deleteFromDatabase(){
		MovieRegistrationDAO deleteMe = new MovieRegistrationDAO();
		deleteMe.delete();
	}
	
	public void resetDatabase(){
		MovieRegistrationDAO resetMe = new MovieRegistrationDAO();
		resetMe.reset();
	}*/

	/**
	 * This method sorts the rating and the genres, and does it by either Release Dates or Alphabetical
	 * @return 
	 * 
	 * @return six
	 * 		six represents an Array the holds groups of 6 movies at a time
	 */
	@SuppressWarnings("unchecked")
	public SixMovies[] getSixMovies() {
		MovieRegistrationDAO newMovies = new MovieRegistrationDAO();
		//allTogether = new ArrayList<Movie>(Arrays.asList(movie));
		newMovies.add25Movies();
		//newMovies.getMovies();
		/*allTogether = new ArrayList<Movie>(Arrays.asList(movie));
		//Initial Population Genre at All - Ratings on All Ratings
		if (genreSort.equals("All") && ratingSort.equals("All Ratings")) {
			whileSorting = new ArrayList<Movie>(allTogether);
			//Alphabetize whileSorting 
			if (sorting.equals("Alphabetical")) {
				//Arrays.sort(movie);
				Collections.sort(whileSorting);
			} 
			// Sort whileSorting by Release Dates
			if (sorting.equals("Release Dates")){
				SortTheReleaseDate sTD = new SortTheReleaseDate();
				//Arrays.sort(movie, sTD);
				Collections.sort(whileSorting, sTD);
			} //Hold Rating at All Ratings-Change Genre Buttons
		}else if (ratingSort.equals("All Ratings")) {
				whileSorting.clear();
				for (int i = 0; i < allTogether.size(); i++) {
					Movie newMovie = allTogether.get(i);
					String x = newMovie.getGenres();
					if (x.contains(genreSort)) {
						whileSorting.add(newMovie);
					}
				}
				//Alphabetize whileSorting 
				if (sorting.equals("Alphabetical")) {
					//Arrays.sort(movie);
					Collections.sort(whileSorting);
				} 
				// Sort whileSorting by Release Dates
				if (sorting.equals("Release Dates")){
					SortTheReleaseDate sTD = new SortTheReleaseDate();
					//Arrays.sort(movie, sTD);
					Collections.sort(whileSorting, sTD);
				}
			}//Genre Button on All - Set Rated Movie into the list
			else if (genreSort.equals("All") && ratingSort.equals("G")) {
					whileSorting.clear();
					for (int i = 0; i < allTogether.size(); i++) {
						Movie newMovie = allTogether.get(i);
						String x = newMovie.getMovieRating();
						if (x.equals(ratingSort)) {
							whileSorting.add(newMovie);
						}
					}
					//Alphabetize whileSorting 
					if (sorting.equals("Alphabetical")) {
						Collections.sort(whileSorting);
					} 
					// Sort whileSorting by Release Dates
					if (sorting.equals("Release Dates")){
						SortTheReleaseDate sTD = new SortTheReleaseDate();
						//Arrays.sort(movie, sTD);
						Collections.sort(whileSorting, sTD);
					}
				}
			//Genre Button NOT on All - Rating menu NOT on All Ratings
			else if(!genreSort.equals("All") && !ratingSort.equals("All Ratings")){
				whileSorting.clear();
				for (int i = 0; i < allTogether.size(); i++) {
					Movie newMovie = allTogether.get(i);
					String xs = newMovie.getGenres();
					String xr = newMovie.getMovieRating();
					if (xs.contains(genreSort) && xr.equals(ratingSort)) {
						whileSorting.add(newMovie);
					}
				}
				//Alphabetize whileSorting 
				if (sorting.equals("Alphabetical")) {
					//Arrays.sort(movie);
					Collections.sort(whileSorting);
				} 
				// Sort whileSorting by Release Dates
				if (sorting.equals("Release Dates")){
					SortTheReleaseDate sTD = new SortTheReleaseDate();
					//Arrays.sort(movie, sTD);
					Collections.sort(whileSorting, sTD);
				}
			}
		
		// If there is no remainder left divide that # by 6 and set that to
		// the number of groups
		int fullGroups=0;
		if (whileSorting.size() % 6 == 0) {
			numberOfGroups = (whileSorting.size() / 6);
			fullGroups = numberOfGroups;
		}else{
				numberOfGroups = (whileSorting.size() / 6)+1;
				fullGroups = numberOfGroups - 1;
			}
			six = new SixMovies[numberOfGroups];
			for (int i = 0; i < fullGroups; i++) {
				SixMovies get = new SixMovies();
				get.setMovie1(whileSorting.get(i * 6 + 0));
				get.setMovie2(whileSorting.get(i * 6 + 1));
				get.setMovie3(whileSorting.get(i * 6 + 2));
				get.setMovie4(whileSorting.get(i * 6 + 3));
				get.setMovie5(whileSorting.get(i * 6 + 4));
				get.setMovie6(whileSorting.get(i * 6 + 5));
				six[i] = get;
			}
			// if there is a remainder left take the length divide by 6 then add
			// an additional group
		
		if(fullGroups != numberOfGroups) {
			int remainder= whileSorting.size() % 6;
				SixMovies get = new SixMovies();
				if(remainder == 1){
					get.setMovie1(whileSorting.get(fullGroups * 6 + 0));
				}
				if(remainder == 2){
					get.setMovie1(whileSorting.get(fullGroups * 6 + 0));
					get.setMovie2(whileSorting.get(fullGroups * 6 + 1));
				}
				if(remainder == 3){
					get.setMovie1(whileSorting.get(fullGroups * 6 + 0));
					get.setMovie2(whileSorting.get(fullGroups * 6 + 1));
					get.setMovie3(whileSorting.get(fullGroups * 6 + 2));
				}
				if(remainder == 4){
					get.setMovie1(whileSorting.get(fullGroups * 6 + 0));
					get.setMovie2(whileSorting.get(fullGroups * 6 + 1));
					get.setMovie3(whileSorting.get(fullGroups * 6 + 2));
					get.setMovie4(whileSorting.get(fullGroups * 6 + 3));
				}
				if(remainder == 5){
					get.setMovie1(whileSorting.get(fullGroups * 6 + 0));
					get.setMovie2(whileSorting.get(fullGroups * 6 + 1));
					get.setMovie3(whileSorting.get(fullGroups * 6 + 2));
					get.setMovie4(whileSorting.get(fullGroups * 6 + 3));
					get.setMovie5(whileSorting.get(fullGroups * 6 + 4));
				}
				six[fullGroups] = get; 
		}
		return six;
	}

	/**
	 * 
	 * @param aGroupOfSix
	 */
	public void setSixMovies(SixMovies[] aGroupOfSix) {
		six = aGroupOfSix;
	}
	
	/**
	 * 
	 * @author ThondaT2
	 * This method implements the Comparator interface and compares date <Strings> to each other
	 */
	/*@SuppressWarnings("rawtypes")
	public class SortTheReleaseDate implements Comparator {

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
		 */
		/*@Override
		public int compare(Object aArg0, Object aArg1) {
			Movie a = (Movie) aArg0;
			Movie b = (Movie) aArg1;
			return a.getReleaseDate().compareTo(b.getReleaseDate());
		}

	}*/

}