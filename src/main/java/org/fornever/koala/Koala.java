package org.fornever.koala;

import org.fornever.koala.entities.KoalaConfig;
import org.fornever.koala.entities.KoalaEntity;
import org.fornever.koala.entities.KoalaReferenceEntity;
import org.fornever.koala.entities.ValidationError;
import org.fornever.koala.entities.enums.EKoalaInstanceState;
import org.fornever.koala.exceptions.KoalaInstanceConfigurationException;
import org.fornever.koala.exceptions.NotImplementationException;
import org.fornever.koala.exceptions.ValidationException;
import org.fornever.koala.exceptions.WriteFailedException;
import org.fornever.koala.processors.IKoalaProcessors;
import org.fornever.koala.processors.impl.KoalaProcessors;
import org.fornever.koala.schedule.IScheduleRunner;

import java.util.Date;
import java.util.concurrent.ScheduledExecutorService;
import java.util.logging.Logger;

/**
 * Koala
 *
 * @param <T> Entity Type
 * @param <S> Search Prarameter Type
 * @author Theo Sun
 */
public class Koala<T, S> {

    private Logger logger = Logger.getLogger(getClass().getName());

    /**
     * schedule
     */
    private ScheduledExecutorService scheduler;

    private KoalaConfig config = new KoalaConfig();

    private IScheduleRunner<T, S> scheduleRunner;

    private IKoalaProcessors<T, S> processors;

    private Koala() {
    }

    public static <T1 extends KoalaEntity, S1> Koala<T1, S1> New(IKoalaProcessors<T1, S1> processors) {
        return new Koala<T1, S1>().setProcessors(processors);
    }

    public Koala<T, S> setScheduleRunner(IScheduleRunner<T, S> scheduleRunner) {
        this.scheduleRunner = scheduleRunner;
        return this;
    }

    public Koala<T, S> setProcessors(IKoalaProcessors<T, S> processors) {
        this.processors = processors;
        return this;
    }

    public void notifyUpdate(Long id) {

    }

    public T save(T entity) throws WriteFailedException, NotImplementationException, ValidationException {
        ValidationError errors = this.processors.getLocalValidator().validation(entity);
        if (errors.haveError.get()) {
            throw new ValidationException().setErrors(errors);
        }
        KoalaReferenceEntity ref = new KoalaReferenceEntity()
                .setRefID(this.processors.getKeyAccessor().getKey(entity))
                .setRefEntityName(entity.getClass().getName())
                .setCreateAt(new Date())
                .setUpdateAt(new Date())
                .setState(EKoalaInstanceState.WILL_CREATE);
        this.processors.getReferenceUpdator().updateKoalaReference(null, ref);
        return this.processors.getLocalSaveProcessor().save(entity);
    }

    /**
     * start sync
     */
    public void start() throws KoalaInstanceConfigurationException {
        if (this.scheduler != null) {

        }
    }

    /**
     * stop sync
     */
    public void stop() {
        if (this.scheduler != null) {
            this.scheduler.shutdown();
        }
    }

}
