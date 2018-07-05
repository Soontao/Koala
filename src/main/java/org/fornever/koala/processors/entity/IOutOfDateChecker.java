package org.fornever.koala.processors.entity;

import org.fornever.koala.exceptions.DataOutOfDateException;

public interface IOutOfDateChecker<T> {

    Boolean outOfDate(T local, T remote) throws DataOutOfDateException;

}
