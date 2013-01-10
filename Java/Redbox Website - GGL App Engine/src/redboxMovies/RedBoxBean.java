/*
 *RedBoxBean.java 1.0 Oct 31, 2011 
 *
 *Copyright (c) 2011 Thonda D. Taylor II Inc.
 *Campus Box 7792, Elon University, Elon, NC 27244
 */
package redboxMovies;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
//import redboxMovies.RedBoxBean.SortTheReleaseDate;
import org.apache.tools.ant.types.resources.Sort;

import com.google.appengine.api.datastore.Text;

import javax.faces.model.SelectItem;
import javax.persistence.Entity;
import javax.persistence.EntityManager;

/**
 * @author ThondaT2 RedBoxBean is my Java bean that implements Serializable,
 *         because this is a Session Scoped Bean. This class extends Movies.java
 *         which holds in it the Lists of all the Movie objects given to this
 *         Bean.
 * 
 */
@SuppressWarnings("unused")
public class RedBoxBean extends Movies implements Serializable {
	/**
	 * These variables help keep track of current CSS properties that are
	 * relayed to my CSS file in my resource bundle Keeps track of
	 * sorter/sorting methods, and their properties
	 */
	private static final long serialVersionUID = 1L;
	private String genre = "";
	private String ratingGenre = "";
	private Movie movieInfo;
	private String buttonClick = "";
	private String allClick = "clickColor";
	private String actionClick = "nodec";
	private String comedyClick = "nodec";
	private String dramaClick = "nodec";
	private String familyClick = "nodec";
	private String horrorClick = "nodec";

