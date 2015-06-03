package dant.linkedin.services;

import java.util.List;
import net.sf.ehcache.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.query.dsl.QueryBuilder;



import play.db.jpa.JPA;
import dant.linkedin.core.User;



/**
 * ibouroihim loutfi
 * 
 */


public class Searchs {
	
  
	public void doIndex() throws InterruptedException {
		Session session = JPA.em().unwrap(org.hibernate.Session.class);
		
		FullTextSession fullTextSession = Search.getFullTextSession(session);
		fullTextSession.createIndexer().startAndWait();
		
		//fullTextSession.close();
	}
	
	public List<User> search(String queryString) {
		Session session = JPA.em().unwrap(org.hibernate.Session.class);
		FullTextSession fullTextSession = Search.getFullTextSession(session);
		
		QueryBuilder queryBuilder = fullTextSession.getSearchFactory().buildQueryBuilder().forEntity(User.class).get();
		org.apache.lucene.search.Query luceneQuery = queryBuilder.keyword().onFields("firstName").matching(queryString).createQuery();

		// wrap Lucene query in a javax.persistence.Query
		org.hibernate.Query fullTextQuery = fullTextSession.createFullTextQuery(luceneQuery, User.class);
		
		@SuppressWarnings("unchecked")
		List<User> userctList = fullTextQuery.list();
		
		//fullTextSession.close();
		
		return userctList;
	}
	
	public void displayUserTableData() {
		Session session = null;
		
		try {
			session = JPA.em().unwrap(org.hibernate.Session.class);
			
			// Fetching saved data
			@SuppressWarnings("unchecked")
			List<User> userList = session.createQuery("from User").list();
			
			for (User user : userList) {
				System.out.println(user);
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally{
			if(session != null) {
				//session.close();
			}
		}
	}

}
