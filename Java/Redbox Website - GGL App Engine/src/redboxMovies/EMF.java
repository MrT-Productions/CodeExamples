package redboxMovies;

import java.io.Serializable;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class EMF implements Serializable{
	private static final EntityManagerFactory emfInstance = Persistence.createEntityManagerFactory("transactions-optional");
	
	private EMF() {
		//intentionally empty
	}
	
	public static EntityManagerFactory get() {
		return emfInstance;
	}

}