	/**
	 * No argument constructor of my Bean that holds all of the Movie Objects
	 * that are going to be associated with from certain properties in my
	 * redbox.xhtml and redboxSelection.xhtml files As of now holds 24 Movies
	 * with 6 per row If you were to comment out the 25th Movie it would hold
	 * all 25 Movies, HOWEVER only on a 5x5 basis
	 */
	public RedBoxBean() {
		super(
				new Movie(
						"http://goo.gl/AHpbf",
						"http://goo.gl/HF3ku",
						"Fast Five",
						"4.5",
						new Text(
								"In this installment, former cop Brian O'Conner partners with ex-con Dom Toretto on "
										+ "the opposite side of the law. Since Brian and Mia Toretto broke Dom out of custody, "
										+ "they've blown across many borders to elude authorities. Now backed into a corner in Rio "
										+ "de Janeiro, they must pull one last job in order to gain their freedom. As they assemble "
										+ "their elite team of top racers, the unlikely allies know their only shot of getting out for good "
										+ "means confronting the corrupt businessman who wants them dead. But he's not the only one on their tail. "
										+ "Hard-nosed federal agent Luke Hobbs never misses his target. When he is assigned to track down Dom and Brian,"
										+ " he and his strike team launch an all-out assault to capture them. But as his men tear through Brazil, Hobbs learns"
										+ " he can't separate the good guys from the bad. Now, he must rely on his instincts to corner his prey before someone else runs them down first."),
						"Action, Adventure",
						"Vin Diesel, Paul Walker, Jordana Brewster, Tyrese Gibson, Ludacris ",
						"Justin Lin", "Universal", "English French Spanish",
						"Widescreen", "2011", "2:11", "PG-13"),
				new Movie(
						"http://goo.gl/RkepV",
						"http://goo.gl/FxHfE",
						"Transformers: Dark of the Moon",
						"3.5",
						new Text(
								"The war on Cybertron between the Autobots and Decepticons appears lost. The leader of "
										+ "the Autobots, Sentinel Prime, attempts to launch the Ark from their planet, with technology"
										+ " that could have saved his kind. It gets attacked and crashes on Earth's moon in 1961, when"
										+ " President John F. Kennedy makes his famous promise to the nation to put a man on the moon. "
										+ "The 1969 NASA moon landing is actually an investigation of the wrecked spacecraft. As Sam Witwicky "
										+ "goes into adulthood and tries to move on from Mikaela, the Autobots learn of a Cybertronian spacecraft "
										+ "on the Moon. They race against the Decepticons to be first to find it and learn its secrets."),

						"Action, Adventure, Sci-Fi & Fantasy",
						"Shia LaBeouf, Rosie Huntington-Whiteley, Josh Duhamel, John Turturro, Tyrese Gibson ",
						"Michael Bay", "Paramount", "English French Spanish",
						"Widescreen", "2011", "2:34", "PG-13"),
				new Movie(
						"http://goo.gl/YH9uP",
						"http://goo.gl/VwxET",
						"Anchorman",
						"4.0",
						new Text(
								"Will Ferrell is Ron Burgundy, a top-rated 1970's San Diego anchorman who believes woman"
										+ " have a place in the newsroom - as long as they stick to covering fashion shows or late-breaking cooking news. So when Ron is told he'll be working with a bright"
										+ " young newswoman who's beautiful, ambitious and smart enough to be more than eye candy, it's not just a clash of two TV people with really great hair"
										+ " - it's war!"),
						"Comedy, redbox Replay",
						"Christina Applegate, Paul Rudd, Will Ferrell",
						"Adam McKay", "Paramount", "Spanish", "Widescreen",
						"2004", "01:31", "PG-13"),
				new Movie(
						"http://goo.gl/TpsqX",
						"http://goo.gl/QjPjr",
						"Brides Maids",
						"3.0",
						new Text(
								"Thirtysomething"
										+ " Annie finds her life turned completely upside down when she takes on the maid of honor role"
										+ " in her best friend Lillian's wedding. In way over her head but determined to succeed, Annie leads"
										+ " a hodgepodge of bridesmaids on a wild ride down the road to the big event."),
						"Comedy",
						"Kristen Wiig, "
								+ "Maya Rudolph, Rose Byrne, Wendi McLendon-Covey, Ellie Kemper",
						"Paul Feig", "Universal", "English French Spanish",
						"Widescreen", "2011", "2:04", "R"),
				new Movie(
						"http://goo.gl/fDihO",
						"http://goo.gl/p5hsy",
						"Cars 2",
						"4.0",
						new Text(
								"Star race car Lightning McQueen and the incomparable tow truck Mater take"
										+ " their friendship to exciting new places when they head overseas to compete in the first-ever World Grand Prix to determine the world's "
										+ "fastest car. But the road to the championship is filled with plenty of potholes, detours and surprises when Mater gets caught up in an "
										+ "intriguing adventure of his own: international espionage. Mater finds himself torn between assisting Lightning McQueen in the high-profile "
										+ "race and towing the line in a top-secret mission orchestrated by master British super spy Finn McMissile and the stunning spy-in-training Holley"
										+ " Shiftwell. Mater's action-packed journey leads him on an explosive chase through the streets of Japan and Europe, trailed by his friends and watched"
										+ " by the whole world."),
						"Family, Kids, Animation",
						"Larry the Cable Guy, Owen Wilson, Michael Caine, Emily Mortimer, Eddie Izzard ",
						"John Lasseter", "Disney", "English Spanish",
						"Widescreen", "2011", "2:00", "G"),
				new Movie(
						"http://goo.gl/DgqO6",
						"http://goo.gl/Z7BF0",
						"Boy Toy",
						"2.5",
						new Text(
								"An unsuccessful underwear model stumbles upon a new profession as a male"
										+ " escort. While experiencing success, he finds himself in a predicament that will change everything."),
						"Comedy",
						"John White, Mircea Monroe, Simon Rex, Morgan Fairchild, Kaylen Davidson ",
						"Christie" + " Will", "Lions Gate", "English Spanish",
						"Widescreen", "2011", "1:31", "R"),
				new Movie(
						"http://goo.gl/pKn19",
						"http://goo.gl/ho7hw",
						"Captain America: The First Avenger",
						"4.0",
						new Text(
								"Horrified by newsreel footage of the Nazis in"
										+ " Europe, Steve Rogers is inspired to enlist in the army. Because of his frailty and sickness, Rogers is rejected but later offered the "
										+ "opportunity to take part in a special experiment called Operation: Rebirth. After weeks of tests, Rogers is administered the Super-Solider"
										+ " Serum and bombarded by vita-rays, awakening from the treatment as Captain America. Armed with his indestructible shield and battle savvy, "
										+ "Captain America embarks on a war against evil."),
						"Action, Adventure",
						"Chris Evans, Hayley Atwell, Sebastian Stan, Tommy Lee Jones, Hugo Weaving",
						"Joe" + " Johnston", "Paramount",
						"English French Spanish", "Widescreen", "2011", "2:03",
						"PG-13"),
				new Movie(
						"http://goo.gl/yhjGm",
						"http://goo.gl/zvmmo",
						"Winnie the Pooh (2011)",
						"4.0",
						new Text(
								"In this original movie, Winnie the Pooh, the beloved bear, "
										+ "and his silly but steadfast friends are reunited for a new adventure. When sad, old Eeyore loses his tail, Owl sends the whole gang - Pooh, "
										+ "Tigger, Rabbit, Piglet, Kanga, and Roo - on a wild journey to help Eeyore and save Christopher Robin from the mysterious Backson."),
						"Family, Kids," + " Animation",
						"John Cleese, James Cummings, Bud Luckey, Craig Ferguson, Jack Boulter ",
						"Don Hall", "Disney", "English French Spanish",
						"Widescreen", "2011", "1:03", "G"),
				new Movie(
						"http://goo.gl/s997n",
						"http://goo.gl/DZ6Sp",
						"Zookeeper",
						"3.5",
						new Text(
								"The animals at the Franklin Park Zoo love their kindhearted caretaker, Griffin Keyes. "
										+ "Finding himself more comfortable with a lion than a lady, Griffin decides the only way to get a girl in his life is to leave the zoo and find a more glamorous"
										+ " job. The animals, in a panic, decide to break their time-honored code of silence and reveal their biggest secret: they can talk! To keep Griffin from leaving,"
										+ " they decide to teach him the rules of courtship - animal style."),
						"Comedy, Family", "", "Frank Coraci", "Sony",
						"English French Spanish", "Widescreen", "2011", "1:42",
						"PG"),
				new Movie(
						"http://goo.gl/WnCPU",
						"http://goo.gl/ebMPW",
						"Hisss",
						"1.5",
						new Text(
								"Based on an Indian myth, a snake woman seeks revenge after her mate is captured in the jungle by an American hunter with evil intentions."),
						"Horror",
						"Mallika Sherawat, Irrfan Khan, Jeff Douchette, Divya Dutta, Raman Trikha",
						"Jennifer Lynch", "Viva", "English", "Fullscreen",
						"2010", "1:38", "NR"),
				new Movie(
						"http://goo.gl/EehNL",
						"http://goo.gl/avEFE",
						"X-Men: First Class",
						"4.0",
						new Text(
								"The beginning of the X-Men saga - and a secret history of the Cold War and our world at the brink of nuclear Armageddon. As the first class discovers, harnesses, and comes to terms with their formidable powers, alliances are formed that will shape the eternal war between the heroes and villains of the X-Men universe. The film is set in the 1960s - the dawn of the Space Age, and a time filled with the hope of JFK's Camelot. But it was also the height of the Cold War, when escalating tensions between the U.S. and the Soviet Union threatened the entire planet - and when the world discovered the existence of mutants."),
						"Action, Adeventure",
						"James McAvoy, Michael Fassbender, Rose Byrne, Jennifer Lawrence, January Jones",
						"Matthew Vaughn", "Fox", "English Spanish",
						"Widescreen", "2011", "2:11", "PG-13"),
				new Movie(
						"http://goo.gl/W2dbe",
						"http://goo.gl/9Awl1",
						"Scream 4",
						"3.0",
						new Text(
								"Sidney Prescott, now the author of a self-help book, returns home to Woodsboro on the last stop of her book tour. There she reconnects with Sheriff Dewey and Gale Weathers, who are now married, as well as her cousin Jill and her Aunt Kate. Unfortunately, Sidney's appearance also brings about the return of Ghostface, putting Sidney, Gale, and Dewey, along with Jill, her friends, and the whole town of Woodsboro in danger."),
						"Action, Horror", "", "Wes Craven", "Anchor Bay",
						"English Spanish", "Widescreen", "2011", "1:51", "R"),
				new Movie(
						"http://goo.gl/9Sktc",
						"http://goo.gl/dZOAz",
						"Marry Me",
						"3.5",
						new Text(
								"Rae Ann Carter always wanted the fairytale where she meets a prince, falls in love and gets married, but feared that dream would never come true. Suddenly, Rae goes from having no man in her life to having three - charming Luke, passionate Adam, and sophisticated Harry - all in love with Rae and asking to marry her."),
						"Comedy, Romance",
						"Lucy Liu, Steven Pasquale, Bobby Cannavale, Enrique Murciano, Annie Potts",
						"James Hayman", "Sony", "English French", "Widescreen",
						"2010", "2:49", "NR"),
				new Movie(
						"http://goo.gl/6oYyJ",
						"http://goo.gl/EpMl3",
						"Thor",
						"4.0",
						new Text("Thor, a powerful but arrogant warrior, is sent to Earth as punishment for reigniting a reckless war. But after a dangerous villain from his world sends the darkest forces of Asgard to invade Earth, the hammer-wielding Thor must learn what it takes to be a true hero in order to save mankind."),
						"Action, Adventure",
						"Chris Hemsworth, Natalie Portman, Tom Hiddleston, Anthony Hopkins, Stellan Skarsgård ",
						"Kenneth Branagh", "Paramount",
						"English French Spanish", "Widescreen", "2011", "1:54",
						"PG-13"),
				new Movie(
						"http://goo.gl/JBJzK",
						"http://goo.gl/ulTnb",
						"Four Brothers",
						"4.0",
						new Text("A gritty, urban tale about four adopted brothers from delinquent backgrounds, bound together by their love of the mom who adopted and raised them.  After she is brutally murdered, the brothers reunite to avenge her death."),
						"Action, redbox Replay",
						"Garrett Hedlund, Mark Wahlberg, Tyrese Gibson",
						"John Singleton", "Paramount", "Spanish", "Widescreen",
						"2005", "01:48", "R"),
				new Movie(
						"http://goo.gl/6jKCR",
						"http://goo.gl/dKSne",
						"Paul",
						"3.5",
						new Text("For the past 60 years, an alien named Paul has been hanging out at a top-secret military base. The space-traveling smart aleck decides to escape the compound and hop on the first vehicle out of town -- a rented RV containing Earthlings Graeme Willy and Clive Collings. Chased by federal agents and the fanatical father of a young woman that they accidentally kidnap, Graeme and Clive hatch a fumbling escape plan to return Paul to his mother ship. And as two nerds struggle to help, one little green man might just take his fellow outcasts from misfits to intergalactic heroes."),
						"Comedy, Sci-Fi & Fantasy",
						"Simon Pegg, Nick Frost, Jason Bateman, Kristen Wiig, Bill Hader",
						"Greg Mottola", "Universal", "English French Spanish",
						"Widescreen", "2011", "1:44", "R"),
				new Movie(
						"http://goo.gl/Y5FhY",
						"http://goo.gl/JCEGd",
						"Rio",
						"4.5",
						new Text("Blu is a domesticated Macaw who never learned to fly, and enjoys a comfortable life with his owner and best friend Linda in the small town of Moose Lake, Minnesota. Blu and Linda think he's the last of his kind, but when they learn about another macaw who lives in Rio de Janeiro, they head to the faraway and exotic land to find Jewel, Blu's female counterpart. Not long after they arrive, Blu and Jewel are kidnapped by a group of bungling animal smugglers. Blu escapes, aided by the street smart Jewel and a group of wisecracking and smooth-talking city birds. Now, with his new friends by his side, Blu will have to find the courage to learn to fly, thwart the kidnappers who are hot on their trail, and return to Linda, the best friend a bird ever had."),
						"Family",
						"Anne Hathaway, Jesse Eisenberg, Will.i.am , Jamie Foxx, George Lopez",
						"Carlos Saldanha", "Fox", "English Spanish",
						"Widescreen", "2011", "1:36", "G"),
				new Movie(
						"http://goo.gl/sur9S",
						"http://goo.gl/KKj9j",
						"Madea",
						"4.0",
						new Text("Madea, a wise-cracking, take-no-prisoners grandma, jumps into action when her niece, Shirley, receives distressing news about her health. All Shirley wants is to gather her three adult children around her and share the news as a family. But Tammy, Kimberly and Byron are too distracted by their own problems: Tammy can't manage her unruly children or her broken marriage; Kimberly is gripped with anger and takes it out on her husband; and Byron, after spending two years in jail, is under pressure to deal drugs again. It's up to Madea, with the help of the equally rambunctious Aunt Bam, to gather the clan together and make things right the only way she knows how: with a lot of tough love, laughter, and the revelation of a long-buried family secret."),
						"Comedy",
						"Tyler Perry, Loretta Devine, Bow Wow, David Mann, Cassi Davis",
						"Tyler Perry", "Lions Gate", "English Spanish",
						"Widescreen", "2011", "1:45", "PG-13"),
				new Movie(
						"http://goo.gl/KIs3s",
						"http://goo.gl/Z67hp",
						"Prom",
						"3.5",
						new Text("At Prom, every couple has a story and no two are exactly alike. For Nova Prescott, it's a classic tale of opposites attracting when she finds herself drawn to the guy who gets in the way of her perfect prom. As several intersecting stories unfold at one high school, secrets are brought to light, seemingly steady relationships unravel, and new romance catches fire."),
						"Comedy",
						"Aimee Teegarden, Thomas McDonell, DeVaughn Nixon, Danielle Campbell, Yin Chang",
						"Joe Nussabaum", "Disney", "French Spanish",
						"Widescreen", "2011", "1:44", "PG"),
				new Movie(
						"http://goo.gl/ErtTR",
						"http://goo.gl/a8OJ5",
						"Blitz",
						"2.5",
						new Text("Tough, uncompromising Detective Tom Brant is teamed with unlikely partner Sgt. Porter Nash to investigate a series of London police murders. Nicknamed The Blitz by the rabid London media, the killer is aiming for tabloid immortality by killing cops in different beats around the city."),
						"Action",
						"Jason Statham, Paddy Considine, Aidan Gillen, David Morrissey, Zawe Ashton",
						"Elliot Lester", "MMS", "English Spanish",
						"Widescreen", "2011", "1:37", "R"),
				new Movie(
						"http://goo.gl/m8HVe",
						"http://goo.gl/JIVFM",
						"Limitless",
						"4.0",
						new Text("Out-of-work writer Eddie Morra gets rejected by his girlfriend Lindy, confirming his belief that he has zero future. However, that all vanishes the day an old friend introduces Eddie to NZT, a designer pharmaceutical that makes him laser focused and more confident than any man alive. Now on an NZT-fueled odyssey, everything Eddie's read, heard or seen is instantly organized and available to him. As the former nobody rises to the top of the financial world, he draws the attention of business mogul Carl Van Loon, who sees this enhanced version of Eddie as the tool to make billions. But brutal side effects jeopardize his meteoric ascent. With a dwindling stash and hit men who will eliminate him to get the NZT, Eddie must stay wired long enough to elude capture and fulfill his destiny. If he can't, he will become just another victim who thought he'd found invincibility in a bottle."),
						"Drama, Suspense",
						"Bradley Cooper, Robert De Niro, Abbie Cornish, Andrew Howard, Anna Friel",
						"Neil Burger", "Fox", "English Spanish", "Widescreen",
						"2011", "1:45", "PG-13"),
				new Movie(
						"http://goo.gl/ndBFz",
						"http://goo.gl/fKkEV",
						"Priest",
						"3.0",
						new Text("A post-apocalyptic sci-fi thriller set in an alternate world -- one ravaged by centuries of war between man and vampires. The story revolves around a legendary Warrior Priest from the last Vampire War who now lives in obscurity among the other downtrodden human inhabitants in walled-in dystopian cities ruled by the Church. When his niece is abducted by a murderous pack of vampires, Priest breaks his sacred vows to venture out on an obsessive quest to find her before they turn her into one of them. He is joined on his crusade by his niece's boyfriend, a trigger-fingered young wasteland sheriff, and a former Warrior Priestess who possesses otherworldly fighting skills."),
						"Horror",
						"Paul Bettany, Karl Urban, Cam Gigandet, Maggie Q, Lily Collins",
						"Scott Charles Stewart", "Sony",
						"English French Spanish", "Widescreen", "2011", "1:27",
						"PG-13"),
				new Movie(
						"http://goo.gl/oP6v3",
						"http://goo.gl/vKfiZ",
						"The Italian Job",
						"4.5",
						new Text("The plan was flawless. The job was executed perfectly. The escape was clean. The only threat mastermind thief Charlie Croker never saw coming was from a member of his own crew. After pulling off an amazing gold bullion heist from a heavily guarded palazzo in Venice, Italy, Charlie and his gang--inside man Steve, computer genius Lyle, wheelman Handsome Rob, explosives expert Left-Ear and veteran safecraker John Bridger--can't believe it when one of them turns out to be a double crosser. Now the job isn't about the payoff, it's about payback! Enter Stella, a beautiful nerves of steel safecracker, who joins Charlie and his former gang when they follow the backstabber to California, where they plan to re-steal the gold by tapping into Los Angeles' traffic control system, manipulating signals and creating one of the biggest traffic jams in L.A. history!"),
						"Action, redbox Replay",
						"Mark Wahlberg, Charlize Theron, Donald Sutherland, Mos , Jason Statham",
						"F. Gary Gary", "Paramount", "English", "Widescreen",
						"2003", "1:51", "PG-13"),
				new Movie(
						"http://goo.gl/WzfVS",
						"http://goo.gl/PtWb5",
						"Jumping the Broom",
						"3.5",
						new Text(
								"A collision of worlds occurs when two African-American families from divergent socioeconomic backgrounds get together one weekend in Martha's Vineyard for the wedding of Sabrina and Jason. But doubts about their impending marriage begin to seep in when they confront difficult future in-laws, pressure from friends, and revelations of dirty secrets."),
						"Comedy",
						"Angela Bassett, Paula Patton, Laz Alonso, Loretta Devine, Meagan Good",
						"Salim Akil",
						"Sony",
						"English French Korean Mandarin Portuguese Spanish Thai",
						"Widescreen", "2011", "1:52", "PG-13"),
				new Movie(
						"http://goo.gl/9Xf03",
						"http://goo.gl/Qkv7e",
						"Horrible Bosses",
						"3.5",
						new Text(
								"Three friends conspire to murder their awful bosses when they realize they are standing in the way of their happiness."),
						"Comedy",
						"Jason Bateman, Jason Sudeikis, Charlie Day, Colin Farrell, Jennifer Aniston",
						"Seth Gordon", "Warner", "", "Widescreen", "2011",
						"1:40", "R")
				);
			}
		//reset();
	
