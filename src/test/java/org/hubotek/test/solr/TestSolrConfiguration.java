package org.hubotek.test.solr;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import org.hubotek.solr.client.service.SolrJPersistenceService;
import org.hubotek.solr.configuration.rdb.SolrConfiguration;
import org.hubotek.solr.configuration.rdb.SolrConfigurationSettings;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class TestSolrConfiguration extends BaseEarModelDeployer {

	@PersistenceContext
    protected EntityManager entityManager;
    
    @Inject
    protected UserTransaction utx;
    
	@Inject
	private SolrJPersistenceService solrConfigurationPersistenceService;
	
	@Test
	public void test_solr_configuration_persistence() throws Exception
	{ 
		Assert.assertNotNull(solrConfigurationPersistenceService);
		SolrConfiguration solrConfiguration = new SolrConfiguration();
		solrConfiguration.setSolrUrl("http://localhost");
		addSolrConfigurationToRdbms(solrConfiguration);
		Assert.assertNotNull(solrConfiguration.getId());
		Assert.assertNotNull(solrConfiguration.getDateCreated());
		detachSolrConfigurationFromRdbms(solrConfiguration);
		SolrConfiguration updatedSolrConfiguration = updateSolrConfiguratoinToRdbms(solrConfiguration);
		flush();
		Assert.assertNotNull(updatedSolrConfiguration.getDateUpdated());
	}
	
	private void flush() {
		entityManager.flush();
	}

	public void test_solr_configuration_settings_persistence() throws Exception
	{ 
		Assert.assertNotNull(solrConfigurationPersistenceService);
		SolrConfigurationSettings settings = new SolrConfigurationSettings();
		settings.setConnectionTimeout(1000);
		settings.setDefaultMaxConnectionsPerHost(1000);
		settings.setFollowRedirects(true);
		settings.setMaxRetries(10);
		settings.setMaxTotalConnections(1000);
		settings.setSoTimeout(1000);
		addSolrSettingsToRdbms(settings);
		SolrConfiguration solrConfiguration = new SolrConfiguration();
		solrConfiguration.setSolrUrl("http://localhost");
	}
	
	private void addSolrSettingsToRdbms(SolrConfigurationSettings settings) {
		entityManager.persist(settings);
	}
	
	private void addSolrConfigurationToRdbms(SolrConfiguration solrConfiguration) {
		entityManager.persist(solrConfiguration);
	}

	private void detachSolrConfigurationFromRdbms(SolrConfiguration solrConfiguration) {
		entityManager.detach(solrConfiguration);
	}
	
	private SolrConfiguration updateSolrConfiguratoinToRdbms(SolrConfiguration solrConfiguration) {
		return entityManager.merge(solrConfiguration);
	}
	
	@Before
	public void start_transaction() throws Exception
	{ 
		beginTransaction();
	}
	
	@After 
	public void end_transaction() throws Exception
	{ 
		commitTransaction();
	}
	
    protected void beginTransaction() throws Exception
	{ 
		utx.begin();  
		entityManager.joinTransaction(); 
	}
	
	protected void commitTransaction() throws Exception
	{ 
		utx.commit();
	}
}
