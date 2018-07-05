package org.fornever.koala.processors.koala;

import org.fornever.koala.entities.KoalaReferenceEntity;
import org.fornever.koala.processors.IKoalaProcessor;

public interface IKoalaReferenceUpdator<T> extends IKoalaProcessor {

    void updateKoalaReference(KoalaReferenceEntity preState,KoalaReferenceEntity nextState);

}
