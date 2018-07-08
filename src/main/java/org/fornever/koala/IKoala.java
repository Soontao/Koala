package org.fornever.koala;

import org.fornever.koala.types.annotations.LocalValidation;

import javax.transaction.Transactional;
import java.util.List;

public interface IKoala<T, K, S> {

	void remoteEntityChanged(K key) throws Exception;

	@Transactional
	@LocalValidation
	T save(T entity) throws Exception;

	@Transactional
	@LocalValidation
	T update(T entity) throws Exception;

	@Transactional
	@LocalValidation
	Boolean delete(K key) throws Exception;

	List<T> read(S search) throws Exception;

	T retrive(K key) throws Exception;

	void startSync() throws Exception;

	void stopSync() throws Exception;

}
