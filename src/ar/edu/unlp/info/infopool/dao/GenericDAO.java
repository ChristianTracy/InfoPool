package ar.edu.unlp.info.infopool.dao;

public interface GenericDAO<T> {

	public void add(T entity);
//
//	public void delete(T entity);
//
//	public void update(T entity);

	public T getById(Long id);

//	public boolean exist(Long id);

}
