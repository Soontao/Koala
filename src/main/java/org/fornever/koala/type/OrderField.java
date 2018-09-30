package org.fornever.koala.type;

import org.fornever.koala.enums.OrderType;

public class OrderField {

	String field;
	OrderType type;

	public OrderField(String field, OrderType type) {
		super();
		this.field = field;
		this.type = type;
	}

}