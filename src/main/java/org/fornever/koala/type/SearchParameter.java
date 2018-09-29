package org.fornever.koala.type;

import java.util.ArrayList;
import java.util.List;

import org.fornever.koala.enums.ConditionOperator;

public class SearchParameter {

	List<Condition> conditions = new ArrayList<>();

	public static SearchParameter New() {
		return new SearchParameter();
	}

	public SearchParameter addCondition(String field, ConditionOperator op, Object value) {
		this.conditions.add(new Condition(field, op, value));
		return this;
	}

}

class Condition {

	public Condition(String fieldName, ConditionOperator operator, Object value) {
		super();
		this.fieldName = fieldName;
		this.operator = operator;
		this.value = value;
	}

	String fieldName;
	ConditionOperator operator;
	Object value;
}