package org.fornever.koala.blurprints;

import org.fornever.koala.type.Row;
import org.fornever.koala.type.SearchParameter;
import org.fornever.koala.type.ValidationErrors;

/**
 * Validator
 * 
 * @author theosun
 *
 */
public interface IValidator {

	default ValidationErrors beforeCreate(Row row) {
		return new ValidationErrors();
	};

	default ValidationErrors beforeUpdate(Object key, Row row) {
		return new ValidationErrors();
	}

	default ValidationErrors beforeDelete(Object key) {
		return new ValidationErrors();
	}

	default ValidationErrors beforeRetrive(Object key) {
		return new ValidationErrors();
	}

	default ValidationErrors beforeFind(SearchParameter param) {
		return new ValidationErrors();
	}

}
