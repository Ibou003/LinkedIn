package dant.tools.hibernate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.postgresql.util.PSQLException;

import dant.tools.exception.ConnexionException;
import dant.tools.i18n._T;
import dant.tools.utils.StringUtility;

public class HibernateHelper {

	/** Logger. */
	private static Logger logger = Logger.getLogger(HibernateHelper.class);

	/** Current Session */
	protected Session session = null;

	/** Session opened */
	protected SessionFactory sessionFactory = null;

	/** Service registery */
	protected ServiceRegistry serviceRegistry = null;

	/** Options */
	protected HashMap<String, String> options = new HashMap<String, String>();

	/** Configuration of hibernate */
	protected Configuration configuration = new Configuration();

	/** List of annotated class */
	protected List<String> annotatedclasses = new ArrayList<String>();

	/** Default transaction is automatically committed */
	private Boolean autoTransaction = false;

	public HibernateHelper(HashMap<String, String> options) {
		this.options = options;
	}

	/**
	 * @return
	 * @throws ConnexionException
	 */
	public SessionFactory openSessionFactory() throws ConnexionException {

		if (options.get(AvailableSettings.DIALECT) == null) {
			throw new ConnexionException(StringUtility.builder(
					"Paramètre [%%] obligatoire.", AvailableSettings.DIALECT));
		}
		if (options.get(AvailableSettings.URL) == null
				&& options.get(AvailableSettings.DATASOURCE) == null) {
			throw new ConnexionException(StringUtility.builder(
					"Paramètre [%%] obligatoire.", AvailableSettings.URL));
		}
		if (options.get(AvailableSettings.DRIVER) == null) {
			throw new ConnexionException(StringUtility.builder(
					"Paramètre [%%] obligatoire.", AvailableSettings.DRIVER));
		}

		if (options.get("hibernate.current_session_context_class") == null) {
			options.put("hibernate.current_session_context_class", "thread");
		}

		try {

			for (Entry<String, String> option : options.entrySet()) {
				configuration.setProperty(option.getKey(), option.getValue());
			}

			for (String sclass : annotatedclasses) {
				configuration.addAnnotatedClass(Class.forName(sclass));
			}

			serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);

			if (logger.isDebugEnabled()) {
				logger.debug("openSessionFactory");
			}

			if (logger.isDebugEnabled()) {
				logger.debug(StringUtility.builder(_T.T("i18n.messages",
						"HibernateHelper.1"), Integer.toHexString(System
						.identityHashCode(sessionFactory))));
			}

			return sessionFactory;
		} catch (Exception e) {

			if (e.getMessage().contains("Error calling Driver#connect")) {

				if (e.getCause() instanceof PSQLException) {
					PSQLException pSQLException = (PSQLException) e.getCause();
					if (pSQLException != null
							&& pSQLException.getSQLState().equals("28P01")) {
						throw new ConnexionException(
								"Echec du nom utilisateur ou du mot de passe",
								e);
					}
				}

				throw new ConnexionException(StringUtility.builder(
						"Echec de connection à la base %%",
						configuration.getProperty(AvailableSettings.URL)), e);
			} else {
				throw new ConnexionException(e);
			}
		}

	}

	/**
	 * <b>Close session factory.</b>
	 */
	public void closeSessionFactory() throws ConnexionException {
		if (logger.isDebugEnabled()) {
			logger.debug(StringUtility.builder(_T.T("i18n.messages",
					"HibernateHelper.2"), Integer.toHexString(System
					.identityHashCode(sessionFactory))));
		}

		if (sessionFactory != null || !sessionFactory.isClosed()) {
			sessionFactory.close();
		}
	}

	/**
	 * <b>Get current session. if no one create new.</b>
	 * 
	 * @return
	 * @throws Exception
	 */
	public Session getCurrentSession() throws Exception {
		if (sessionFactory == null) {
			openSessionFactory();
		} else if (session != null && session.isOpen()) {
			if (logger.isDebugEnabled()) {
				logger.debug(StringUtility.builder(
						_T.T("i18n.messages", "HibernateHelper.5"),
						Integer.toHexString(System.identityHashCode(session))));
			}
			return session;
		}

		session = sessionFactory.openSession();

		if (logger.isDebugEnabled()) {
			logger.debug(StringUtility.builder(
					_T.T("i18n.messages", "HibernateHelper.3"),
					Integer.toHexString(System.identityHashCode(session))));
		}
		return session;
	}

	/**
	 * <b>Get current session</b>
	 * 
	 * @return
	 * @throws Exception
	 */
	public void closeSession() throws Exception {
		if (sessionFactory != null || !sessionFactory.isClosed()) {
			session = getCurrentSession();
			if (session != null && session.isOpen()) {
				if (logger.isDebugEnabled()) {
					logger.debug(StringUtility.builder(_T.T("i18n.messages",
							"HibernateHelper.4"), Integer.toHexString(System
							.identityHashCode(session))));
				}

				session.close();
			}
		}

	}

	/**
	 * <b>Get hibernate configuration</b>
	 * 
	 * @return configuration
	 */
	public Configuration getConfiguration() {
		return configuration;
	}

	/**
	 * <b>Set hibernate configuration</b>
	 * 
	 * @param <b>configuration</b> configuration
	 * @return configuration
	 */
	public void setConfiguration(Configuration configuration) {
		this.configuration = configuration;
	}

	/**
	 * <b>Get Annotated classes (class without xml)</b>
	 * 
	 * @return Annotated classes
	 */
	public List<String> getAnnotatedclasses() {
		return annotatedclasses;
	}

	/**
	 * <b>Set Annotated classes (class without xml)</b>
	 * 
	 * @param <b>annotatedclasses</b> annotated classes
	 * @return none
	 */
	public void setAnnotatedclasses(List<String> annotatedclasses) {
		this.annotatedclasses = annotatedclasses;
	}

	/**
	 * <b>Get options</b>
	 * 
	 * @return Options list
	 */

	public HashMap<String, String> getOptions() {
		return options;
	}

	/**
	 * <b>Set options</b>
	 * 
	 * @param <b>options</b> Options
	 * @return none
	 */
	public void setOptions(HashMap<String, String> options) {
		this.options = options;
	}

	/**
	 * <b>Get session factory.</b>
	 * 
	 * @return SessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * <b>Set session factory.</b>
	 * 
	 * @param sessionFactory
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * <b>Get if fonction was wrap by a transaction</b>
	 * 
	 * @return
	 */
	public Boolean getAutoTransaction() {
		return autoTransaction;
	}

	/**
	 * <b>Set if fonction was wrap by a transaction</b>
	 * 
	 * @param <b>autoTransaction</b>True or False
	 * @return
	 */
	public void setAutoTransaction(Boolean autoTransaction) {
		this.autoTransaction = autoTransaction;
	}

}
