package org.fornever.koala.processors.entity;

import org.fornever.koala.exceptions.NotFoundException;
import org.fornever.koala.exceptions.ReadFailedException;

import java.util.List;


public interface IReadEntityProcessor<T, S> {

    List<T> read(S searchParameter) throws ReadFailedException, NotFoundException;

}
