package org.fornever.koala.types;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class MobilePhone implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String phoneNumber;
	@Column
	private String phoneOwnerName;

	public Long getId() {
		return id;
	}

	public MobilePhone setId(Long id) {
		this.id = id;
		return this;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public MobilePhone setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
		return this;
	}

	public String getPhoneOwnerName() {
		return phoneOwnerName;
	}

	public MobilePhone setPhoneOwnerName(String phoneOwnerName) {
		this.phoneOwnerName = phoneOwnerName;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof MobilePhone)) return false;
		MobilePhone that = (MobilePhone) o;
		return Objects.equals(getId(), that.getId()) &&
				Objects.equals(getPhoneNumber(), that.getPhoneNumber()) &&
				Objects.equals(getPhoneOwnerName(), that.getPhoneOwnerName());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getPhoneNumber(), getPhoneOwnerName());
	}

	@Override
	public String toString() {
		return "MobilePhone{" +
				"id=" + id +
				", phoneNumber='" + phoneNumber + '\'' +
				", phoneOwnerName='" + phoneOwnerName + '\'' +
				'}';
	}
}
