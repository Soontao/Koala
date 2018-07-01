package org.fornever.java.schedule.impl;

import org.fornever.java.entities.KoalaEntity;
import org.fornever.java.schedule.IScheduleRunner;

import java.util.logging.Logger;

public class ScheduleRunner {

    private static Logger logger = Logger.getLogger(ScheduleRunner.class.getName());

    public static IScheduleRunner DefaultRunner = (processor, maxRetryCount) -> {
        KoalaEntity entity = processor.getPersistSelector().select(maxRetryCount);
        try {
            processor.getSaveProcessor().save(entity);
        } catch (SaveFailedException ex) {
            entity.setKoalaRetryCount(entity.getKoalaRetryCount() + 1);
            if (entity.getKoalaPersistRetryCount() > maxRetryCount) {
                processor.getFinallySaveFailedToRemoteProcessor().notify(entity);
                try {
                    processor.getUpdateProcessor().update(entity.getKoalaID(), entity);
                } catch (Exception e) {
                    logger.warning(e.getMessage());
                }
            } else {
                logger.info(String.format("Entity %d persist failed to remote, but Koala will retry", entity.getKoalaID()));
            }

        }
    };

}
