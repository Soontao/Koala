package org.fornever.koala.processors;


import org.fornever.koala.entities.KoalaEntity;
import org.fornever.koala.exceptions.KoalaInstanceNotConfigurationCorrectException;
import org.fornever.koala.exceptions.NotImplementationException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class KoalaProcessors<T extends KoalaEntity, S> {

    protected IKoalaPersistSelector<T> persistSelector;
    protected IRetriveEntityIKoalaProcessor<T> retriveProcessor;
    protected IReadEntityIKoalaProcessor<T, S> readProcessor;
    protected ISaveEntityIKoalaProcessor<T> saveProcessor;
    protected IUpdateEntityIKoalaProcessor<T> updateProcessor;
    protected IDeleteEntityIKoalaProcessor deleteProcessor = key -> {
        throw new NotImplementationException();
    };
    protected IRetriveEntityIKoalaProcessor<T> remoteRetriveProcessor;
    protected IReadEntityIKoalaProcessor<T, S> remoteReadProcessor;
    protected ISaveEntityIKoalaProcessor<T> remoteSaveProcessor;
    protected IUpdateEntityIKoalaProcessor<T> remoteUpdateProcessor = (k, entity) -> {
        throw new NotImplementationException();
    };
    protected IDeleteEntityIKoalaProcessor remoteDeleteProcessor = key -> {
        throw new NotImplementationException();
    };
    private Logger logger = Logger.getLogger(this.getClass().getName());
    protected IFinallySaveFailedToRemoteIKoalaProcessor finallySaveFailedToRemoteProcessor = ex -> {
        this.logger.log(Level.WARNING, String.format("Entity %d save to remote finally", ex.getEntity().getKoalaID()));
    };

    private KoalaProcessors() {
    }

    public static <T1 extends KoalaEntity, S1> KoalaProcessors<T1, S1> New() {
        return new KoalaProcessors<>();
    }

    public IKoalaPersistSelector<T> getPersistSelector() {
        return persistSelector;
    }

    public KoalaProcessors<T, S> setPersistSelector(IKoalaPersistSelector<T> persistSelector) {
        this.persistSelector = persistSelector;
        return this;
    }

    public IRetriveEntityIKoalaProcessor<T> getRetriveProcessor() {
        return retriveProcessor;
    }

    public KoalaProcessors<T, S> setRetriveProcessor(IRetriveEntityIKoalaProcessor<T> retriveProcessor) {
        this.retriveProcessor = retriveProcessor;
        return this;
    }

    public IReadEntityIKoalaProcessor<T, S> getReadProcessor() {
        return readProcessor;
    }

    public KoalaProcessors<T, S> setReadProcessor(IReadEntityIKoalaProcessor<T, S> readProcessor) {
        this.readProcessor = readProcessor;
        return this;
    }

    public ISaveEntityIKoalaProcessor<T> getSaveProcessor() {
        return saveProcessor;
    }

    public KoalaProcessors<T, S> setSaveProcessor(ISaveEntityIKoalaProcessor<T> saveProcessor) {
        this.saveProcessor = saveProcessor;
        return this;
    }

    public IUpdateEntityIKoalaProcessor<T> getUpdateProcessor() {
        return updateProcessor;
    }

    public KoalaProcessors<T, S> setUpdateProcessor(IUpdateEntityIKoalaProcessor<T> updateProcessor) {
        this.updateProcessor = updateProcessor;
        return this;
    }

    public IDeleteEntityIKoalaProcessor getDeleteProcessor() {
        return deleteProcessor;
    }

    public KoalaProcessors<T, S> setDeleteProcessor(IDeleteEntityIKoalaProcessor deleteProcessor) {
        this.deleteProcessor = deleteProcessor;
        return this;
    }

    public IRetriveEntityIKoalaProcessor<T> getRemoteRetriveProcessor() {
        return remoteRetriveProcessor;
    }

    public KoalaProcessors<T, S> setRemoteRetriveProcessor(IRetriveEntityIKoalaProcessor<T> remoteRetriveProcessor) {
        this.remoteRetriveProcessor = remoteRetriveProcessor;
        return this;
    }

    public IReadEntityIKoalaProcessor<T, S> getRemoteReadProcessor() {
        return remoteReadProcessor;
    }

    public KoalaProcessors<T, S> setRemoteReadProcessor(IReadEntityIKoalaProcessor<T, S> remoteReadProcessor) {
        this.remoteReadProcessor = remoteReadProcessor;
        return this;
    }

    public ISaveEntityIKoalaProcessor<T> getRemoteSaveProcessor() {
        return remoteSaveProcessor;
    }

    public KoalaProcessors<T, S> setRemoteSaveProcessor(ISaveEntityIKoalaProcessor<T> remoteSaveProcessor) {
        this.remoteSaveProcessor = remoteSaveProcessor;
        return this;
    }

    public IUpdateEntityIKoalaProcessor<T> getRemoteUpdateProcessor() {
        return remoteUpdateProcessor;
    }

    public KoalaProcessors<T, S> setRemoteUpdateProcessor(IUpdateEntityIKoalaProcessor<T> remoteUpdateProcessor) {
        this.remoteUpdateProcessor = remoteUpdateProcessor;
        return this;
    }

    public IDeleteEntityIKoalaProcessor getRemoteDeleteProcessor() {
        return remoteDeleteProcessor;
    }

    public KoalaProcessors<T, S> setRemoteDeleteProcessor(IDeleteEntityIKoalaProcessor remoteDeleteProcessor) {
        this.remoteDeleteProcessor = remoteDeleteProcessor;
        return this;
    }

    public IFinallySaveFailedToRemoteIKoalaProcessor getFinallySaveFailedToRemoteProcessor() {
        return finallySaveFailedToRemoteProcessor;
    }

    public KoalaProcessors<T, S> setFinallySaveFailedToRemoteProcessor(IFinallySaveFailedToRemoteIKoalaProcessor finallySaveFailedToRemoteProcessor) {
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
            throw new KoalaInstanceNotConfigurationCorrectException("You must set read processors");
        }
        if (this.retriveProcessor == null) {
            throw new KoalaInstanceNotConfigurationCorrectException("You must set retrive processors");
        }
        if (this.persistSelector == null) {
            throw new KoalaInstanceNotConfigurationCorrectException("You must set persist selector");
        }
        if (this.saveProcessor == null) {
            throw new KoalaInstanceNotConfigurationCorrectException("You must set save processors");
        }
        if (this.updateProcessor == null) {
            throw new KoalaInstanceNotConfigurationCorrectException("You must set update processors");
        }
        if (this.remoteReadProcessor == null) {
            throw new KoalaInstanceNotConfigurationCorrectException("You must set remote read processors");
        }
        if (this.remoteRetriveProcessor == null) {
            throw new KoalaInstanceNotConfigurationCorrectException("You must set remote retrive processors");
        }
        if (this.remoteSaveProcessor == null) {
            throw new KoalaInstanceNotConfigurationCorrectException("You must set remote save processors");
        }
    }


}
