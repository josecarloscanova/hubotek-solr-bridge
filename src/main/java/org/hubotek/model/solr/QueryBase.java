package org.hubotek.model.solr;

import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

import org.hubotek.Base;

@MappedSuperclass
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class QueryBase implements Base<Long>{

	private static final long serialVersionUID = -4194796974627338479L;
	
	@Id
	private Long id; 
	
	public QueryBase() {
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
