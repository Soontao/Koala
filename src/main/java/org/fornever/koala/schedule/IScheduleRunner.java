package org.fornever.koala.schedule;

import org.fornever.koala.exceptions.WriteFailedException;
import org.fornever.koala.processors.impl.KoalaProcessors;

public interface IScheduleRunner<T, S> {

    void run(KoalaProcessors<T, S> processor, Integer maxRetryCount) throws WriteFailedException;

}
