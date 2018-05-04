package org.fornever.java;

import org.fornever.java.entity.KoalaBaseEntity;
import org.fornever.java.processor.IDeleteEntityProcessor;
import org.fornever.java.processor.IReadEntityProcessor;
import org.fornever.java.processor.ISaveEntityProcessor;
import org.fornever.java.processor.IUpdateEntityProcessor;

/**
 * Koala Entity Processor
 * 
 * @author Theo Sun
 *
 * @param <T>
 *            Entity Type
 * @param <S>
 *            Search Prarameter Type
 * @param <K>
 *            Primary Key Type
 */
public class Koala<T extends KoalaBaseEntity, S, K> {

	public static <T1 extends KoalaBaseEntity, S1, K1> Koala<T1, S1, K1> New() {
		return new Koala<T1, S1, K1>();
	}

	private Integer retryCount = 0;
	private Integer parallelThread = 5;
	private Integer remotePPS = 5;

	private IReadEntityProcessor<T, S> readProcessor;
	private ISaveEntityProcessor<T> saveProcessor;
	private IUpdateEntityProcessor<T, K> updateProcessor;
	private IDeleteEntityProcessor<K> deleteProcessor;

	private IReadEntityProcessor<T, S> remoteReadProcessor;
	private ISaveEntityProcessor<T> remoteSaveProcessor;
	private IUpdateEntityProcessor<T, K> remoteUpdateProcessor;
	private IDeleteEntityProcessor<K> remoteDeleteProcessor;

	public Koala() {

	}

	public T createEntity(T entity) {
		return null;
	}

	public Koala<T, S, K> setRetryCount(Integer retryCount) {
		this.retryCount = retryCount;
		return this;
	}

	public Koala<T, S, K> setParallelThread(Integer parallelThread) {
		this.parallelThread = parallelThread;
		return this;
	}

	public Koala<T, S, K> setRemotePPS(Integer remotePPS) {
		this.remotePPS = remotePPS;
		return this;
	}

	public Koala<T, S, K> setReadProcessor(IReadEntityProcessor<T, S> readProcessor) {
		this.readProcessor = readProcessor;
		return this;
	}

	public Koala<T, S, K> setSaveProcessor(ISaveEntityProcessor<T> saveProcessor) {
		this.saveProcessor = saveProcessor;
		return this;
	}

	public Koala<T, S, K> setUpdateProcessor(IUpdateEntityProcessor<T, K> updateProcessor) {
		this.updateProcessor = updateProcessor;
		return this;
	}

	public Koala<T, S, K> setDeleteProcessor(IDeleteEntityProcessor<K> deleteProcessor) {
		this.deleteProcessor = deleteProcessor;
		return this;
	}

	public Koala<T, S, K> setRemoteReadProcessor(IReadEntityProcessor<T, S> remoteReadProcessor) {
		this.remoteReadProcessor = remoteReadProcessor;
		return this;
	}

	public Koala<T, S, K> setRemoteSaveProcessor(ISaveEntityProcessor<T> remoteSaveProcessor) {
		this.remoteSaveProcessor = remoteSaveProcessor;
		return this;
	}

	public Koala<T, S, K> setRemoteUpdateProcessor(IUpdateEntityProcessor<T, K> remoteUpdateProcessor) {
		this.remoteUpdateProcessor = remoteUpdateProcessor;
		return this;
	}

	public Koala<T, S, K> setRemoteDeleteProcessor(IDeleteEntityProcessor<K> remoteDeleteProcessor) {
		this.remoteDeleteProcessor = remoteDeleteProcessor;
		return this;
	}

	public void start() {

	}

	public void stop() {

	}

}
