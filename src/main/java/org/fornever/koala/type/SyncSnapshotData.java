package org.fornever.koala.type;

import org.fornever.koala.type.enums.SyncDirection;
import org.fornever.koala.type.enums.SyncType;

/**
 * sync queue data
 * 
 * <p>
 * 
 * snapshot data, save the change snapshot of data, used for sync data & data
 * rollback (on failure)
 * 
 * @author theosun
 *
 */
public class SyncSnapshotData {

	Object key;

	Row before;

	Row after;

	SyncType syncType;

	SyncDirection syncDirection;

	public SyncSnapshotData(Object key, Row before, Row after, SyncType syncType, SyncDirection syncDirection) {
		super();
		this.key = key;
		this.before = before;
		this.after = after;
		this.syncType = syncType;
		this.syncDirection = syncDirection;
	}

	public SyncType getSyncType() {
		return syncType;
	}

	public void setSyncType(SyncType syncType) {
		this.syncType = syncType;
	}

	public SyncDirection getSyncDirection() {
		return syncDirection;
	}

	public void setSyncDirection(SyncDirection syncDirection) {
		this.syncDirection = syncDirection;
	}

	public Object getKey() {
		return key;
	}

	public void setKey(Object key) {
		this.key = key;
	}

	public Row getBefore() {
		return before;
	}

	public void setBefore(Row before) {
		this.before = before;
	}

	public Row getAfter() {
		return after;
	}

	public void setAfter(Row after) {
		this.after = after;
	}

}
