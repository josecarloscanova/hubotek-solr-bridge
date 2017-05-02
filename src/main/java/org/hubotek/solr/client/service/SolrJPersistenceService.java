package org.hubotek.solr.client.service;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hubotek.solr.configuration.rdb.SolrConfiguration;

@Named(value="solrJConfigurationPersistenceService")
public class SolrJPersistenceService {

	@PersistenceContext
	EntityManager solrEntityManager;
	
	public SolrJPersistenceService(){
	}
	
	public void addNewConfiguration(SolrConfiguration solrConfiguration)
	{
		solrEntityManager.persist(solrConfiguration);
	}

	public void removeConfigurationById(Long id)
	{
		StringBuilder sb = new StringBuilder().append("delete from SolrConfiguration sc where sc.id = ").append(id);
		solrEntityManager.createQuery(sb.toString()).executeUpdate();
	}
	
	public void removeConfiguration(SolrConfiguration solrConfiguration)
	{
		solrEntityManager.remove(solrConfiguration);
	}
	
	public SolrConfiguration retrieveById(Long id)
	{
		StringBuilder sb = new StringBuilder().append("from SolrConfiguration sc where sc.id = ").append(id);
		return solrEntityManager.createQuery(sb.toString() , SolrConfiguration.class).getSingleResult();
	}
	
}
