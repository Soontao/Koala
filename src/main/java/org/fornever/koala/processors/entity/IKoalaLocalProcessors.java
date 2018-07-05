package org.fornever.koala.processors.entity;

import org.fornever.koala.processors.internal.IEntityValidator;

public interface IKoalaLocalProcessors<T, S> {


    IRetriveEntityProcessor<T> getLocalRetriveProcessor();

    IReadEntityProcessor<T, S> getLocalReadProcessor();

    ISaveEntityProcessor<T> getLocalSaveProcessor();

    IUpdateEntityProcessor<T> getLocalUpdateProcessor();

    IDeleteEntityProcessor getLocalDeleteProcessor();

    IKoalaKeyAccessor<T> getKeyAccessor();

    IEntityValidator<T> getLocalValidator();

    IOutOfDateChecker<T> getOutOfDateChecker();

}
