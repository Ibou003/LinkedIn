package dant.linkedin.dao;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import dant.linkedin.core.Comment;
import dant.tools.exception.CRUDException;
import dant.tools.exception.ConnexionException;
import dant.tools.hibernate.HibernateHelper;

public class TestCommentDao {

	/** Logger */
	private static Logger logger = Logger.getLogger(TestCommentDao.class);

	/** Hibernate context */
	private HibernateHelper helper;

	@Before
	public void initHibernate() {
		System.out.print("test - CommentDao - Start");

		BasicConfigurator.configure();

		HashMap<String, String> options = new HashMap<String, String>();
		options.put("hibernate.dialect",
				"org.hibernate.dialect.PostgreSQLDialect");
		options.put("hibernate.connection.driver_class",
				"org.postgresql.Driver");
		options.put("hibernate.connection.url",
				"jdbc:postgresql://localhost:5432/linkedin?user=postgres&password=0");

		// Drop and re-create the database schema on startup
		// options.put("hibernate.hbm2ddl.auto", "create-drop");

		List<String> cls = new ArrayList<String>();

		cls.add("dant.linkedin.core.Comment");

		helper = new HibernateHelper(options);
		helper.setAnnotatedclasses(cls);
		try {
			helper.openSessionFactory();
		} catch (ConnexionException e) {
			fail("will be no fails check you local configration of hibernate will be postgres localhost:5432, "
					+ "bdd test, user postgres, pwd 0");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void test() {
		try {
			CommentDao commentDao = new CommentDao(helper);
			commentDao.setAutoTransaction(true);
			Comment comment = commentDao.read(1);
			System.out.println(comment);

		} catch (CRUDException e) {
			e.printStackTrace();
		} finally {
			try {
				helper.closeSession();
			} catch (Exception e) {
				logger.error(e.getMessage());
				e.printStackTrace();
			}
		}

		System.out.print("test - CommentDao - Stop");

	}
}
