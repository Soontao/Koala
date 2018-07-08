package org.fornever.koala.schedule.abs;

import com.google.inject.Inject;
import org.fornever.koala.processors.IKoalaProcessors;
import org.fornever.koala.schedule.IScheduleRunner;
import org.fornever.koala.schedule.ITaskQueue;

public abstract class AScheduleRunner implements IScheduleRunner {

	private ITaskQueue taskQueue;

	private IKoalaProcessors processors;

	@Inject
	public AScheduleRunner setTaskQueue(ITaskQueue taskQueue) {
		this.taskQueue = taskQueue;
		return this;
	}

	@Inject
	public AScheduleRunner setProcessors(IKoalaProcessors processors) {
		this.processors = processors;
		return this;
	}

}
