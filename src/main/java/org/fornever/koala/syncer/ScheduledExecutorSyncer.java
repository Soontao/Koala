package org.fornever.koala.syncer;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.fornever.koala.bindings.annotations.LocalDataSource;
import org.fornever.koala.bindings.annotations.RemoteDataSource;
import org.fornever.koala.blurprints.IDataSource;
import org.fornever.koala.blurprints.ISyncer;
import org.fornever.koala.type.SyncSnapshotData;

import com.google.inject.Inject;
import com.google.inject.name.Named;

public class ScheduledExecutorSyncer implements ISyncer {

	private ScheduledExecutorService service;

	private Queue<SyncSnapshotData> queue;

	@Inject
	@RemoteDataSource
	private IDataSource remoteDS;
	
	@Inject
	@LocalDataSource
	private IDataSource localDS;

	private Runnable sync = () -> {
		SyncSnapshotData data = this.queue.poll();
		if (data != null) {

			switch (data.getSyncDirection()) {
			case FROM_LOCAL_TO_REMOTE:
				switch (data.getSyncType()) {
				case CREATE:

					break;
				case UPDATE:

					break;
				case DELETE:

					break;
				default:
					break;
				}
				break;
			case FROM_REMOTE_TO_LOCAL:
				switch (data.getSyncType()) {
				case CREATE:

					break;
				case UPDATE:

					break;
				case DELETE:

					break;
				default:
					break;
				}
				break;
			default:
				break;
			}
		}
	};

	@Inject
	public ScheduledExecutorSyncer(@Named("ScheduledExecutorSyncer:poolSize") Integer poolSize,
			@Named("ScheduledExecutorSyncer:intervalSeconds") Integer intervalSeconds,
			@Named("datasource:local") IDataSource local, @Named("datasource:remote") IDataSource remote) {
		this.queue = new ConcurrentLinkedQueue<>();
		this.service = Executors.newScheduledThreadPool(poolSize);
		this.service.scheduleAtFixedRate(this.sync, 1, intervalSeconds, TimeUnit.SECONDS);
		this.localDS = local;
		this.remoteDS = remote;
	}

	@Override
	public void addToSyncQueue(SyncSnapshotData snapshot) {
		this.queue.add(snapshot);
	}

	public IDataSource getLocalDS() {
		return localDS;
	}

	public Queue<SyncSnapshotData> getQueue() {
		return queue;
	}

	public IDataSource getRemoteDS() {
		return remoteDS;
	}

	public ScheduledExecutorService getService() {
		return service;
	}

	public Runnable getSync() {
		return sync;
	}

	public void setLocalDS(IDataSource localDS) {
		this.localDS = localDS;
	}

	public void setQueue(Queue<SyncSnapshotData> queue) {
		this.queue = queue;
	}

	public void setRemoteDS(IDataSource remoteDS) {
		this.remoteDS = remoteDS;
	}

	public void setService(ScheduledExecutorService service) {
		this.service = service;
	}

	public void setSync(Runnable sync) {
		this.sync = sync;
	}

}
