package org.fornever.java.schedule;

import org.fornever.java.entity.KoalaBaseEntity;
import org.fornever.java.processor.AKoalaProcessors;

public interface IScheduleRunner<T extends KoalaBaseEntity, S> {

    void run(AKoalaProcessors<T, S> processor, Integer maxRetryCount);

}
