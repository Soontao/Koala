package org.fornever.koala.exceptions;

import org.fornever.koala.types.enums.EOperationType;
import org.fornever.koala.types.internal.KoalaEntity;

public class WriteFailedException extends KoalaBaseException {

	private KoalaEntity entity;

	private EOperationType type;

	public WriteFailedException(KoalaEntity entity, EOperationType type) {
		super();
		this.entity = entity;
		this.type = type;
	}

	public KoalaEntity getEntity() {
		return entity;
	}

	public WriteFailedException setEntity(KoalaEntity entity) {
		this.entity = entity;
		return this;
	}

}
