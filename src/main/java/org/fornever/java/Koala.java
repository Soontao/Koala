package org.fornever.java;

import org.fornever.java.entity.KoalaBaseEntity;
import org.fornever.java.errors.KoalaInstanceNotConfigurationCorrectException;
import org.fornever.java.errors.SaveFailedException;
import org.fornever.java.processor.KoalaProcessors;
import org.fornever.java.schedule.IScheduleRunner;
import org.fornever.java.schedule.impl.ScheduleRunner;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * Koala Entity Processor
 *
 * @param <T> Entity Type
 * @param <S> Search Prarameter Type
 * @author Theo Sun
 */
public class Koala<T extends KoalaBaseEntity, S> {

    private Logger logger = Logger.getLogger(getClass().getName());

    /**
     * schedule
     */
    private ScheduledExecutorService scheduler;
    /**
     * The maximum count of retry after persist on remote system
     */
    private Integer maxRetryCount = 0;
    /**
     * Date of the recent record created
     */

    private Date recentCreateRecordDate;
    /**
     * Transactions Per Second on remote system
     */
    private Integer remoteTPS = 10;

    private IScheduleRunner<T, S> scheduleRunner = ScheduleRunner.DefaultRunner;

    private KoalaProcessors<T, S> processors;

    private Koala() {
        this.scheduler = Executors.newScheduledThreadPool(this.remoteTPS);
    }

    public static <T1 extends KoalaBaseEntity, S1> Koala<T1, S1> New(KoalaProcessors<T1, S1> processors) {
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

    public Koala setMaxRetryCount(Integer maxRetryCount) {
        this.maxRetryCount = maxRetryCount;
        return this;
    }

    public Koala setRecentCreateRecordDate(Date recentCreateRecordDate) {
        this.recentCreateRecordDate = recentCreateRecordDate;
        return this;
    }

    public Koala setRemoteTPS(Integer remoteTPS) {
        this.remoteTPS = remoteTPS;
        this.scheduler = Executors.newScheduledThreadPool(this.remoteTPS);
        return this;
    }

    public T save(T entity) throws SaveFailedException {
        return this.processors.getSaveProcessor().save(entity);
    }

    /**
     * start work
     */
    public void start() throws KoalaInstanceNotConfigurationCorrectException {
        this.processors.checkKoalaInstanceWork();
        if (this.scheduler != null) {
            this.scheduler.schedule(() -> {
                this.scheduleRunner.run(this.processors, this.maxRetryCount);
            }, 1, TimeUnit.SECONDS);
        }
    }

    /**
     * stop work
     */
    public void stop() {
        if (this.scheduler != null) {
            this.scheduler.shutdown();
        }
    }

}