	//Delete all the Movies and send the user back to the original page
	public void reset() {
		EntityManager em = null;
		try {
			em =EMF.get().createEntityManager();
			em.createQuery("DELETE FROM Movie m;").executeUpdate();
		} finally {
			em.close();
		}
		genreSort="All";
		sorting = "Release Dates";
		ratingSort="All Ratings"; 
		
		Movie m = new Movie();
		
	}
	public Movie[] getMovies() {
		String aQuery = "SELECT m from Movie m";
//		if(!genreSort.equals("All")){
//			aQuery += " WHERE '"+genreSort+"' MEMBER OF m.genres";
//		}
//		if(!ratingSort.equals("All Ratings")) {
//			aQuery += " WHERE '"+ratingSort+"' MEMBER OF m.movieRating";
//		}
//		if (sorting.equals("Release Date")) {
//			aQuery += " ORDER BY m.releaseDate ASC";
//		} else if (sorting.equals("Alphabetical")) {
//			aQuery += " ORDER BY m.title ASC";
//		}
		
		EntityManager em = null;
		List six;
		Movie[] newM = null;
		try {
			em =EMF.get().createEntityManager();
			six = em.createQuery(aQuery).getResultList();
			if (six != null){
				newM = new Movie[six.size()];
				for (int i= 0; i < six.size(); i++){
					newM[i] = (Movie) six.get(i);
				}
			}
			
			
			
			
		} finally {
			em.close();
		}
		return newM;
	}

