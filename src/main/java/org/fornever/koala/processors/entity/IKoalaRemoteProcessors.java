package org.fornever.koala.processors.entity;

import org.fornever.koala.processors.entity.*;
import org.fornever.koala.processors.internal.IEntityValidator;
import org.fornever.koala.processors.entity.IKoalaKeyAccessor;

public interface IKoalaRemoteProcessors<T, S> {

    IRetriveEntityProcessor<T> getRemoteRetriveProcessor();

    IReadEntityProcessor<T, S> getRemoteReadProcessor();

    ISaveEntityProcessor<T> getRemoteSaveProcessor();

    IUpdateEntityProcessor<T> getRemoteUpdateProcessor();

    IDeleteEntityProcessor getRemoteDeleteProcessor();

    IKoalaKeyAccessor<T> getKeyAccessor();

    IEntityValidator<T> getRemoteValidator();

}
