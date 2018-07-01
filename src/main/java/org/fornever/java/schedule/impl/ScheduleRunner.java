package org.fornever.java.schedule.impl;

import org.fornever.java.entities.KoalaEntity;
import org.fornever.java.schedule.IScheduleRunner;

import java.util.logging.Logger;

public class ScheduleRunner {

    private static Logger logger = Logger.getLogger(ScheduleRunner.class.getName());

    public static IScheduleRunner DefaultRunner = (processor, maxRetryCount) -> {
        KoalaEntity entity = processor.getPersistSelector().select(maxRetryCount);
        processor.getSaveProcessor().save(entity);
    };

}
