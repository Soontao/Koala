package org.fornever.koala.local;

public class Building {

	private String name;

	private String addr;

	private Integer height;

	public Building(String name, String addr, Integer height) {
		super();
		this.name = name;
		this.addr = addr;
		this.height = height;
	}

	public String getAddr() {
		return addr;
	}

	public Integer getHeight() {
		return height;
	}

	public String getName() {
		return name;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public void setName(String name) {
		this.name = name;
	}

}
