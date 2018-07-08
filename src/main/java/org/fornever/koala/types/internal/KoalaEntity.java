package org.fornever.koala.types.internal;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public class KoalaEntity {

	/**
	 * The primary key
	 */
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long koalaID;

	/**
	 * instance created date
	 * <p>
	 * creation date time
	 */
	@Column
	private Date koalaCreateDate;
	/**
	 * instance updated date
	 * <p>
	 * update date time
	 */
	@Column
	private Date koalaUpdateDate;

	/**
	 * wether this types persisted to remote system
	 * <p>
	 * when update, check this flag firstly
	 */
	@Column
	private Boolean remotePersisted = false;

	public Long getKoalaID() {
		return koalaID;
	}

	public KoalaEntity setKoalaID(Long koalaID) {
		this.koalaID = koalaID;
		return this;
	}

	public Boolean getRemotePersisted() {
		return remotePersisted;
	}

	public KoalaEntity setRemotePersisted(Boolean remotePersisted) {
		this.remotePersisted = remotePersisted;
		return this;
	}

	/**
	 * @return the koalaCreateDate
	 */
	public Date getKoalaCreateDate() {
		return koalaCreateDate;
	}

	/**
	 * @param koalaCreateDate the koalaCreateDate to set
	 */
	public void setKoalaCreateDate(Date koalaCreateDate) {
		this.koalaCreateDate = koalaCreateDate;
	}

	/**
	 * @return the koalaUpdateDate
	 */
	public Date getKoalaUpdateDate() {
		return koalaUpdateDate;
	}

	/**
	 * @param koalaUpdateDate the koalaUpdateDate to set
	 */
	public void setKoalaUpdateDate(Date koalaUpdateDate) {
		this.koalaUpdateDate = koalaUpdateDate;
	}

	@PrePersist
	protected void onCreate() {
		this.koalaCreateDate = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.koalaUpdateDate = new Date();
	}

}
