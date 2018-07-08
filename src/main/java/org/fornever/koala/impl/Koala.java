package org.fornever.koala.impl;

import com.google.inject.Guice;
import com.google.inject.Inject;
import org.fornever.koala.IKoala;
import org.fornever.koala.exceptions.NotImplementationException;
import org.fornever.koala.exceptions.ValidationException;
import org.fornever.koala.processors.IKoalaProcessors;
import org.fornever.koala.schedule.abs.AScheduleRunner;
import org.fornever.koala.types.enums.EKoalaInstanceState;
import org.fornever.koala.types.internal.KoalaConfig;
import org.fornever.koala.types.internal.KoalaReferenceEntity;
import org.fornever.koala.types.internal.ValidationError;

import java.util.List;
import java.util.logging.Logger;

/**
 * Koala
 *
 * @param <T> Entity Type
 * @param <S> Search Parameter Type
 * @author Theo Sun
 */
public class Koala<T, K, S> implements IKoala<T, K, S> {

	private Logger logger = Logger.getLogger(getClass().getName());
	private KoalaConfig config = new KoalaConfig();
	private AScheduleRunner scheduleRunner;
	private IKoalaProcessors<T, K, S> processors;

	private Koala() {
	}

	public static <T1, K1, S1> Koala<T1, K1, S1> New(KoalaConfig<T1, K1, S1> config) {
		return Guice.createInjector(config.getModules()).getInstance(Koala.class);
	}

	@Inject
	public Koala<T, K, S> setConfig(KoalaConfig config) {
		this.config = config;
		return this;
	}

	@Inject
	public Koala<T, K, S> setScheduleRunner(AScheduleRunner scheduleRunner) {
		this.scheduleRunner = scheduleRunner;
		return this;
	}

	@Inject
	public Koala<T, K, S> setProcessors(IKoalaProcessors<T, K, S> processors) {
		this.processors = processors;
		return this;
	}

	@Override
	public void remoteEntityChanged(K key) throws Exception {
		this.processors.getReferenceUpdator().updateKoalaReference(key, EKoalaInstanceState.OUT_OF_DATE);
	}

	private void writePreCheck(K key, T entity) throws NotImplementationException, ValidationException {
		switch (this.config.getConsistenceLevel()) {
			case ONLY_PROXY:
			case ONLY_READ_CACHE:
			case CHECK_REMOTE_ON_SYNC:
			case CHECK_REMOTE_ON_SAVE_AND_SYNC:
				break;
			case DEFAULT:
				break;
		}
		ValidationError errors = this.processors.getLocalValidator().validate(key, entity);
		if (errors.haveError.get()) {
			throw new ValidationException().setErrors(errors);
		}
	}

	@Override
	public T save(T entity) throws Exception {
		T rt = this.processors.getLocalSaveProcessor().save(entity);
		K key = this.processors.getKeyAccessor().getKey(rt);
		return rt;
	}

	@Override
	public T update(T entity) throws Exception {
		// get key
		K key = this.processors.getKeyAccessor().getKey(entity);
		T rt = this.processors.getLocalUpdateProcessor().update(key, entity);
		return rt;
	}

	@Override
	public Boolean delete(K key) throws Exception {
		Boolean rt = this.processors.getLocalDeleteProcessor().delete(key);
		return rt;
	}

	@Override
	public List<T> read(S search) throws Exception {
		return null;
	}

	@Override
	public T retrive(K key) throws Exception {
		return null;
	}

	@Override
	public void startSync() throws Exception {

	}

	@Override
	public void stopSync() throws Exception {

	}

}
