package dant.tools.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dant.tools.exception.CRUDException;

public class CRUDDao<T> {
	/** It true aach operation warp by an transaction */
	private Boolean autoTransaction;

	/** Name of Table on hibernate xml file */
	private String tableName;

	/** Hibernate helper */
	private HibernateHelper helper;

	/**
	 * <b>Constructor</b>
	 * 
	 * @param <b>tableName</b> Hibernate name table
	 */
	public CRUDDao(String tableName, HibernateHelper helper) {
		this.tableName = tableName;
		this.helper = helper;
		this.autoTransaction = helper.getAutoTransaction();
	}

	/**
	 * Read filter by id (PK)
	 * 
	 * @param id
	 * @return T
	 * @throws CRUDException
	 */
	@SuppressWarnings("unchecked")
	public T read(int id) throws CRUDException {
		Transaction trans = null;
		boolean isOnError = true;
		try {
			Session session = helper.getCurrentSession();
			if (autoTransaction) {
				trans = session.beginTransaction();
			}
			Query query = session.createQuery("FROM " + tableName
					+ " tb WHERE tb.id = :id");
			query.setInteger("id", id);
			List<Object> l = query.list();

			isOnError = false;
			if (l.size() == 1) {
				return (T) l.get(0);
			} else {
				return null;
			}

		} catch (CRUDException e) {
			throw e;
		} catch (Exception e) {
			throw new CRUDException("Echec lors de la lecture", e);
		} finally {
			if (autoTransaction && trans != null) {
				if (isOnError) {
					trans.rollback();
				} else {
					trans.commit();
				}
			}
		}
	}

	/**
	 * Read All from Table
	 * 
	 * @return List<T>
	 * @throws CRUDException
	 */
	public List<T> readAll() throws CRUDException {
		Transaction trans = null;
		boolean isOnError = true;
		try {
			Session session = helper.getCurrentSession();
			if (autoTransaction) {
				trans = session.beginTransaction();
			}
			Query query = session.createQuery("FROM " + tableName);
			List<T> l = query.list();

			isOnError = false;
			return l;

		} catch (CRUDException e) {
			throw e;
		} catch (Exception e) {
			throw new CRUDException("Echec lors de la lecture", e);
		} finally {
			if (autoTransaction && trans != null) {
				if (isOnError) {
					trans.rollback();
				} else {
					trans.commit();
				}
			}
		}
	}

	/**
	 * <b>Create an object</b>
	 * 
	 * @param <b>obj</b>Pojo Object to write in data base
	 * @return
	 * @throws CRUDException
	 */
	public void create(T obj) throws CRUDException {
		Transaction trans = null;
		boolean isOnError = true;
		try {
			Session session = helper.getCurrentSession();
			if (autoTransaction) {
				trans = session.beginTransaction();
			}
			session.save(obj);
			session.flush();
			isOnError = false;
		} catch (CRUDException e) {
			throw e;
		} catch (Exception e) {
			throw new CRUDException("Echec lors de l'insertion", e);
		} finally {
			if (autoTransaction && trans != null) {
				if (isOnError) {
					trans.rollback();
				} else {
					trans.commit();
				}
			}
		}
	}

	/**
	 * <b>Write an object</b>
	 * 
	 * @param <b>obj</b>Pojo Object to update
	 * @return
	 * @throws CRUDException
	 */
	public void update(T obj) throws CRUDException {
		Transaction trans = null;
		boolean isOnError = true;
		try {
			Session session = helper.getCurrentSession();
			if (autoTransaction) {
				trans = session.beginTransaction();
			}
			// session.update(obj);
			session.saveOrUpdate(obj);
			session.flush();
			isOnError = false;
		} catch (CRUDException e) {
			throw e;
		} catch (Exception e) {
			throw new CRUDException("Echec lors de la mise à jour.", e);
		} finally {
			if (autoTransaction && trans != null) {
				if (isOnError) {
					trans.rollback();
				} else {
					trans.commit();
				}
			}
		}
	}

	/**
	 * <b>Delete an object</b>
	 * 
	 * @param <b>obj</b>Pojo Object to write matting in xml hibernate file
	 * @return
	 * @throws CRUDException
	 */
	public void delete(T obj) throws CRUDException {
		Transaction trans = null;
		boolean isOnError = true;
		try {
			Session session = helper.getCurrentSession();
			if (autoTransaction) {
				trans = session.beginTransaction();
			}
			session.delete(obj);
			session.flush();
			isOnError = false;
		} catch (CRUDException e) {
			throw e;
		} catch (Exception e) {
			throw new CRUDException("Echec lors de la suppression", e);
		} finally {
			if (autoTransaction && trans != null) {
				if (isOnError) {
					trans.rollback();
				} else {
					trans.commit();
				}
			}
		}
	}

	/**
	 * <b>Check if an object exists by id</b>
	 * 
	 * @param <b>id</b>identifiant
	 * @return
	 * @throws CRUDException
	 */
	public Boolean exists(int id) throws CRUDException {
		Transaction trans = null;
		boolean isOnError = true;
		try {
			Session session = helper.getCurrentSession();
			if (autoTransaction) {
				trans = session.beginTransaction();
			}
			Query query = session.createQuery("select 1 from " + tableName
					+ " tb " + "where tb.id=" + Integer.toString(id));
			isOnError = false;
			return (query.uniqueResult() != null);
		} catch (CRUDException e) {
			throw e;
		} catch (Exception e) {
			throw new CRUDException("Echec lors de la lecture", e);
		} finally {
			if (autoTransaction && trans != null) {
				if (isOnError) {
					trans.rollback();
				} else {
					trans.commit();
				}
			}
		}
	}

	/**
	 * <b>Get transaction</b>
	 * 
	 * @return Transaction
	 * @throws CRUDException
	 */
	public Transaction beginTransation() throws CRUDException {
		try {
			Session session = helper.getCurrentSession();
			return session.beginTransaction();

		} catch (CRUDException e) {
			throw e;
		} catch (Exception e) {
			throw new CRUDException(e.getMessage(), e);
		}
	}

	/**
	 * <b>Commit transaction</b>
	 * 
	 * @param </b>trans<b> Transaction
	 * @return
	 * @throws CRUDException
	 */
	public void commit(Transaction trans) throws CRUDException {
		try {
			trans.commit();

		} catch (Exception e) {
			throw new CRUDException(e.getMessage(), e);
		}
	}

	/**
	 * <b>Rollback transaction</b>
	 * 
	 * @param </b>trans<b> Transaction
	 * @return
	 * @throws CRUDException
	 */
	public void rollback(Transaction trans) throws CRUDException {
		try {
			trans.rollback();

		} catch (Exception e) {
			throw new CRUDException(e.getMessage(), e);
		}
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