	public String delete() {
		EntityManager em = null;
		try {
			em = EMF.get().createEntityManager();
			em.createQuery("DELETE FROM Movie m WHERE m.title= '"+selectedMovie.getTitle()+"'").executeUpdate();
		} finally {
			em.close();
		}
		return("redbox");
	}
	/**
	 * @return the ratingGenre
	 */
	public String getRatingGenre() {
		return ratingGenre;
	}

	/**
	 * @param aRatingGenre
	 *            the ratingGenre to set
	 */
	public void setRatingGenre(String aRatingGenre) {
		ratingGenre = aRatingGenre;
	}

	/**
	 * @return the genre
	 */
	public String getGenre() {
		return genre;
	}

	/**
	 * @param aGenre
	 *            the genre to set
	 */
	public void setGenre(String aGenre) {
		genre = aGenre;
	}

	/**
	 * @return the movieInfo
	 */
	public Movie getMovieInfo() {
		return movieInfo;
	}

	/**
	 * @param aMovieInfo
	 *            the movieInfo to set
	 */
	public void setMovieInfo(Movie aMovieInfo) {
		movieInfo = aMovieInfo;
	}

	/**
	 * @return the buttonClick
	 */
	public String getButtonClick() {
		return buttonClick;
	}

	/**
	 * @param aButtonClick
	 *            the buttonClick to set
	 */
	public void setButtonClick(String aButtonClick) {
		buttonClick = aButtonClick;
	}

