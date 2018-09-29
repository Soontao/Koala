package org.fornever.koala.enums;

public enum ConditionOperator {
	/**
	 * full equal value
	 */
	equal,
	/**
	 * not equal value
	 */
	not_equal,
	/**
	 * >
	 */
	greater_than,
	/**
	 * >=
	 */
	greater_equal,
	/**
	 * <
	 */
	less_than,
	/**
	 * <=
	 */
	less_equal,
	/**
	 * fuzzy match
	 */
	like,
	/**
	 * equal in list
	 */
	in
}
