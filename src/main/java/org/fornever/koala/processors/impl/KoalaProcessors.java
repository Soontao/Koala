package org.fornever.koala.processors.impl;

import com.google.inject.Inject;
import org.fornever.koala.processors.IKoalaProcessors;
import org.fornever.koala.processors.entity.crud.*;
import org.fornever.koala.processors.entity.helper.IKoalaKeyAccessor;
import org.fornever.koala.processors.internal.IFinallyFailedNotifier;
import org.fornever.koala.processors.internal.IKoalaInstanceSelector;
import org.fornever.koala.processors.internal.abs.AEntityValidator;
import org.fornever.koala.processors.internal.abs.AKoalaReferenceUpdater;
import org.fornever.koala.types.annotations.LocalProcessor;
import org.fornever.koala.types.annotations.RemoteProcessor;

public class KoalaProcessors<T, K, S> implements IKoalaProcessors<T, K, S> {

	private IRetriveEntityProcessor<T> localRetreiveProcessor;
	private IRetriveEntityProcessor<T> remoteRetrieveProcessor;
	private IReadEntityProcessor<T, S> localReadProcessor;
	private IReadEntityProcessor<T, S> remoteReadProcessor;
	private ISaveEntityProcessor<T> localSaveProcessor;
	private ISaveEntityProcessor<T> remoteSaveProcessor;
	private IUpdateEntityProcessor<T, K> localUpdateProcessor;
	private IUpdateEntityProcessor<T, K> remoteUpdateProcessor;
	private IDeleteEntityProcessor<K> localDeleteProcessor;
	private IDeleteEntityProcessor<K> remoteDeleteProcessor;
	private AEntityValidator<T> localValidator;
	private AEntityValidator<T> remoteValidator;
	private IKoalaKeyAccessor<T, K> keyAccessor;
	private IKoalaInstanceSelector<T> persistSelector;
	private IFinallyFailedNotifier<T> finallyFailedNotifier;
	private AKoalaReferenceUpdater<K> referenceUpdator;

	@Override
	public IRetriveEntityProcessor<T> getLocalRetrieveProcessor() {
		return localRetreiveProcessor;
	}

	@Inject
	public KoalaProcessors<T, K, S> setLocalRetreiveProcessor(
			@LocalProcessor IRetriveEntityProcessor<T> localRetreiveProcessor
	) {
		this.localRetreiveProcessor = localRetreiveProcessor;
		return this;
	}

	@Override
	public IRetriveEntityProcessor<T> getRemoteRetrieveProcessor() {
		return remoteRetrieveProcessor;
	}

	@Inject
	public KoalaProcessors<T, K, S> setRemoteRetrieveProcessor(
			@RemoteProcessor IRetriveEntityProcessor<T> remoteRetrieveProcessor
	) {
		this.remoteRetrieveProcessor = remoteRetrieveProcessor;
		return this;
	}

	@Override
	public IReadEntityProcessor<T, S> getLocalReadProcessor() {
		return localReadProcessor;
	}

	@Inject
	public KoalaProcessors<T, K, S> setLocalReadProcessor(
			@LocalProcessor IReadEntityProcessor<T, S> localReadProcessor
	) {
		this.localReadProcessor = localReadProcessor;
		return this;
	}

	@Override
	public IReadEntityProcessor<T, S> getRemoteReadProcessor() {
		return remoteReadProcessor;
	}

	@Inject
	public KoalaProcessors<T, K, S> setRemoteReadProcessor(
			@RemoteProcessor IReadEntityProcessor<T, S> remoteReadProcessor
	) {
		this.remoteReadProcessor = remoteReadProcessor;
		return this;
	}

	@Override
	public ISaveEntityProcessor<T> getLocalSaveProcessor() {
		return localSaveProcessor;
	}

	@Inject
	public KoalaProcessors<T, K, S> setLocalSaveProcessor(
			@LocalProcessor ISaveEntityProcessor<T> localSaveProcessor
	) {
		this.localSaveProcessor = localSaveProcessor;
		return this;
	}