	/**
	 * @return the allClick
	 */
	public String getAllClick() {
		return allClick;
	}

	/**
	 * @param aAllClick
	 *            the allClick to set
	 */
	public void setAllClick(String aAllClick) {
		allClick = aAllClick;
	}

	/**
	 * @return the actionClick
	 */
	public String getActionClick() {
		return actionClick;
	}

	/**
	 * @param aActionClick
	 *            the actionClick to set
	 */
	public void setActionClick(String aActionClick) {
		actionClick = aActionClick;
	}

	/**
	 * @return the comedyClick
	 */
	public String getComedyClick() {
		return comedyClick;
	}

	/**
	 * @param aComedyClick
	 *            the comedyClick to set
	 */
	public void setComedyClick(String aComedyClick) {
		comedyClick = aComedyClick;
	}

	/**
	 * @return the dramaClick
	 */
	public String getDramaClick() {
		return dramaClick;
	}

	/**
	 * @param aDramaClick
	 *            the dramaClick to set
	 */
	public void setDramaClick(String aDramaClick) {
		dramaClick = aDramaClick;
	}

	/**
	 * @return the familyClick
	 */
	public String getFamilyClick() {
		return familyClick;
	}

	/**
	 * @param aFamilyClick
	 *            the familyClick to set
	 */
	public void setFamilyClick(String aFamilyClick) {
		familyClick = aFamilyClick;
	}

