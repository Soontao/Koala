package org.fornever.java.processor;

import java.util.List;

/**
 * 读取Entity处理器
 * 
 * @author Theo Sun
 *
 * @param <T>
 *            实体类型
 * @param <S>
 *            搜索参数
 */
public interface IReadEntityProcessor<T, S> {
	List<T> read(S searchParameter) throws Exception;
}
