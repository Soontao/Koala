package org.fornever.koala;

import java.util.List;

import org.fornever.koala.blurprints.IDataSource;
import org.fornever.koala.blurprints.ISyncer;
import org.fornever.koala.blurprints.IValidator;
import org.fornever.koala.type.Row;
import org.fornever.koala.type.SearchParameter;
import org.fornever.koala.type.SyncSnapshotData;
import org.fornever.koala.type.enums.SyncDirection;
import org.fornever.koala.type.enums.SyncType;

import com.google.inject.Inject;
import com.google.inject.name.Named;

public class Koala implements IDataSource {

	@Inject
	@Named("datasource:local")
	private IDataSource localDS;

	@Inject
	@Named("datasource:remote")
	private IDataSource remoteDS;

	@Inject
	@Named("validator")
	private IValidator localValidator;

	@Inject
	@Named("syncer")
	private ISyncer syncer;

	public IDataSource getLocalDS() {
		return localDS;
	}

	public void setLocalDS(IDataSource localDS) {
		this.localDS = localDS;
	}

	public IDataSource getRemoteDS() {
		return remoteDS;
	}

	public void setRemoteDS(IDataSource remoteDS) {
		this.remoteDS = remoteDS;
	}

	public IValidator getLocalValidator() {
		return localValidator;
	}

	public void setLocalValidator(IValidator localValidator) {
		this.localValidator = localValidator;
	}

	@Override
	public Row create(Row row) throws Throwable {
		Row created_row = this.localDS.create(row);
		this.syncer.addToSyncQueue(
				new SyncSnapshotData(null, null, created_row, SyncType.CREATE, SyncDirection.FROM_LOCAL_TO_REMOTE));
		return created_row;
	}

	@Override
	public Boolean delete(Object key) throws Throwable {
		Row will_deleted = this.localDS.retrieve(key);

		Boolean deleted = this.localDS.delete(key);

		if (deleted) {
			this.syncer.addToSyncQueue(
					new SyncSnapshotData(key, will_deleted, null, SyncType.DELETE, SyncDirection.FROM_LOCAL_TO_REMOTE));
		}
		return deleted;
	}

	@Override
	public List<Row> find(SearchParameter param) throws Throwable {
		return this.localDS.find(param);
	}

	@Override
	public Row retrieve(Object key) throws Throwable {
		return this.localDS.retrieve(key);
	}

	@Override
	public Row update(Row row) throws Throwable {

		Object key = this.localDS.fromRowToKey(row);
		synchronized (key) { // synchronized by key rather than object
			Row not_updated = this.localDS.retrieve(key);
			Row updated = this.localDS.update(row);
			this.syncer.addToSyncQueue(new SyncSnapshotData(key, not_updated, updated, SyncType.UPDATE,
					SyncDirection.FROM_LOCAL_TO_REMOTE));
			return updated;
		}

	}

}
