package org.fornever.java;

import org.fornever.java.entity.KoalaBaseEntity;
import org.fornever.java.errors.KoalaInstanceNotConfigurationCorrectException;
import org.fornever.java.errors.SaveFailedException;
import org.fornever.java.processor.AKoalaProcessors;
import org.fornever.java.schedule.impl.ScheduleRunner;
import org.fornever.java.schedule.IScheduleRunner;

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
public class Koala<T extends KoalaBaseEntity, S> extends AKoalaProcessors<T, S> {

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

    private IScheduleRunner<T,S> scheduleRunner = ScheduleRunner.DefaultRunner;

    public Koala() {
        this.scheduler = Executors.newScheduledThreadPool(this.remoteTPS);
    }

    public static <T1 extends KoalaBaseEntity, S1> Koala<T1, S1> New() {
        return new Koala<T1, S1>();
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
        return this.saveProcessor.save(entity);
    }

    /**
     * start work
     */
    public void start() throws KoalaInstanceNotConfigurationCorrectException {
        checkKoalaInstanceWork();
        if (this.scheduler != null) {
            this.scheduler.schedule(() -> {
                ScheduleRunner.DefaultRunner.run(this, this.maxRetryCount);
            }, 1, TimeUnit.SECONDS);
        }
    }

    /**
     * check this koala instance can do basis data transfer
     *
     * @throws KoalaInstanceNotConfigurationCorrectException
     */
    private void checkKoalaInstanceWork() throws KoalaInstanceNotConfigurationCorrectException {
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

    /**
     * stop work
     */
    public void stop() {
        if (this.scheduler != null) {
            this.scheduler.shutdown();
        }
    }

}
