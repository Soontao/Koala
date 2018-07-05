package org.fornever.koala.processors.entity;

import org.codehaus.groovy.syntax.ReadException;
import org.fornever.koala.exceptions.NotFoundException;

public interface IRetriveEntityProcessor<T> {

    T retrive(String key) throws NotFoundException, ReadException;

}
