package org.diginamic.fr.dao;

import java.util.List;
/**
 * Idao est une interface G"n"rique pour toutes les futures classes de type Idao
 * @author Hamza
 *
 * @param <T>
 */
public interface Idao<T> {
	List<T> extraire();
	void insert (T data);
	int update(T ancienData, T nouveauData);
	boolean delete(T data);

}
