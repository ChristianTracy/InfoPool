package ar.edu.unlp.info.infopool.dao;

import java.util.List;

public interface GenericDAO<T> {

	public void add(T entity);

	public void delete(T entity);
	
	public T delete(Long id);

	public T update(T entity);

	public T getById(Long id);

	public boolean exist(Long id);

	public List<T> getAll();
}
