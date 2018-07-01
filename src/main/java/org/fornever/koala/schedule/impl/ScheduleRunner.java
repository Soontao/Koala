package org.fornever.koala.schedule.impl;

import org.fornever.koala.entities.KoalaEntity;
import org.fornever.koala.schedule.IScheduleRunner;

import java.util.logging.Logger;

public class ScheduleRunner {

    private static Logger logger = Logger.getLogger(ScheduleRunner.class.getName());

    public static IScheduleRunner DefaultRunner = (processor, maxRetryCount) -> {
        KoalaEntity entity = processor.getPersistSelector().select(maxRetryCount);
        processor.getSaveProcessor().save(entity);
    };

}
