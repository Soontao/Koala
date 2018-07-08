package org.fornever.koala.types.internal;

import org.fornever.koala.types.enums.EOperationType;

import java.util.Date;

public class KoalaSyncTask {


	private String id;

	private Integer retryCount = 0;

	private EOperationType operation;

	private Date taskCreatedDate = new Date();

	public KoalaSyncTask(KoalaReferenceEntity ref) {
		this.id = ref.getRefID();
		this.taskCreatedDate = ref.getUpdateAt();
		switch (ref.getState()) {
			case WILL_CREATE:
				this.operation = EOperationType.SAVE;
				break;
			case WILL_UPDATE:
				this.operation = EOperationType.UPDATE;
				break;
			case WILL_DELETE:
				this.operation = EOperationType.DELETE;
				break;
		}

	}


}
