package org.hubotek.solr.configuration.rdb;

import java.util.Date;

import org.hubotek.Base;
import org.hubotek.Configuration;
import org.hubotek.TemporalBase;

import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.MappedSuperclass;


@SuppressWarnings("serial")
@MappedSuperclass
public abstract class ConfigurationBase implements Base<Long> , TemporalBase<Date> , Configuration{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUpdated;
	
	public ConfigurationBase() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long t) {
		this.id = t;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

}
