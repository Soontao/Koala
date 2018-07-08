package org.fornever.koala.schedule.impl;

import org.fornever.koala.schedule.ITaskQueue;

import java.util.LinkedList;

public class DefaultTaskQueue<T> extends LinkedList<T> implements ITaskQueue<T> {
}
