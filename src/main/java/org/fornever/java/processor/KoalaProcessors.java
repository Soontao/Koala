package org.fornever.java.processor;


import org.fornever.java.entity.KoalaBaseEntity;
import org.fornever.java.errors.KoalaInstanceNotConfigurationCorrectException;
import org.fornever.java.errors.NotImplementationException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class KoalaProcessors<T extends KoalaBaseEntity, S> {

    protected IPersistSelector<T> persistSelector;
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

    private KoalaProcessors() {
    }

    public static <T1 extends KoalaBaseEntity, S1> KoalaProcessors<T1, S1> New() {
        return new KoalaProcessors<>();
    }

    public IPersistSelector<T> getPersistSelector() {
        return persistSelector;
    }

    public KoalaProcessors<T, S> setPersistSelector(IPersistSelector<T> persistSelector) {
        this.persistSelector = persistSelector;
        return this;
    }

    public IRetriveEntityProcessor<T> getRetriveProcessor() {
        return retriveProcessor;
    }

    public KoalaProcessors<T, S> setRetriveProcessor(IRetriveEntityProcessor<T> retriveProcessor) {
        this.retriveProcessor = retriveProcessor;
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

    public IFinallySaveFailedToRemoteProcessor getFinallySaveFailedToRemoteProcessor() {
        return finallySaveFailedToRemoteProcessor;
    }

    public KoalaProcessors<T, S> setFinallySaveFailedToRemoteProcessor(IFinallySaveFailedToRemoteProcessor finallySaveFailedToRemoteProcessor) {
        this.finallySaveFailedToRemoteProcessor = finallySaveFailedToRemoteProcessor;
        return this;
    }


    /**
     * check this koala instance can do basis data transfer
     *
     * @throws KoalaInstanceNotConfigurationCorrectException
     */
    public void checkKoalaInstanceWork() throws KoalaInstanceNotConfigurationCorrectException {
        if (this.readProcessor == null) {
            throw new KoalaInstanceNotConfigurationCorrectException("You must set read processor");
        }
        if (this.retriveProcessor == null) {
            throw new KoalaInstanceNotConfigurationCorrectException("You must set retrive processor");
        }
        if (this.persistSelector == null) {
            throw new KoalaInstanceNotConfigurationCorrectException("You must set persist selector");
        }
        if (this.saveProcessor == null) {
            throw new KoalaInstanceNotConfigurationCorrectException("You must set save processor");
        }
        if (this.updateProcessor == null) {
            throw new KoalaInstanceNotConfigurationCorrectException("You must set update processor");
        }
        if (this.remoteReadProcessor == null) {
            throw new KoalaInstanceNotConfigurationCorrectException("You must set remove read processor");
        }
        if (this.remoteRetriveProcessor == null) {
            throw new KoalaInstanceNotConfigurationCorrectException("You must set remove retrive processor");
        }
        if (this.remoteSaveProcessor == null) {
            throw new KoalaInstanceNotConfigurationCorrectException("You must set remove save processor");
        }
    }


}
