package org.fornever.koala.types.internal;

import com.google.inject.AbstractModule;
import org.fornever.koala.types.enums.EConsistenceLevel;

import java.util.ArrayList;
import java.util.List;

public class KoalaConfig<T, K, S> {

	private String entityName = "default";
	private Integer writeWorker = 10;
	private Integer readWorker = 30;
	/**
	 * When sync data to remote, data has changed, still write
	 * <p>
	 * if false, will throw sync error
	 */
	private Boolean syncEvenDataChanged = true;
	/**
	 * Even sync failed, internal server will retry later
	 * <p>
	 * if data equal zero, failed data will throw sync error direct
	 */
	private Integer maxRetry = 0;
	/**
	 * Sync data to remote, default is true, but if you have multi koala server instance for load balance, just set one instance as true maybe a better choose
	 */
	private Boolean syncData = true;
	private List<AbstractModule> modules = new ArrayList<>();
	private EConsistenceLevel consistenceLevel = EConsistenceLevel.DEFAULT;

	public String getEntityName() {
		return entityName;
	}

	public KoalaConfig<T, K, S> setEntityName(String entityName) {
		this.entityName = entityName;
		return this;
	}

	public Integer getWriteWorker() {
		return writeWorker;
	}

	public KoalaConfig<T, K, S> setWriteWorker(Integer writeWorker) {
		this.writeWorker = writeWorker;
		return this;
	}

	public Integer getReadWorker() {
		return readWorker;
	}

	public KoalaConfig<T, K, S> setReadWorker(Integer readWorker) {
		this.readWorker = readWorker;
		return this;
	}

	public List<AbstractModule> getModules() {
		return modules;
	}

	public KoalaConfig<T, K, S> setModules(List<AbstractModule> modules) {
		this.modules = modules;
		return this;
	}

	public Boolean getSyncData() {
		return syncData;
	}

	public KoalaConfig setSyncData(Boolean syncData) {
		this.syncData = syncData;
		return this;
	}

	public EConsistenceLevel getConsistenceLevel() {
		return consistenceLevel;
	}

	public KoalaConfig setConsistenceLevel(EConsistenceLevel consistenceLevel) {
		this.consistenceLevel = consistenceLevel;
		return this;
	}

	public Boolean getSyncEvenDataChanged() {
		return syncEvenDataChanged;
	}

	public KoalaConfig setSyncEvenDataChanged(Boolean syncEvenDataChanged) {
		this.syncEvenDataChanged = syncEvenDataChanged;
		return this;
	}

	public Integer getMaxRetry() {
		return maxRetry;
	}

	public KoalaConfig setMaxRetry(Integer maxRetry) {
		this.maxRetry = maxRetry;
		return this;
	}
}
