package org.hubotek.solr.client.query;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hubotek.Base;

@MappedSuperclass
public class SolrQueryBase implements Base<Long>{

	private static final long serialVersionUID = -4194796974627338479L;
	
	@Id
	private Long id; 
	
	public SolrQueryBase() {
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long t) {
		this.id = t;
	}

}
