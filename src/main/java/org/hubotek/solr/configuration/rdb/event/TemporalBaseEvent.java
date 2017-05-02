package org.hubotek.solr.configuration.rdb.event;


import java.util.Date;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.hubotek.TemporalBase;

public class TemporalBaseEvent {

	public TemporalBaseEvent() {
	}
	
	@PrePersist
	public void onPrePersist(TemporalBase<Date> tb) 
	{
		tb.setDateCreated(new Date());
	}
	
	@PreUpdate
	public void onPreUpdate(TemporalBase<Date> tb)
	{ 
		tb.setDateUpdated(new Date());
	}

}
