package org.fornever.koala.type;

import org.fornever.koala.type.enums.ConditionOperator;

public class Condition {

	String field;

	ConditionOperator operator;
	Object value;

	public Condition(String fieldName, ConditionOperator operator, Object value) {
		super();
		this.field = fieldName;
		this.operator = operator;
		this.value = value;
	}

	public String getField() {
		return field;
	}

	public ConditionOperator getOperator() {
		return operator;
	}

	public Object getValue() {
		return value;
	}

	public void setField(String field) {
		this.field = field;
	}

	public void setOperator(ConditionOperator operator) {
		this.operator = operator;
	}

	public void setValue(Object value) {
		this.value = value;
	}
}