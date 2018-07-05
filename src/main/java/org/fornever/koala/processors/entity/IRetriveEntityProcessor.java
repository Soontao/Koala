package org.fornever.koala.processors.entity;

import org.codehaus.groovy.syntax.ReadException;
import org.fornever.koala.exceptions.NotFoundException;
import org.fornever.koala.processors.IKoalaProcessor;

public interface IRetriveEntityProcessor<T> extends IKoalaProcessor {

    T retrive(String key) throws NotFoundException, ReadException;

}
