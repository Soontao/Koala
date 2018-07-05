package org.fornever.koala.processors.internal;

import org.fornever.koala.entities.KoalaReferenceEntity;
import org.fornever.koala.entities.enums.EKoalaInstanceState;

import java.util.Optional;

public interface IKoalaReferenceUpdator<T> {

    void updateKoalaReference(Optional<KoalaReferenceEntity> preState, EKoalaInstanceState nextState, T entity);

}