	/**
	 * @return the horrorClick
	 */
	public String getHorrorClick() {
		return horrorClick;
	}

	/**
	 * @param aHorrorClick
	 *            the horrorClick to set
	 */
	public void setHorrorClick(String aHorrorClick) {
		horrorClick = aHorrorClick;
	}

	/**
	 * @return the allTogether
	 */
	public ArrayList<Movie> getAllTogether() {
		return allTogether;
	}

	/**
	 * @param aAllTogether
	 *            the allTogether to set
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
	 * @param aWhileSorting
	 *            the whileSorting to set
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
	 * @param aSorting
	 *            the sorting to set
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
	 * @param aRatingSort
	 *            the ratingSort to set
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
	 * @param aGenreSort
	 *            the genreSort to set
	 */
	public void setGenreSort(String aGenreSort) {
		genreSort = aGenreSort;
	}

	/**
	 * @param aRatingItems
	 *            the ratingItems to set
	 */
	public static void setRatingItems(SelectItem[] aRatingItems) {
		ratingItems = aRatingItems;
	}

	/**
	 * @param aSortItems
	 *            the sortItems to set
	 */
	public static void setSortItems(SelectItem[] aSortItems) {
		sortItems = aSortItems;
	}

	/**
	 * 
	 * @return ratingItems
	 */
	public SelectItem[] getRatingItems() {
		return ratingItems;
	}

