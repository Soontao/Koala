package org.fornever.java.schedule;

import org.fornever.java.entity.KoalaBaseEntity;
import org.fornever.java.processor.KoalaProcessors;

public interface IScheduleRunner<T extends KoalaBaseEntity, S> {

    void run(KoalaProcessors<T, S> processor, Integer maxRetryCount);

}
