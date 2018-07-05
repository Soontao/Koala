package org.fornever.koala.processors.entity;

import org.fornever.koala.exceptions.NotFoundException;
import org.fornever.koala.exceptions.ReadFailedException;
import org.fornever.koala.processors.IKoalaProcessor;

import java.util.List;


public interface IReadEntityProcessor<T, S> extends IKoalaProcessor {

    List<T> read(S searchParameter) throws ReadFailedException, NotFoundException;

}
