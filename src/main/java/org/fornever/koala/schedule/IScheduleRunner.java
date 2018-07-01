package org.fornever.koala.schedule;

import org.fornever.koala.entities.KoalaEntity;
import org.fornever.koala.exceptions.WriteFailedException;
import org.fornever.koala.processors.KoalaProcessors;

public interface IScheduleRunner<T extends KoalaEntity, S> {

    void run(KoalaProcessors<T, S> processor, Integer maxRetryCount) throws WriteFailedException;

}
