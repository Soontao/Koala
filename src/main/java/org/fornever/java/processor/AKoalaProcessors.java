package org.fornever.java.processor;


import org.fornever.java.entity.KoalaBaseEntity;
import org.fornever.java.errors.NotImplementationException;

import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AKoalaProcessors<T extends KoalaBaseEntity, S> {

    protected IPesistSelector<T> persistSelector;
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
    protected IUpdateEntityProcessor<T> remoteUpdateProcessor = (k, entity) -> {
        throw new NotImplementationException();
    };
    protected IDeleteEntityProcessor remoteDeleteProcessor = key -> {
        throw new NotImplementationException();
    };
    private Logger logger = Logger.getLogger(this.getClass().getName());
    protected IFinallySaveFailedToRemoteProcessor finallySaveFailedToRemoteProcessor = entity -> {
        this.logger.log(Level.WARNING, String.format("Entity %d save to remote finally", entity.getKoalaID()));
    };

    public IPesistSelector<T> getPersistSelector() {
        return persistSelector;
    }

    public AKoalaProcessors<T, S> setPersistSelector(IPesistSelector<T> persistSelector) {
        this.persistSelector = persistSelector;
        return this;
    }

    public IRetriveEntityProcessor<T> getRetriveProcessor() {
        return retriveProcessor;
    }

    public AKoalaProcessors<T, S> setRetriveProcessor(IRetriveEntityProcessor<T> retriveProcessor) {
        this.retriveProcessor = retriveProcessor;
        return this;
    }

    public IReadEntityProcessor<T, S> getReadProcessor() {
        return readProcessor;
    }

    public AKoalaProcessors<T, S> setReadProcessor(IReadEntityProcessor<T, S> readProcessor) {
        this.readProcessor = readProcessor;
        return this;
    }

    public ISaveEntityProcessor<T> getSaveProcessor() {
        return saveProcessor;
    }

    public AKoalaProcessors<T, S> setSaveProcessor(ISaveEntityProcessor<T> saveProcessor) {
        this.saveProcessor = saveProcessor;
        return this;
    }

    public IUpdateEntityProcessor<T> getUpdateProcessor() {
        return updateProcessor;
    }

    public AKoalaProcessors<T, S> setUpdateProcessor(IUpdateEntityProcessor<T> updateProcessor) {
        this.updateProcessor = updateProcessor;
        return this;
    }

    public IDeleteEntityProcessor getDeleteProcessor() {
        return deleteProcessor;
    }

    public AKoalaProcessors<T, S> setDeleteProcessor(IDeleteEntityProcessor deleteProcessor) {
        this.deleteProcessor = deleteProcessor;
        return this;
    }

    public IRetriveEntityProcessor<T> getRemoteRetriveProcessor() {
        return remoteRetriveProcessor;
    }

    public AKoalaProcessors<T, S> setRemoteRetriveProcessor(IRetriveEntityProcessor<T> remoteRetriveProcessor) {
        this.remoteRetriveProcessor = remoteRetriveProcessor;
        return this;
    }

    public IReadEntityProcessor<T, S> getRemoteReadProcessor() {
        return remoteReadProcessor;
    }

    public AKoalaProcessors<T, S> setRemoteReadProcessor(IReadEntityProcessor<T, S> remoteReadProcessor) {
        this.remoteReadProcessor = remoteReadProcessor;
        return this;
    }

    public ISaveEntityProcessor<T> getRemoteSaveProcessor() {
        return remoteSaveProcessor;
    }

    public AKoalaProcessors<T, S> setRemoteSaveProcessor(ISaveEntityProcessor<T> remoteSaveProcessor) {
        this.remoteSaveProcessor = remoteSaveProcessor;
        return this;
    }

    public IUpdateEntityProcessor<T> getRemoteUpdateProcessor() {
        return remoteUpdateProcessor;
    }

    public AKoalaProcessors<T, S> setRemoteUpdateProcessor(IUpdateEntityProcessor<T> remoteUpdateProcessor) {
        this.remoteUpdateProcessor = remoteUpdateProcessor;
        return this;
    }

    public IDeleteEntityProcessor getRemoteDeleteProcessor() {
        return remoteDeleteProcessor;
    }

    public AKoalaProcessors<T, S> setRemoteDeleteProcessor(IDeleteEntityProcessor remoteDeleteProcessor) {
        this.remoteDeleteProcessor = remoteDeleteProcessor;
        return this;
    }

    public IFinallySaveFailedToRemoteProcessor getFinallySaveFailedToRemoteProcessor() {
        return finallySaveFailedToRemoteProcessor;
    }

    public AKoalaProcessors<T, S> setFinallySaveFailedToRemoteProcessor(IFinallySaveFailedToRemoteProcessor finallySaveFailedToRemoteProcessor) {
        this.finallySaveFailedToRemoteProcessor = finallySaveFailedToRemoteProcessor;
        return this;
    }

}
