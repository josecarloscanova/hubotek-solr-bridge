package org.hubotek.solr.queue;

import javax.annotation.Resource;
import javax.jms.ConnectionFactory;
import javax.jms.Queue;

import org.apache.solr.client.solrj.response.QueryResponse;
import org.hubotek.Dispatcher;

public class SolrJmsDispatcher implements Dispatcher<QueryResponse> {

	@Resource(lookup = "java:comp/DefaultJMSConnectionFactory")
	private static ConnectionFactory connectionFactory;

	@Resource(lookup = "jms/MyQueue")
	private static Queue queue;
	
	public SolrJmsDispatcher() {
	}

	@Override
	public void send(QueryResponse t) {
	}

}
