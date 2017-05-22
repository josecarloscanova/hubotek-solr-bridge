package org.hubotek.model.solr;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Persistent Class that represent a query performed on Solr Server. 
 * Used to avaliate and record actions and results on a given collection.
 * 
 * @author JoseCanova
 *
 */
@Entity
@Table(name="solr_query")
public class SolrQuery extends QueryBase{

	private static final long serialVersionUID = -1694361079146467557L;
	
	@Column
	private String solrQuery;

	public SolrQuery() {
	}

	public SolrQuery(String solrQuery) {
		super();
		this.solrQuery = solrQuery;
	}



	public String getSolrQuery() {
		return solrQuery;
	}

	public void setSolrQuery(String solrQuery) {
		this.solrQuery = solrQuery;
	}

}
