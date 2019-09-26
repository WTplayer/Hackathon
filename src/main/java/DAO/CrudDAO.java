package DAO;

import java.util.ArrayList;

public interface CrudDAO<T> {

	public void create(T object) throws Exception;

	public ArrayList<T> read() throws Exception;
	
	public void delete(T object) throws Exception;
	
	public void update(T object, int id) throws Exception;

	public T find(T object) throws Exception;
}
