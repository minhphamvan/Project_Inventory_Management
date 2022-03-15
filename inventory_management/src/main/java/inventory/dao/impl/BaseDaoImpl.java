package inventory.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import inventory.dao.BaseDao;

@Repository
@Transactional(rollbackFor = Exception.class)
public class BaseDaoImpl<E> implements BaseDao<E> {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void add(E instance) {
		sessionFactory.getCurrentSession().save(instance);
	}

	@Override
	public void update(E instance) {
		sessionFactory.getCurrentSession().merge(instance);
	}

	@Override
	public E findById(Class<E> e, Serializable id) {
		return (E) sessionFactory.getCurrentSession().get(e, id);
	}

	@Override
	public List<E> findByProperty(String property, Object value) {
		StringBuilder queryString = new StringBuilder("");
		queryString.append(" from ").append(getGenericName()).append(" as model where model.activeFlag = 1 and model.")
				.append(property).append(" = ?");

		Query query = sessionFactory.getCurrentSession().createQuery(queryString.toString());
		query.setParameter(0, value);

		return query.list();
	}

	@Override
	public List<E> findAll() {
		StringBuilder queryString = new StringBuilder("");
		queryString.append(" from ").append(getGenericName()).append(" as model where model.activeFlag = 1");

		return sessionFactory.getCurrentSession().createQuery(queryString.toString()).list();
	}

	public String getGenericName() {
		String s = getClass().getGenericSuperclass().toString();

		Pattern pattern = Pattern.compile("\\<(.*?)\\>");
		Matcher m = pattern.matcher(s);

		String generic = "null";
		if (m.find()) {
			generic = m.group(1);
		}
		return generic;
	}
}
