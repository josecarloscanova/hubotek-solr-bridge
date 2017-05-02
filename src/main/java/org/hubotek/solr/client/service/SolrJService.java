package org.hubotek.solr.client.service;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.hubotek.solr.configuration.rdb.SolrConfiguration;

@Named(value="solrJService")
public class SolrJService {

	@Inject
	private SolrJPersistenceService solrJPersistenceService;
	
	private HttpSolrClient.Builder solrClientBuilder;
	
	public SolrJService() {
	}
	
	@PostConstruct
	void prepare()
	{ 
		loadDefaultConfiguration();
	}

	public void addNewSolrJConfiguration(SolrConfiguration solrConfiguration)
	{ 
		solrJPersistenceService.addNewConfiguration(solrConfiguration);
	}
	
	private void loadDefaultConfiguration() {
		configureSolrJBuilder(solrJPersistenceService.retrieveById(1L));
	}
	
	public void loadSolrClientConfiguration(Long configurationId) {
		configureSolrJBuilder(solrJPersistenceService.retrieveById(configurationId));
	}

	public void loadSolrClient(SolrConfiguration solrConfiguration) {
		configureSolrJBuilder(solrConfiguration);
	}
	
	private void configureSolrJBuilder(SolrConfiguration solrConfiguration) {
		solrClientBuilder = new HttpSolrClient.Builder(solrConfiguration.getSolrUrl());
	}
	
	public SolrClient loadSolrJFromCurrentConfiguration()
	{ 
		return solrClientBuilder.build();
	}
	
}
