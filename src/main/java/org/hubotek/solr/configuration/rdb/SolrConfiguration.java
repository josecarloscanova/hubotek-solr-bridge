package org.hubotek.solr.configuration.rdb;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;

import org.hubotek.solr.configuration.rdb.event.TemporalBaseEvent;

@Entity
@EntityListeners(TemporalBaseEvent.class)
public class SolrConfiguration extends ConfigurationBase{

	private static final long serialVersionUID = 5677396153797540279L;
	
	@Column(name="solr_url" , length=2000 , insertable=true , nullable=false , updatable=true)
	private String solrUrl;
	
	@Enumerated
	private SolrClientType solrClientType;
	
	@Column(name="allow_compression" , nullable=true)
	private Boolean allowCompression;
	
	@OneToMany
	private List<SolrConfigurationSettings> configurations;
	
	public SolrConfiguration() {
	}

	public String getSolrUrl() {
		return solrUrl;
	}

	public void setSolrUrl(String solrUrl) {
		this.solrUrl = solrUrl;
	}

	public List<SolrConfigurationSettings> getConfigurations() {
		return configurations;
	}

	public void setConfigurations(List<SolrConfigurationSettings> configurations) {
		this.configurations = configurations;
	}

	public SolrClientType getSolrClientType() {
		return solrClientType;
	}

	public void setSolrClientType(SolrClientType solrClientType) {
		this.solrClientType = solrClientType;
	}

	public Boolean getAllowCompression() {
		return allowCompression;
	}
	
	public void setAllowCompression(Boolean allowCompression) {
		this.allowCompression = allowCompression;
	}

}