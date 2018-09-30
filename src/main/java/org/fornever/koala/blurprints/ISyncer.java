package org.fornever.koala.blurprints;

import org.fornever.koala.type.SyncSnapshotData;

/**
 * syncer interface
 * 
 * as a syncer, its need to sync data from local to remote
 * 
 * @author theosun
 *
 */
public interface ISyncer {

	/**
	 * koala will call this method to sync data to remote,
	 * <p>
	 * external logic can use this method to sync data to local.
	 * 
	 */
	void addToSyncQueue(SyncSnapshotData snapshot);

}
