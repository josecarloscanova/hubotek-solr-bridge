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
			processQueryResponse(queryResponse);
		} catch (SolrServerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Process the query response of the server, 
	 * mount the structures to process the query. 
	 * probably after being transformed into a internal structure this 
	 * query response shall be dispatched using a queue service (mq-active queue). 
	 * 
	 * 
	 * @param queryResponse
	 */
	private void processQueryResponse(QueryResponse queryResponse) {
	}


	/**
	 * Creates a SolrQuery Object from a String passed as a parameters. 
	 * Does not guarantee that the query will run since the query is presumed 
	 * to be syntatically correct.
	 * @param queryStr
	 * @return
	 */
	private SolrQuery createSolrQuery(String queryStr) {
		SolrQuery solrQuery = new SolrQuery();
		solrQuery.setQuery(queryStr);
		return solrQuery;
	}
	
}
