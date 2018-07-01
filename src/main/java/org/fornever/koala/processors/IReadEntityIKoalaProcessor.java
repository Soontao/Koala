package org.fornever.koala.processors;

import org.fornever.koala.exceptions.ReadFailedException;

import java.util.List;

/**
 * 读取Entity处理器
 *
 * @param <T> 实体类型
 * @param <S> 搜索参数
 * @author Theo Sun
 */
public interface IReadEntityIKoalaProcessor<T, S> extends IKoalaProcessor {
    List<T> read(S searchParameter) throws ReadFailedException;
}