	/**
	 * Holds the populated SelectMenu Items
	 */
	private static SelectItem[] ratingItems = { new SelectItem("All Ratings"),
			new SelectItem("G"), new SelectItem("PG"), new SelectItem("PG-13"),
			new SelectItem("R"), new SelectItem("NR") };

	/**
	 * 
	 * @return sortItems
	 */
	public SelectItem[] getSortItems() {
		return sortItems;
	}

	/**
	 * Holds the populated SelectMenu Items
	 */
	private static SelectItem[] sortItems = { new SelectItem("Release Dates"),
			new SelectItem("Alphabetical"), };

	/**
	 * 
	 * @return the <String> redboxSelection that navigates to the
	 *         redboxSelection.jsf page
	 */
	public String movieSelected() {
		return "redboxSelection";
	}

	/**
	 * 
	 * @return null so that it returns to the same page This method sets all of
	 *         the CSS properties on the <All> button click
	 */
	public String allClick() {
		allClick = "clickColor";
		actionClick = "nodec";
		comedyClick = "nodec";
		dramaClick = "nodec";
		familyClick = "nodec";
		horrorClick = "nodec";
		genreSort = "All";
		return null;
	}

	/**
	 * 
	 * @return null so that it returns to the same page This method sets all of
	 *         the CSS properties on the <Action> button click
	 */
	public String actionClick() {
		allClick = "nodec";
		actionClick = "clickColor";
		comedyClick = "nodec";
		dramaClick = "nodec";
		familyClick = "nodec";
		horrorClick = "nodec";
		genreSort = "Action";
		return null;
	}

