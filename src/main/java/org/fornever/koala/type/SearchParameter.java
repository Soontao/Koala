package org.fornever.koala.type;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.fornever.koala.enums.ConditionOperator;
import org.fornever.koala.enums.OrderType;

public class SearchParameter {

	public static SearchParameter New() {
		return new SearchParameter();
	}

	private Map<String, List<Condition>> fieldConditions = new HashMap<>();

	private List<OrderField> orders = new ArrayList<>();

	Integer size = 10;

	Integer page = 1;

	public SearchParameter addCondition(String field, ConditionOperator op, Object value) {
		Condition condition = new Condition(field, op, value);
		// > update field condition
		List<Condition> fieldCondition = this.fieldConditions.getOrDefault(field, new ArrayList<Condition>());
		fieldCondition.add(condition);
		this.fieldConditions.put(field, fieldCondition);
		// < update field condition
		return this;
	}

	public SearchParameter addOrder(String field, OrderType type) {
		this.orders.add(new OrderField(field, type));
		return this;
	}

	public Map<String, List<Condition>> getFieldConditions() {
		return fieldConditions;
	}

	public List<OrderField> getOrders() {
		return orders;
	}

	public Integer getPage() {
		return page;
	}

	public Integer getSize() {
		return size;
	}

	public void setFieldConditions(Map<String, List<Condition>> fieldConditions) {
		this.fieldConditions = fieldConditions;
	}

	public void setOrders(List<OrderField> orders) {
		this.orders = orders;
	}

	public SearchParameter setPage(Integer page) {
		this.page = page;
		return this;
	}

	public SearchParameter setSize(Integer size) {
		this.size = size;
		return this;
	}

}