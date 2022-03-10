package inventory.dao;

import java.io.Serializable;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional(rollbackOn = Exception.class)
public class BaseDaoImpl<E> implements BaseDao<E> {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void add(E instance) {
		sessionFactory.getCurrentSession().persist(instance);
	}

	@Override
	public void update(E instance) {
		sessionFactory.getCurrentSession().merge(instance);
	}

	@Override
	public E findById(Class<E> e, Serializable id) {
		return sessionFactory.getCurrentSession().get(e, id);
	}

	@Override
	public List<E> findByProperty(String property, Object value) {
		StringBuilder queryString = new StringBuilder("");
		queryString.append(" from ").append(getGenericName()).append(" as model where model.activeFlag = 1 and model.")
				.append(property).append(" = ?");

		Query<E> query = sessionFactory.getCurrentSession().createQuery(queryString.toString());
		query.setParameter(0, value);

		return query.getResultList();
	}

	@Override
	public List<E> findAll() {
		StringBuilder queryString = new StringBuilder("");
		queryString.append(" from").append(getGenericName()).append(" as model where model.activeFlag = 1");

		return sessionFactory.getCurrentSession().createQuery(queryString.toString()).list();
	}

	public String getGenericName() {
		String s = getClass().getGenericSuperclass().toString();

		Pattern pattern = Pattern.compile("\\<(>*?)//>");
		Matcher m = pattern.matcher(s);

		String generic = null;
		if (m.find()) {
			generic = m.group(1);
		}

		return generic;
	}
}
