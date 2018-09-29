package org.fornever.koala.blurprints;

import java.util.List;

import org.fornever.koala.exception.NotSupportException;
import org.fornever.koala.type.Row;
import org.fornever.koala.type.SearchParameter;

public interface IDataSource {

	default List<Row> find(SearchParameter param) throws Throwable {
		throw new NotSupportException();
	}

	default Row retrive(Object key) throws Throwable {
		throw new NotSupportException();
	}

	default Boolean delete(Object key) throws Throwable {
		throw new NotSupportException();
	}

	default Row create(Row row) throws Throwable {
		throw new NotSupportException();
	}

	default Row update(Object key, Row row) throws Throwable {
		throw new NotSupportException();
	}

}
