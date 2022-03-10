package inventory.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<E> {

	public void add(E instance);

	public void update(E instance);

	public E findById(Class<E> e, Serializable id);

	public List<E> findByProperty(String property, Object value);

	public List<E> findAll();
}
