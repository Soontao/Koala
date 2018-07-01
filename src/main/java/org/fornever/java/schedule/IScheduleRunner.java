package org.fornever.java.schedule;

import org.fornever.java.entities.KoalaEntity;
import org.fornever.java.processors.KoalaProcessors;

public interface IScheduleRunner<T extends KoalaEntity, S> {

    void run(KoalaProcessors<T, S> processor, Integer maxRetryCount);

}
