package org.fornever.koala;

import java.util.List;

import org.fornever.koala.blurprints.IDataSource;
import org.fornever.koala.type.Row;
import org.fornever.koala.type.SearchParameter;

public class Koala {

	private IDataSource local;
	private IDataSource remote;

	public Koala(IDataSource local, IDataSource remote) {
		super();
		this.local = local;
		this.remote = remote;
	}

	public Row create(Row key) {
		return null;
	}

	public Boolean delete(String key) {
		return false;
	}

	public List<Row> find(SearchParameter param) {
		return null;
	}

	public IDataSource getLocal() {
		return local;
	}

	public IDataSource getRemote() {
		return remote;
	}

	public Row retrive(String key) {
		return null;
	}

	public void setLocal(IDataSource local) {
		this.local = local;
	}

	public void setRemote(IDataSource remote) {
		this.remote = remote;
	}

	public Row update(Row update) {
		return null;
	}

}
