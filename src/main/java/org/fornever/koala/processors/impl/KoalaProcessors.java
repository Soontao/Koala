package org.fornever.koala.processors.impl;


import org.fornever.koala.entities.KoalaEntity;
import org.fornever.koala.entities.ValidationError;
import org.fornever.koala.exceptions.KoalaInstanceConfigurationException;
import org.fornever.koala.exceptions.NotImplementationException;
import org.fornever.koala.processors.entity.*;
import org.fornever.koala.processors.koala.*;

import java.util.logging.Level;
import java.util.logging.Logger;

public class KoalaProcessors<T, S> {

    protected IKoalaInstanceSelector<T> persistSelector;
    protected IRetriveEntityProcessor<T> retriveProcessor;
    protected IReadEntityProcessor<T, S> readProcessor;
    protected ISaveEntityProcessor<T> saveProcessor;
    protected IUpdateEntityProcessor<T> updateProcessor;
    protected IDeleteEntityProcessor deleteProcessor = key -> {
        throw new NotImplementationException();
    };
    protected IRetriveEntityProcessor<T> remoteRetriveProcessor;
    protected IReadEntityProcessor<T, S> remoteReadProcessor;
    protected ISaveEntityProcessor<T> remoteSaveProcessor;
    protected IUpdateEntityProcessor<T> remoteUpdateProcessor = (entity) -> {
        throw new NotImplementationException();
    };
    protected IDeleteEntityProcessor remoteDeleteProcessor = key -> {
        throw new NotImplementationException();
    };

    protected IKoalaKeyAccessor<T> keyAccessor;

    protected IEntityValidator<T> localIDValidator = e -> {
        throw new NotImplementationException();
    };

    protected IEntityValidator<T> remoteIDValidator = e -> {
        throw new NotImplementationException();
    };

    protected IKoalaReferenceUpdator<T> referenceUpdator;

    protected IEntityValidator<T> validator = e -> {
        return new ValidationError();
    };


    private Logger logger = Logger.getLogger(this.getClass().getName());

    protected IFinallyFailedNotifier finallySaveFailedToRemoteProcessor = ex -> {
        this.logger.log(Level.WARNING, String.format("Entity %d save to remote finally", ex.getEntity().getKoalaID()));
    };

    private KoalaProcessors() {
    }

    public static <T1 extends KoalaEntity, S1> KoalaProcessors<T1, S1> New() {
        return new KoalaProcessors<>();
    }

    public IKoalaInstanceSelector<T> getPersistSelector() {
        return persistSelector;
    }

    public KoalaProcessors<T, S> setPersistSelector(IKoalaInstanceSelector<T> persistSelector) {
        this.persistSelector = persistSelector;
        return this;
    }

    public IKoalaKeyAccessor<T> getKeyAccessor() {
        return keyAccessor;
    }

    public KoalaProcessors<T, S> setKeyAccessor(IKoalaKeyAccessor<T> keyAccessor) {
        this.keyAccessor = keyAccessor;
        return this;
    }

    public IKoalaReferenceUpdator<T> getReferenceUpdator() {
        return referenceUpdator;
    }

    public KoalaProcessors<T, S> setReferenceUpdator(IKoalaReferenceUpdator<T> referenceUpdator) {
        this.referenceUpdator = referenceUpdator;
        return this;
    }

    public IRetriveEntityProcessor<T> getRetriveProcessor() {
        return retriveProcessor;
    }

    public KoalaProcessors<T, S> setRetriveProcessor(IRetriveEntityProcessor<T> retriveProcessor) {
        this.retriveProcessor = retriveProcessor;
        return this;
    }

    public IEntityValidator<T> getValidator() {
        return validator;
    }

    public KoalaProcessors<T, S> setValidator(IEntityValidator<T> validator) {
        this.validator = validator;
        return this;
    }

    public IReadEntityProcessor<T, S> getReadProcessor() {
        return readProcessor;
    }

    public KoalaProcessors<T, S> setReadProcessor(IReadEntityProcessor<T, S> readProcessor) {
        this.readProcessor = readProcessor;
        return this;
    }

    public ISaveEntityProcessor<T> getSaveProcessor() {
        return saveProcessor;
    }

