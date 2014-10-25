package edu.common.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseDao<T, PK extends Serializable> {

	@Autowired
	private SessionFactory sessionFactory;

	private Session session;
	private Transaction transaction;
	protected Class<T> entityClass;

	@SuppressWarnings("unchecked")
	public BaseDao() {
		entityClass = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	protected void openSession() {
		if (null == session )
			session = sessionFactory.openSession();
	}

	protected void closeSession() {
		if (null != session || session.isOpen())
			session.close();
	}

	public List<T> findList() {
		this.openSession();
		String hql = "from " + entityClass.getSimpleName();
		Query query = session.createQuery(hql);
		List<T> list = query.list();
		//this.closeSession();
		return list;
	}

	public T get(PK pk) {
		this.openSession();
		T result = (T) session.load(entityClass, pk);
		//this.closeSession();
		return result;
	}

	public void add(T entity) {
		this.openSession();
		transaction = session.beginTransaction();
		transaction.begin();
		session.save(entity);
		transaction.commit();
		//this.closeSession();
	}

	public void delete(PK pk) {
		this.openSession();
		transaction = session.beginTransaction();
		transaction.begin();
		session.delete(this.get(pk));
		transaction.commit();
		//this.closeSession();
	}

	public void update(T entity) {
		// ...
		this.openSession();
		transaction = session.beginTransaction();
		transaction.begin();
		session.update(entity);
		transaction.commit();
		//his.closeSession();
	}

}
