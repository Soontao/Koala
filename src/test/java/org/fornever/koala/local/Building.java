package org.fornever.koala.local;

public class Building {

	public Building(String name, String addr, Integer height) {
		super();
		this.name = name;
		this.addr = addr;
		this.height = height;
	}

	private String name;
	
	private String addr;
	
	private Integer height;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}
	
	
	
}