	@Override
	public ISaveEntityProcessor<T> getRemoteSaveProcessor() {
		return remoteSaveProcessor;
	}

	@Inject
	public KoalaProcessors<T, K, S> setRemoteSaveProcessor(
			@RemoteProcessor ISaveEntityProcessor<T> remoteSaveProcessor
	) {
		this.remoteSaveProcessor = remoteSaveProcessor;
		return this;
	}

	@Override
	public IUpdateEntityProcessor<T, K> getLocalUpdateProcessor() {
		return localUpdateProcessor;
	}

	@Inject
	public KoalaProcessors<T, K, S> setLocalUpdateProcessor(
			@LocalProcessor IUpdateEntityProcessor<T, K> localUpdateProcessor
	) {
		this.localUpdateProcessor = localUpdateProcessor;
		return this;
	}

	@Override
	public IUpdateEntityProcessor<T, K> getRemoteUpdateProcessor() {
		return remoteUpdateProcessor;
	}

	@Inject
	public KoalaProcessors<T, K, S> setRemoteUpdateProcessor(
			@RemoteProcessor IUpdateEntityProcessor<T, K> remoteUpdateProcessor
	) {
		this.remoteUpdateProcessor = remoteUpdateProcessor;
		return this;
	}

	@Override
	public IDeleteEntityProcessor<K> getLocalDeleteProcessor() {
		return localDeleteProcessor;
	}

	@Inject
	public KoalaProcessors<T, K, S> setLocalDeleteProcessor(
			@LocalProcessor IDeleteEntityProcessor<K> localDeleteProcessor
	) {
		this.localDeleteProcessor = localDeleteProcessor;
		return this;
	}

	@Override
	public IDeleteEntityProcessor<K> getRemoteDeleteProcessor() {
		return remoteDeleteProcessor;
	}

	@Inject
	public KoalaProcessors<T, K, S> setRemoteDeleteProcessor(
			@RemoteProcessor IDeleteEntityProcessor<K> remoteDeleteProcessor
	) {
		this.remoteDeleteProcessor = remoteDeleteProcessor;
		return this;
	}

	@Override
	public AEntityValidator<T> getLocalValidator() {
		return localValidator;
	}

	@Inject
	public KoalaProcessors<T, K, S> setLocalValidator(
			@LocalProcessor AEntityValidator<T> localValidator
	) {
		this.localValidator = localValidator;
		return this;
	}

	@Override
	public AEntityValidator<T> getRemoteValidator() {
		return remoteValidator;
	}

	@Inject
	public KoalaProcessors<T, K, S> setRemoteValidator(
			@RemoteProcessor AEntityValidator<T> remoteValidator
	) {
		this.remoteValidator = remoteValidator;
		return this;
	}

	@Override
	public IKoalaKeyAccessor<T, K> getKeyAccessor() {
		return keyAccessor;
	}

	@Inject
	public KoalaProcessors<T, K, S> setKeyAccessor(IKoalaKeyAccessor<T, K> keyAccessor) {
		this.keyAccessor = keyAccessor;
		return this;
	}

	@Override
	public IKoalaInstanceSelector<T> getPersistSelector() {
		return persistSelector;
	}

	@Inject
	public KoalaProcessors<T, K, S> setPersistSelector(IKoalaInstanceSelector<T> persistSelector) {
		this.persistSelector = persistSelector;
		return this;
	}

	@Override
	public IFinallyFailedNotifier<T> getFinallyFailedNotifier() {
		return finallyFailedNotifier;
	}

	@Inject
	public KoalaProcessors<T, K, S> setFinallyFailedNotifier(IFinallyFailedNotifier<T> finallyFailedNotifier) {
		this.finallyFailedNotifier = finallyFailedNotifier;
		return this;
	}

	@Override
	public AKoalaReferenceUpdater<K> getReferenceUpdator() {
		return referenceUpdator;
	}

	@Inject
	public KoalaProcessors<T, K, S> setReferenceUpdator(AKoalaReferenceUpdater<K> referenceUpdator) {
		this.referenceUpdator = referenceUpdator;
		return this;
	}

}