    public KoalaProcessors<T, S> setSaveProcessor(ISaveEntityProcessor<T> saveProcessor) {
        this.saveProcessor = saveProcessor;
        return this;
    }

    public IUpdateEntityProcessor<T> getUpdateProcessor() {
        return updateProcessor;
    }

    public KoalaProcessors<T, S> setUpdateProcessor(IUpdateEntityProcessor<T> updateProcessor) {
        this.updateProcessor = updateProcessor;
        return this;
    }

    public IDeleteEntityProcessor getDeleteProcessor() {
        return deleteProcessor;
    }

    public KoalaProcessors<T, S> setDeleteProcessor(IDeleteEntityProcessor deleteProcessor) {
        this.deleteProcessor = deleteProcessor;
        return this;
    }

    public IRetriveEntityProcessor<T> getRemoteRetriveProcessor() {
        return remoteRetriveProcessor;
    }

    public KoalaProcessors<T, S> setRemoteRetriveProcessor(IRetriveEntityProcessor<T> remoteRetriveProcessor) {
        this.remoteRetriveProcessor = remoteRetriveProcessor;
        return this;
    }

    public IReadEntityProcessor<T, S> getRemoteReadProcessor() {
        return remoteReadProcessor;
    }

    public KoalaProcessors<T, S> setRemoteReadProcessor(IReadEntityProcessor<T, S> remoteReadProcessor) {
        this.remoteReadProcessor = remoteReadProcessor;
        return this;
    }

    public ISaveEntityProcessor<T> getRemoteSaveProcessor() {
        return remoteSaveProcessor;
    }

    public KoalaProcessors<T, S> setRemoteSaveProcessor(ISaveEntityProcessor<T> remoteSaveProcessor) {
        this.remoteSaveProcessor = remoteSaveProcessor;
        return this;
    }

    public IUpdateEntityProcessor<T> getRemoteUpdateProcessor() {
        return remoteUpdateProcessor;
    }

    public KoalaProcessors<T, S> setRemoteUpdateProcessor(IUpdateEntityProcessor<T> remoteUpdateProcessor) {
        this.remoteUpdateProcessor = remoteUpdateProcessor;
        return this;
    }

    public IDeleteEntityProcessor getRemoteDeleteProcessor() {
        return remoteDeleteProcessor;
    }

    public KoalaProcessors<T, S> setRemoteDeleteProcessor(IDeleteEntityProcessor remoteDeleteProcessor) {
        this.remoteDeleteProcessor = remoteDeleteProcessor;
        return this;
    }

    public IFinallyFailedNotifier getFinallySaveFailedToRemoteProcessor() {
        return finallySaveFailedToRemoteProcessor;
    }

    public KoalaProcessors<T, S> setFinallySaveFailedToRemoteProcessor(IFinallyFailedNotifier finallySaveFailedToRemoteProcessor) {
        this.finallySaveFailedToRemoteProcessor = finallySaveFailedToRemoteProcessor;
        return this;
    }


    /**
     * check this koala instance can do basis data transfer
     *
     * @throws KoalaInstanceConfigurationException
     */
    public void checkKoalaInstanceWork() throws KoalaInstanceConfigurationException {
        if (this.readProcessor == null) {
            throw new KoalaInstanceConfigurationException("You must set read processors");
        }
        if (this.retriveProcessor == null) {
            throw new KoalaInstanceConfigurationException("You must set retrive processors");
        }
        if (this.persistSelector == null) {
            throw new KoalaInstanceConfigurationException("You must set persist selector");
        }
        if (this.saveProcessor == null) {
            throw new KoalaInstanceConfigurationException("You must set save processors");
        }
        if (this.updateProcessor == null) {
            throw new KoalaInstanceConfigurationException("You must set update processors");
        }
        if (this.remoteReadProcessor == null) {
            throw new KoalaInstanceConfigurationException("You must set remote read processors");
        }
        if (this.remoteRetriveProcessor == null) {
            throw new KoalaInstanceConfigurationException("You must set remote retrive processors");
        }
        if (this.remoteSaveProcessor == null) {
            throw new KoalaInstanceConfigurationException("You must set remote save processors");
        }
    }


}