	/**
	 * 
	 * @return null so that it returns to the same page This method sets all of
	 *         the CSS properties on the <Comedy> button click
	 */
	public String comedyClick() {
		allClick = "nodec";
		actionClick = "nodec";
		comedyClick = "clickColor";
		dramaClick = "nodec";
		familyClick = "nodec";
		horrorClick = "nodec";
		genreSort = "Comedy";
		return null;
	}

	/**
	 * 
	 * @return null so that it returns to the same page This method sets all of
	 *         the CSS properties on the <Drama> button click
	 */
	public String dramaClick() {
		allClick = "nodec";
		actionClick = "nodec";
		comedyClick = "nodec";
		dramaClick = "clickColor";
		familyClick = "nodec";
		horrorClick = "nodec";
		genreSort = "Drama";
		return null;
	}

	/**
	 * 
	 * @return null so that it returns to the same page This method sets all of
	 *         the CSS properties on the <Family> button click
	 */
	public String familyClick() {
		allClick = "nodec";
		actionClick = "nodec";
		comedyClick = "nodec";
		dramaClick = "nodec";
		familyClick = "clickColor";
		horrorClick = "nodec";
		genreSort = "Family";
		return null;
	}

	/**
	 * 
	 * @return null so that it returns to the same page This method sets all of
	 *         the CSS properties on the <Horror> button click
	 */
	public String horrorClick() {
		allClick = "nodec";
		actionClick = "nodec";
		comedyClick = "nodec";
		dramaClick = "nodec";
		familyClick = "nodec";
		horrorClick = "clickColor";
		genreSort = "Horror";
		return null;
	}

}
