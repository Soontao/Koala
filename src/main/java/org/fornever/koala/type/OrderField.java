package org.fornever.koala.type;

import org.fornever.koala.type.enums.OrderType;

public class OrderField {

	String field;
	OrderType type;

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public OrderType getType() {
		return type;
	}

	public void setType(OrderType type) {
		this.type = type;
	}

	public OrderField(String field, OrderType type) {
		super();
		this.field = field;
		this.type = type;
	}

}