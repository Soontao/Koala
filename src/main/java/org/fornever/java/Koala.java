package org.fornever.java;

import org.fornever.java.entities.KoalaConfig;
import org.fornever.java.entities.KoalaEntity;
import org.fornever.java.exceptions.KoalaInstanceNotConfigurationCorrectException;
import org.fornever.java.exceptions.WriteFailedException;
import org.fornever.java.processors.KoalaProcessors;
import org.fornever.java.schedule.IScheduleRunner;
import org.fornever.java.schedule.impl.ScheduleRunner;

import java.util.concurrent.ScheduledExecutorService;
import java.util.logging.Logger;

/**
 * Koala
 *
 * @param <T> Entity Type
 * @param <S> Search Prarameter Type
 * @author Theo Sun
 */
public class Koala<T extends KoalaEntity, S> {

    private Logger logger = Logger.getLogger(getClass().getName());

    /**
     * schedule
     */
    private ScheduledExecutorService scheduler;

    private KoalaConfig config = new KoalaConfig();

    private IScheduleRunner<T, S> scheduleRunner = ScheduleRunner.DefaultRunner;

    private KoalaProcessors<T, S> processors;

    private Koala() {
    }

    public static <T1 extends KoalaEntity, S1> Koala<T1, S1> New(KoalaProcessors<T1, S1> processors) {
        return new Koala<T1, S1>().setProcessors(processors);
    }

    public Koala<T, S> setScheduleRunner(IScheduleRunner<T, S> scheduleRunner) {
        this.scheduleRunner = scheduleRunner;
        return this;
    }

    public Koala<T, S> setProcessors(KoalaProcessors<T, S> processors) {
        this.processors = processors;
        return this;
    }

    public void notifyUpdate(Long id) {

    }

    public T save(T entity) throws WriteFailedException {
        return this.processors.getSaveProcessor().save(entity);
    }

    /**
     * start sync
     */
    public void start() throws KoalaInstanceNotConfigurationCorrectException {
        this.processors.checkKoalaInstanceWork();
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
