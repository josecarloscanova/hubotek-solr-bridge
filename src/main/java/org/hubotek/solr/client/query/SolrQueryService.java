package org.hubotek.solr.client.query;

import java.io.IOException;

import javax.inject.Inject;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.hubotek.solr.client.service.SolrJService;

public class SolrQueryService {

	@Inject
	SolrJService solrService;

	public SolrQueryService() {
	}

	//TODO: Read QueryResponse and QueryResponseBase classes.
	public void processQuery(String queryStr)
	{ 
		SolrClient solrClient = solrService.loadSolrJFromCurrentConfiguration();
		SolrQuery solrQuery = createSolrQuery(queryStr);
		try {
			QueryResponse queryResponse = solrClient.query(solrQuery);
		} catch (SolrServerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//TODO: Read QueryResponse and QueryResponseBase classes.
	public void processQuery(String queryStr , SolrQueryParameters solrQueryParameters)
	{ 
		SolrClient solrClient = solrService.loadSolrJFromCurrentConfiguration();
		SolrQuery solrQuery = createSolrQuery(queryStr , solrQueryParameters);
		try {
			QueryResponse queryResponse = solrClient.query(solrQuery);
		} catch (SolrServerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private SolrQuery createSolrQuery(String queryStr) {
		SolrQuery solrQuery = new SolrQuery();
		solrQuery.setQuery(queryStr);
		return solrQuery;
	}
	
	private SolrQuery createSolrQuery(String queryStr, SolrQueryParameters solrQueryParameters) {
		return null;
	}

}
