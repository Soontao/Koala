package org.fornever.koala.blurprints;

import java.util.List;

import org.fornever.koala.exception.NotSupportException;
import org.fornever.koala.type.Row;
import org.fornever.koala.type.SearchParameter;

public interface IDataSource {

	default Object fromRowToKey(Row row) throws Throwable {
		throw new NotSupportException();
	}

	/**
	 * create data
	 * 
	 * @param row
	 * @return
	 * @throws Throwable
	 */
	default Row create(Row row) throws Throwable {
		throw new NotSupportException();
	}

	/**
	 * delete data
	 * 
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	default Boolean delete(Object key) throws Throwable {
		throw new NotSupportException();
	}

	/**
	 * find data
	 * 
	 * @param param
	 * @return
	 * @throws Throwable
	 */
	default List<Row> find(SearchParameter param) throws Throwable {
		throw new NotSupportException();
	}

	/**
	 * retrieve data by key
	 * 
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	default Row retrieve(Object key) throws Throwable {
		throw new NotSupportException();
	}

	/**
	 * update data
	 * 
	 * @param key
	 * @param row
	 * @return
	 * @throws Throwable
	 */
	default Row update(Row row) throws Throwable {
		throw new NotSupportException();
	}

}
